package com.Controller;

import cn.dsna.util.images.ValidateCode;
import com.Dao.DirectoryDao;
import com.Dao.NoteDao;
import com.Dao.NoteUserDao;
import com.Entity.JsonString;
import com.Entity.Note;
import com.Entity.NoteUser;
import com.Service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private NoteUserDao noteUserDao;
    @Autowired
    private DirectoryDao directoryDao;

    @RequestMapping("/code")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        request.getSession().setAttribute("code",vc.getCode());
        try {
            vc.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("验证码出错了");
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/checklogin", method=RequestMethod.POST)
    public String checkLogin(Map<String,Object> map, HttpServletRequest request, @RequestParam("thecode") String thecode, NoteUser noteuser){
        boolean rs=userService.checkPassWord(noteuser,(String)request.getSession().getAttribute("code"),thecode,request);
      /*  String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";*/
        System.out.println(rs);
        String imgPath="";
        if(rs){
            System.out.println("success"+"black");
            /*1将用户信息放到session(在服务测做好了)
            * 2.根据用户id查询用户所有笔记简单信息
            * 3.将查询出来的第一笔记问价具体内容交给富文本显示，所有的标签信息一并显示*/
            NoteUser sessionUser =(NoteUser)request.getSession().getAttribute("userInfo");
            imgPath=request.getContextPath()+"uploadDirectory/"+sessionUser.getUserid()+"/imgs";
            System.out.println(sessionUser);
            List<Note>  notes=noteDao.getUserAllNotes(sessionUser.getUserid());
            for (Note note : notes) {
                System.out.println(note);
            }
            map.put("notes",notes);
            map.put("imgPath",imgPath);
            map.put("dForder",directoryDao.getDefaultForder(sessionUser.getUserid()));
            if(notes.size()>0) {
                Note note = noteDao.getOneNoteWithLabels(((Note) notes.get(0)).getNoteid());
                System.out.println(note);
                /*根据相应的笔记信息，获得文件内容，将文件内容转为NRC
                * */
                map.put("note",note);
            }else{
                Note note1 = new Note();
                note1.setLabelnum(0);
                note1.setNoteid(-1);
                map.put("note",note1);
            }

            return "blank";
        }else{
            return "blank";
        }
    }

    @RequestMapping(value="/getUserInfo",method=RequestMethod.POST)
    @ResponseBody
    public NoteUser getUserInfo(HttpServletRequest request){
        String uuid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        System.out.println(uuid);
        NoteUser userDetial=noteUserDao.getUserInfo(uuid);

        return userDetial;
    }

    @RequestMapping(value="/changUserInfo",method=RequestMethod.POST)
    @ResponseBody
    public String changUserInfo(NoteUser noteUser){
        System.out.println(noteUser);
        boolean rs=noteUserDao.updateUserInfo(noteUser);
        System.out.println(rs);
        if(rs){
            return "{\"message\":\"修改成功\"}";
        }else{
            return "{\"message\":\"修改失败\"}";
        }
    }

   @RequestMapping(value="/upheadimg" , method = RequestMethod.POST)
    @ResponseBody
    public JsonString upheadimg(@RequestParam("headimg") MultipartFile file,HttpServletRequest request){
        /*查看用户id路径下是否存在头像文件夹，如果不存在就添加一个，并将图片放入其中，
        * 如果存在，查看删除其中的文件，并将文件放入
        *设置用户信息中img，返回上传结果*/

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        String path=request.getServletContext().getRealPath("/")+"uploadDirectory/"+((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        File headImgFile=new File(path,"headImgFile");
        String userid=((NoteUser) request.getSession().getAttribute("userInfo")).getUserid();
        /*是否是图片类型*/
        List<String> filesufixs=new ArrayList<String>();
        filesufixs.add("jpg");
        filesufixs.add("png");
        filesufixs.add("jpeg");
        filesufixs.add("gif");
        JsonString jsonString=new JsonString();



        System.out.println(file.getOriginalFilename().split("\\.").length);
        String[] ha=file.getOriginalFilename().split("\\.");
        String headimg=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+new Random().nextInt(1000)+"."+ha[1];
        File img=new File(headImgFile,headimg);
        if(filesufixs.contains(ha[1])){
            if(!headImgFile.exists()){
                headImgFile.mkdirs();
            }

            try {
                img.createNewFile();
                file.transferTo(img);
            } catch (IOException e) {
                NoteUser noteUser= noteUserDao.getUserInfo(userid);
                jsonString.setUrl(request.getContextPath()+"/uploadDirectory/"+userid+"/headImgFile/"+noteUser.getImg());
                jsonString.setMessage("上传失败");
                return jsonString;
            }
        }else{
            jsonString.setMessage("图片类型不支持");
            return jsonString;
        }

        String returnpath=request.getContextPath()+"/uploadDirectory/"+userid+"/headImgFile/"+headimg;

       for (File file1 : headImgFile.listFiles()) {
           file1.getName().equals(headimg);
       }
        noteUserDao.updateUserImg(headimg,userid);
        jsonString.setUrl(returnpath);
        jsonString.setMessage("上传成功");
        return jsonString;
    }
}
