package com.Controller;

import Utils.MD5;
import com.Dao.*;
import com.Entity.Directory;
import com.Entity.JsonString;
import com.Entity.Note;
import com.Entity.NoteUser;
import com.Service.NoteService;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@CrossOrigin
public class NoteController {

    @Autowired
    private NoteMapper noteMapper;
    @Autowired
    private DirectoryMapper directoryMapper;

    @PutMapping(value="/api/Note")
    @ResponseBody
    public Map<String,Object> creatNote(@RequestBody Map<String,Object> paramMap){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 20000);
        data.put("message", "put = create");
        return data;
    }

    @PostMapping(value="/api/Note")
    @ResponseBody
    public Map<String,Object> uploadNote(@RequestBody Map<String,Object> paramMap){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 20000);
        data.put("message", "post = update");
        return data;
    }

//    @RequestMapping("/api/checkNoteName")
//    @ResponseBody
//    public Map<String,Object> checkNoteName(@RequestBody Map<String,Object> paramMap){
//
//    }

//    @RequestMapping("/api/createNote")
//    @ResponseBody
//    public Map<String,Object> createNote(@RequestBody Map<String,Object> paramMap){
//
//    }

    @GetMapping("/api/Note/{id}")
    @ResponseBody
    public Map<String,Object> openNote(@PathVariable Integer id){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 20000);
        data.put("message", "get = get" + id);
        return data;
    }

    @DeleteMapping("/api/Note/{id}")
    @ResponseBody
    public Map<String,Object> deleteNote(@PathVariable Integer id){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 20000);
        data.put("message", "get = delete" + id);
        return data;
    }

   /* @RequestMapping(value="/search",method=RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> search(@RequestBody Map<String,Object> paramMap){

    }*/


}

 /*@Autowired
    private NoteService noteService;

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private NoteUserDao noteUserDao;

    @Autowired
    private DirectoryDao directoryDao;

    @RequestMapping(value="/renameNote",method = RequestMethod.POST)
    @ResponseBody
    public JsonString renameNote(Note note, HttpServletRequest request){
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        int noteid=note.getNoteid();
        String dirid=noteDao.getDirOfNote(noteid);
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String notePath=rootPath+userid+"/notedirectory/"+dirid;

        boolean rs=noteService.checkNoteName(userid,note.getDirectoryid(),note.getFilename());

        JsonString jsonString = new JsonString();
        if(!rs){
            jsonString.setMessage(noteService.unUserName(userid,note.getDirectoryid(),note.getFilename()));
            jsonString.setStatuid("4002");
            return jsonString;
        }else {
            String oldFilename=noteDao.getNoteFilename(note.getNoteid());

            boolean rs1=noteService.changeOneNote(note.getNoteid(),note.getFilename());
            File filente=new File(notePath,oldFilename+".html");
            if(filente.exists()){
                filente.renameTo(new File(notePath,note.getFilename()+".html"));
            }
            if(rs1) {
                jsonString.setMessage("修改文件名成功");
                jsonString.setStatuid("2001");
                return jsonString;
            }else{
                jsonString.setMessage("修改文件名失败");
                jsonString.setStatuid("4001");
                return jsonString;
           }
       }
    }

    @RequestMapping(value="/createCheckNote",method = RequestMethod.POST)
    @ResponseBody
    public JsonString createNote(Note note, HttpServletRequest request) {
        String userid = ((NoteUser) request.getSession().getAttribute("userInfo")).getUserid();
        boolean rs = noteService.checkNoteName(userid, note.getDirectoryid(), note.getFilename());

        JsonString jsonString = new JsonString();
        if (!rs) {
            jsonString.setMessage(noteService.unUserName(userid, note.getDirectoryid(), note.getFilename()));
            jsonString.setStatuid("4002");
            return jsonString;
        } else {
            jsonString.setMessage("文件名没重复");
            jsonString.setStatuid("2002");
            return jsonString;
        }
    }

    @RequestMapping(value="/toRejister",method = RequestMethod.GET)
    public String toRejester(){
        return "register";
    }

    @RequestMapping(value="/checkEmail",method = RequestMethod.POST)
    @ResponseBody
    public String checkEmail(@RequestParam("email")String email){
        String emailStr=noteUserDao.getEmail(email);
        JSONObject json=new JSONObject();
        if(emailStr!=null){
            json.put("message","401");
        }else{
            json.put("message","201");
        }

        return json.toJSONString();
    }

    @RequestMapping(value="/rejest",method = RequestMethod.POST)
    @ResponseBody

    public String rejest(NoteUser user,HttpServletRequest request){
        *//*设置用户的基本信息*//*
        user.setUse(0);
        user.setLogo("我好像没什么要说的");
        user.setAddress("未知");
        user.setType(1);
        user.setDatalocation("D:\\mynotebook\\data");
        user.setGender(3);
        user.setUserid(UUID.randomUUID().toString().replace("-",""));
        user.setTotal(3);
        user.setUsed(0);;
        user.setPassword(MD5.strToMd5(user.getPassword()));
        *//*设置用户的初始文件夹*//*
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=user.getUserid();
        File userFile=new File(rootPath,userid);
        File headImgFile=new File(rootPath+userid,"headImgFile");
        File imgsFile=new File(rootPath+userid,"imgs");
        File indexDBFile=new File(rootPath+userid,"indexDB");
        File notedirecotryFile=new File(rootPath+userid,"notedirecoty");

        userFile.mkdirs();
        headImgFile.mkdirs();
        imgsFile.mkdirs();
        indexDBFile.mkdirs();
        notedirecotryFile.mkdirs();


        String directoryid=UUID.randomUUID().toString().replace("-","");
        String notepath=rootPath+userid+"/notedirectory/"+directoryid;

        File notePathFile=new File(notepath);
        notePathFile.mkdirs();

        *//*插入数据库*//*
        Directory directory=new Directory();
        directory.setIsdlocked("no");
        directory.setUserid(userid);
        directory.setIsddele("no");
        directory.setDirectory("我的文件夹");
        directory.setDirectoryid(directoryid);
        directory.setDefuatForder("yes");

        noteUserDao.insertUser(user);
        directoryDao.insertOneDirectory(directory);

        JSONObject json=new JSONObject();
        json.put("message","201");
        return json.toJSONString();
    }*/