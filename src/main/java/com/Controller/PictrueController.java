package com.Controller;

import Utils.*;
import com.Dao.*;
import com.Entity.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.transport.proxy.HttpReceiveSocket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
public class PictrueController {
    @Autowired
    private UserMapper userMapper;


    List<String> imgSupportSubfixs = Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "tiff");



    @PostMapping(value="/api/header")
    @ResponseBody
    public Map<String,Object> uploadHeadImg(@RequestParam("avatar")  MultipartFile fileImg,HttpServletRequest request){

        String headUploadPath = GlobalValue.getUploadDirectory(request)+"/header";
        String uid = (String) request.getAttribute("uid");
        String fileName = fileImg.getOriginalFilename();
        String fileNameSubfix = fileName.substring(fileName.lastIndexOf(".")+1);
        if(!imgSupportSubfixs.contains(fileNameSubfix)){
            Result.createResult(20400, "不支持该格式", null);
        }
        File dir = new File(headUploadPath);
        File[] files = dir.listFiles();
        Arrays.stream(dir.listFiles()).filter(file -> file.getName().substring(0,file.getName().lastIndexOf(".")).contains(uid)).forEach(file -> {file.delete();});
        String newFilename = uid + new SimpleDateFormat("yyMMDDHHmmss").format(new Date()) + "." + fileNameSubfix;
        File file = new File(headUploadPath,newFilename);
        try {
            file.createNewFile();
            fileImg.transferTo(file);
        } catch (IOException e) {
            return Result.createResult(50400, "图片存储时发生错误，稍后再试", null);
        }
        int size = (int)fileImg.getSize()/1000;
        User user = userMapper.selectByPrimaryKey(uid);
        user.setUsed(size + user.getUsed());
        user.setVatar(newFilename);
        userMapper.updateByPrimaryKeySelective(user);
        return Result.createResult(20000, "success", null);
    }

   /* @Autowired
    private NoteDao noteDao;
    @Autowired
    private DirectoryDao directoryDao;

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private NoteUserDao noteUserDao;

    @RequestMapping(value="/uploadImg" , method=RequestMethod.POST)
    @ResponseBody
    public String uploadImg(HttpServletRequest request,@RequestParam("uploadFile") MultipartFile mfile){

        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        String directory="imgs";
        String savePath=rootPath+userid+"/"+directory;
//文件保存目录URL
        String saveUrl  = request.getContextPath() + "/uploadDirectory"+"/"+userid+"/"+directory;
        System.out.println("上传图片");
        System.out.println(savePath);
        System.out.println(saveUrl);
//定义允许上传的文件扩展名
        HashMap<String, String> extMap = new HashMap<String, String>();
        extMap.put("image", "gif,jpg,jpeg,png,bmp");
        *//*extMap.put("flash", "swf,flv");
        extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        extMap.put("file", "doc,docx,xls,xlsx,ppt,txt,zip,rar,gz,bz2");*//*

//最大文件大小
        long maxSize = 1000000;
        JSONObject obj=new JSONObject();
        if(!ServletFileUpload.isMultipartContent(request)){
            obj.put("error", 1);
            obj.put("message", "请选择图片");
            return obj.toJSONString();
        }
//检查目录
        *//*用户目录*//*
        File uploadDir = new File(rootPath+userid);
        if(!uploadDir.isDirectory()){
            uploadDir.mkdir();
        }
//检查目录写权限
        if(!uploadDir.canWrite()){

            obj.put("error", 1);
            obj.put("message", "没有写权限");
            return obj.toJSONString();
        }
//检查目录类型
        String dirName = request.getParameter("dir");
        if (dirName == null) {
            dirName = "image";
        }
        if(!extMap.containsKey(dirName)){

            obj.put("error", 1);
            obj.put("message", "目录名称不正确");
            return obj.toJSONString();
        }
//创建文件夹
       *//* savePath += dirName + "/";
        saveUrl += dirName + "/";
        File saveDirFile = new File(savePath);
        if (!saveDirFile.exists()) {
            saveDirFile.mkdirs();
        }*//*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String ymd = sdf.format(new Date());
       *//* savePath += ymd + "/";
        saveUrl += ymd + "/";*//*
       *//*图片存储目录*//*
        File dirFile = new File(savePath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }

        *//*FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        List items = null;
        try {
            items = upload.parseRequest(request);
            System.out.println(items.size());
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator itr = items.iterator();*//*
        *//*文件大小检查*//*
        *//*文件后缀名检查*//*
        *//*文件上传，路径返回*//*

        long mfsize=mfile.getSize();
        if(mfsize>maxSize){

            obj.put("error",1);
            obj.put("message","图片过大");
            return obj.toJSONString();
        }

        String filename=mfile.getOriginalFilename();
        String fileExt=filename.substring(filename.lastIndexOf('.')+1).toLowerCase();
        if(!Arrays.asList(extMap.get("image").split(",")).contains(fileExt)){

            obj.put("error",1);
            obj.put("message","上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
            return obj.toJSONString();

        }

        *//*修改成独一无二的文件名*//*
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
        filename=format.format(new Date())+new Random().nextInt(10000)+"."+fileExt;
        *//*图片位置*//*
        File imgfile=new File(savePath,filename);
        if(!imgfile.exists()){
            try {
                imgfile.createNewFile();
                mfile.transferTo(imgfile);
            } catch (IOException e) {
                e.printStackTrace();

                obj.put("error",1);
                obj.put("message","上传文件失败");
                return obj.toJSONString();

            }
        }
        obj.put("error", 0);
        obj.put("url", saveUrl+"/"+filename);
        return obj.toJSONString();
    }


    @RequestMapping(value="/uploadNote",method=RequestMethod.POST)
    @ResponseBody
    public JsonString  uploadNote(Note note,@RequestParam(value = "content",defaultValue ="") String contentk,HttpServletRequest request){
        *//*上传文件三种情况

                2.修改已有文件：文件id和文件所在文件夹以及文件名都不为空。
                    1.得到文件id，修改必要信息：如修改时间，文件大小等
                    根据文件id修改原文件索引。
                    读取图片路径，存入数据库
                    对文件进行读写操作
                    数据库修改信息
                3.文件id，文件夹id，文件内容都为空,表示当前没有打开文件。
         *//*

        System.out.println("upload175"+note);
        System.out.println(note.getNoteid()==-1&&note.getDirectoryid().equals("no")&&note.getFilename().equals(""));
        JsonString jsonStrin=new JsonString();
        if(note.getNoteid()==-1&&note.getDirectoryid().equals("no")&&note.getFilename().equals("")){
            jsonStrin.setStatuid("2006");
            jsonStrin.setMessage("未打开文件，不用上传");
            return jsonStrin;
        }else if(note.getNoteid()!=-1&&!note.getDirectoryid().equals("no")){//修改文件
            *//*1.得到文件id，修改必要信息：如修改时间，文件大小等*//*
            note.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            note.setSize(contentk.getBytes().length);

            String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
            String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
            String notepath=rootPath+userid+"/notedirectory/"+note.getDirectoryid();
            String noteDB=rootPath+userid+"/indexDB";

            String returnpath=request.getContextPath()+"/uploadDirectory/"+userid+"/imgs";
            *//*根据文件id修改原文件索引。*//*
            boolean rs=LuceneUtil.updateLuceneIndex(note,contentk,noteDB);
            if(!rs){
                jsonStrin.setStatuid("4006");
                jsonStrin.setMessage("索引创建失败");
                return jsonStrin;
            }

            jsonStrin.setUrl("");

            if(contentk!=null){
                List<String> urls=ImgUrl.getHtmlImgUrl(contentk);
                noteDao.deleteImgsOfNote(note.getNoteid());
                if(urls.size()>0) {
                    for (String url : urls) {
                        System.out.println(url);
                        Img imge=new Img();
                        String imgname=url.substring(url.lastIndexOf("/")+1,url.length());
                        System.out.println(imgname);
                        File img = new File(rootPath+userid+"/imgs/"+imgname);
                        imge.setImgsize(img.length());
                        imge.setImgid(UUID.randomUUID().toString().substring(0,31));
                        imge.setIngname(imgname);
                        imge.setNoteid(note.getNoteid());
                        imge.setUserid(userid);
                        imge.setIsdelete("no");
                        jsonStrin.setUrl(returnpath+"/"+imgname);
                        noteDao.inserOneImg(imge);
                    }
                }
            }

            File file=new File(notepath);
            if(!file.exists()){
                file.mkdirs();
            }

           *//* 对文件进行读写操作*//*
            File notefile = new File(notepath,note.getFilename()+".html");
            try {
                if(!notefile.exists()) {
                    notefile.createNewFile();
                }
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(notefile)));
                contentk="<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"></head><body>"+contentk+"</body></html>";
                contentk=contentk.replace("class=\"mybg\"","");
                StringBuffer abs= new StringBuffer();

                int i=0;
                while(abs.length()<23&&i<contentk.length()){
                    char c=contentk.charAt(i);
                    if(c>127){
                        abs.append(c);
                    }
                    i++;
                }
                String abstractnote=abs.toString();
                note.setAbstractnote(abstractnote);
                contentk=contentk.replace("style=\"background-color:red;\"","");
                bufferedWriter.write(contentk);//以默认系统默认的编码将内容存入文件
                bufferedWriter.close();
            } catch (FileNotFoundException e) {
                jsonStrin.setStatuid("4007");
                jsonStrin.setMessage("写入笔记时，文件不存在");
                e.printStackTrace();
                return jsonStrin;
            } catch (IOException e) {
                jsonStrin.setStatuid("4008");
                jsonStrin.setMessage("写入笔记时，文件创建失败");
                System.out.println("文件创建失败");
                e.printStackTrace();
                return jsonStrin;
            }
        }

        System.out.println(note);

        *//*数据库修改信息*//*
        noteDao.updataNoteChange(note);
        jsonStrin.setStatuid("2006");
        jsonStrin.setMessage("上传成功");
        return jsonStrin;
    }

    @RequestMapping("/createNote")
    @ResponseBody
    public String createNote(Note note,HttpServletRequest request,String content) throws JsonProcessingException {
        *//*新建笔记，知道userid，directoryid ，filename，设置所有必须的默认信息
        * 文件内容是空的
        * 1.创建相应的文件 2.创建索引 3.插入数据库*//*

        System.out.println(note);
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        NoteUser noteUser=((NoteUser)request.getSession().getAttribute("userInfo"));
        String userid=noteUser.getUserid();
        String notepath=rootPath+userid+"/notedirectory/"+note.getDirectoryid();
        String noteDB=rootPath+userid+"/indexDB";

        JSONObject jsonObject=new JSONObject();

        note.setUserid(userid);
        note.setUsername(noteUser.getUsername());
        note.setCreatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        note.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        note.setIslocked("no");
        note.setIsdele("no");
        note.setSize(0);
        note.setLabelnum(0);
        String directory=directoryDao.getDirectory(note.getDirectoryid());
        note.setDirectory(directory);
        note.setAbstractnote("这是一个新建的笔记");



        String filename =note.getFilename();
        File filenotepath=new File(notepath);
        if(!filenotepath.exists()){
            filenotepath.mkdirs();
        }
        System.out.println(filenotepath.getPath());
        File filenoteDB=new File(noteDB);
        if(!filenoteDB.exists()){
            filenoteDB.mkdirs();
        }
        System.out.println("createNote290:"+filenoteDB.getPath());

        File filenote=new File(notepath,note.getFilename()+".html");
        try {
            if (!filenote.exists()) {
                filenote.createNewFile();
            }
        }catch (IOException e) {

            jsonObject.put("statuid","4008");
            jsonObject.put("message","写入笔记时，文件创建失败");
            System.out.println("文件创建失败");
            e.printStackTrace();
            return jsonObject.toJSONString();
        }

        boolean rsMysql=noteDao.insertOneNote(note);

        Note note1=noteDao.checkNoteName(userid,note.getFilename(),note.getDirectoryid());
        note.setNoteid(note1.getNoteid());

        boolean rsLucene=LuceneUtil.createLuceneIndex(note,content,noteDB);
        if(!rsLucene){

            jsonObject.put("statuid","4010");
            jsonObject.put("message","索引创建失败");
            return jsonObject.toJSONString();
        }

        if(rsMysql){
            JsonString jsonString=new JsonString();
            jsonString.setStatuid("2007");
            jsonString.setMessage("笔记创建成功");

            List<Note> lists=new ArrayList<>();
            lists.add(note);
            jsonString.setLists(lists);
            ObjectMapper objectMapper=new ObjectMapper();
            return objectMapper.writeValueAsString(jsonString);
        }else{

            jsonObject.put("statuid","4009");
            jsonObject.put("message","笔记创建失败");
            return jsonObject.toJSONString();
        }
    }

    @RequestMapping(value="/openNote",method=RequestMethod.GET)
    @ResponseBody
    public String openNote(HttpServletRequest request,@RequestParam(value = "seachinput",defaultValue = "") String seachinput,@RequestParam("noteid")int noteid,@RequestParam("directoryid")String dirctoryid,@RequestParam("filename") String filename) {
        *//*发送一个noteid,dirctoryid，得到,userid+dirctoryid+noteDao.getOneNoteWithLabels.filename.html
        * 读取文件内容，转成NRC，返回note:   content:*//*

        System.out.println("openNote:341"+filename);
        Note note=noteDao.getOneNoteWithLabels(noteid);
        System.out.println(note);
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        NoteUser noteUser=((NoteUser)request.getSession().getAttribute("userInfo"));
        String userid=noteUser.getUserid();
        String notePath=rootPath+userid+"/notedirectory/"+dirctoryid+"/"+note.getFilename()+".html";
        String indexDB=rootPath+userid+"/indexDB";
        String contentNCR="";
        if(seachinput.equals("")){
            contentNCR=StringToNCR.readFile(notePath);
        }else{
            try {
                BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(notePath)));
                String line="";
                StringBuffer stringBuffer=new StringBuffer("");
                while((line=br.readLine())!=null){
                    stringBuffer.append(line);
                }
               String highLightContent=LuceneUtil.contentToHighLight(seachinput,stringBuffer.toString());
                contentNCR=highLightContent;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(EncodingUtil.getEncode(contentNCR));
        contentNCR=StringToNCR.stringToNCR(contentNCR);
        Map<String,Object> map=new HashMap<>();
        map.put("note",note);
        map.put("content",contentNCR);
        map.put("message","201");
        ObjectMapper objectMapper=new ObjectMapper();
        String rs="";
        try {
           rs= objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return rs;
    }



    *//*@RequestMapping(value="/deleteOther",method=RequestMethod.POST)
    @ResponseBody

    public String deleteOther(@RequestParam("noteid") int noteid){
        *//**//*1.设置该笔记的isdelet字段 2.根据id删除索引*//**//*
    }*//*
    @RequestMapping(value="/search",method=RequestMethod.POST)
    @ResponseBody
    public String search(@RequestParam("search") String search,@RequestParam("directoryid")String directoryid, HttpServletRequest request){
        *//*根据输入的内容，查询索引库，*//*
        *//*directoryid为我的文件夹
        时，检索所有*//*
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        String indexDB=rootPath+userid+"/indexDB";
        List<Integer> ids=new ArrayList<>();
        if(directoryid.equals("")) {
            ids = LuceneUtil.queryh(indexDB, new String[]{"filename", "content"}, null, search, 10);
        }else{
            ids = LuceneUtil.queryh(indexDB, new String[]{"filename", "content"}, directoryid, search, 10);

        }
        List<Note> notes=new ArrayList<>();
        *//*不知道可以优化吗，循环查询*//*
        System.out.println("search__________________________________");
        for (Integer noteid : ids) {
            notes.add(noteDao.getOneNoteWithLabels(noteid));
            System.out.println("----search "+noteid);
        }
        String content="";
        System.out.println("search__________________________________");
        if(notes.size()>0) {
            String notePath = rootPath + userid + "/notedirectory/" + notes.get(0).getDirectoryid() + "/" + notes.get(0).getFilename() + ".html";
            content = StringToNCR.readFile(notePath);
            System.out.println("content---------------------------------");
            content = LuceneUtil.contentToHighLight(search, content);
            System.out.println(content);
            System.out.println("content---------------------------------");
        }
        Map<String,Object> map=new HashMap<>();
        map.put("lists",notes);
        map.put("content",StringToNCR.stringToNCR(content));
        ObjectMapper objectMapper=new ObjectMapper();
        String rs="";
        try {
            rs= objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return rs;
    }


    *//*删除笔记
    * 根据id，设置笔记的i是delete字段为yes，笔记对应的图片的isdelete字段设hi在为“yes”
    * 将索引库中对应id的索引删除*//*
    @RequestMapping(value="/deleteOther",method=RequestMethod.POST)
    @ResponseBody
    public String deleteOther(@RequestParam("noteid") int noteid, HttpServletRequest request){
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        String indexDB=rootPath+userid+"/indexDB";
        boolean rs=noteDao.changeIsDele(noteid,"yes");
        boolean rs1=noteDao.changeNotePicIsDel(noteid,"yes");
        *//*boolean rs2=labelDao.changeLabsOfNote(noteid,"yes");*//*
        boolean rs3=labelDao.deleteLabsOfNote(noteid);
       *//* LuceneUtil.testDeleteIndex(noteid,indexDB);//索引可以不删，在查询的时候，将过滤掉已经删除的文件*//*
        JSONObject JObject = new JSONObject();
        JObject.put("message","删除成功");
        return JObject.toJSONString();
    }

    *//*彻底删除，根据笔记id，删除表中相应的一行，删除索引库中的索引*//*
    @RequestMapping(value="/deleteReally",method=RequestMethod.POST)
    @ResponseBody
    public String deleteReally(@RequestParam("noteid") int noteid, HttpServletRequest request){
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        String indexDB=rootPath+userid+"/indexDB";
        String imgpath=rootPath+userid+"/imgs";
        String notepath=rootPath+userid+"/notedirectory/"+noteDao.getDirOfNote(noteid);

        *//*1.得到图片名，图片id，删除文件夹中的图片，
        * 2.删除图片表中的信息
        * 3.删除对应id的文件，删除表中信息
        * 4.删除索引库中对应的索引*//*


         *//*删除图片信息*//*
        List<Img> imgs=noteDao.getImgsOfNote(noteid);
        noteDao.deleteImgsOfNote(noteid);
        for (Img img : imgs) {
            File imgfle=new File(imgpath,img.getIngname());
            if(imgfle.exists()){
                imgfle.delete();
            }
        }
        JSONObject json=new JSONObject();

        *//*删除标签*//*
        labelDao.deleteLabsOfNote(noteid);
       *//* List<Integer> libs=labelDao.getlanLids(noteid);
        if(libs.size()>0){
            labelDao.deleteLabsOfNote(noteid);
            //某个笔记删除了，可能其他笔记还用到了这个标签，所以不能在这里删除标签
            *//**//*labelDao.deleteLabs(libs);*//**//*
        }*//*
        labelDao.deleteLabsOfNote(noteid);

        *//*删除笔记*//*
        String filename=noteDao.getNoteFilename(noteid);
        File filenote=new File(notepath,filename+".html");
        if(filenote.exists()){
            filenote.delete();
        }
        boolean rs=noteDao.deletOneNote(noteid);

        *//*删除索引*//*
        boolean rs1=LuceneUtil.testDeleteIndex(noteid,indexDB);
        if(rs&&rs1){
            json.put("message","删除成功");
            return json.toJSONString();
        }else{
            json.put("message","删除失败");
            return json.toJSONString();
        }
    }


    @RequestMapping(value = "/rollback",method=RequestMethod.POST)
    @ResponseBody
    public String rollBack(@RequestParam("noteid") int noteid,HttpServletRequest request){
        *//*恢复文件 。
    1.根据noteid，修改对应的isdelete字段。
    2.根据noteid，修改img表中该文件对应的所有图片的isdelete属性
    3.根据noteid，恢复索引,因为之前删除笔记的时候没有真删除索引，所以不用做具体操作*//*

        boolean rs= noteDao.changeIsDele(noteid,"no");
        boolean rs1=noteDao.changeNotePicIsDel(noteid,"no");
        System.out.println("rs "+rs+" rs1"+rs1);
        JSONObject json=new JSONObject();

        if(rs&&rs1){
            json.put("message","恢复成功");
            return json.toJSONString();
        }else{
            json.put("message","恢复失败");
            return json.toJSONString();
        }

    }

    *//*获得所有被删除的文件或者文件夹*//*
    @RequestMapping(value="/getAllDeletes",method=RequestMethod.POST)
    @ResponseBody
    public String getAllDeletes(HttpServletRequest request){
        *//*首先得到该用户删除的文件夹
        * 如果存在删除的文件夹，查询不在被删除的，不在已经删除的文件中的笔记
        * 否则直接查询被删除的笔记*//*
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        List<Note> notes=new ArrayList<>();
        List<Directory> dirs=directoryDao.getAllDeletesDir(userid);
        if(dirs.size()>0){
            notes=noteDao.getAllDeleteNotesd(userid,dirs);
        }else{
            notes=noteDao.getAllDeleteNotes(userid);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("dris",dirs);
        map.put("notes",notes);
        ObjectMapper objectMapper=new ObjectMapper();
        String json="";
        try {
            json=objectMapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping(value="/getAllNotes",method=RequestMethod.POST)
    @ResponseBody
    public String getAllNotes(HttpServletRequest request){
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();

        Map<String,Object> map=new HashMap<>();
        List<Note>  notes=noteDao.getUserAllNotes(userid);
        System.out.println("getALLNotes-------------------------");
        for (Note note : notes) {
            System.out.println(note);
        }
        map.put("notes",notes);
        Note note=new Note();
        String content="";
        if(notes.size()>0) {
            note = noteDao.getOneNoteWithLabels(((Note) notes.get(0)).getNoteid());
            System.out.println(note);
                *//*根据相应的笔记信息，获得文件内容，将文件内容转为NRC
                * *//*
            map.put("note",note);
            String notePath=rootPath+userid+"/notedirectory/"+note.getDirectoryid();
            File notefile=new File(notePath,note.getFilename()+".html");
            if(notefile.exists()){
                content=StringToNCR.stringToNCR(StringToNCR.readFile(notePath+"/"+note.getFilename()+".html"));
            }
        }
        map.put("note",note);
        map.put("content",content);
        map.put("message","访问");
        ObjectMapper mapper=new ObjectMapper();
        String data="";


        try {
            data=mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(data);
        System.out.println("getALLNotes-------------------------");
        return data;
    }

    @RequestMapping(value="/showNote",method=RequestMethod.POST)
    @ResponseBody
    public String showNote(Note note, HttpServletRequest request, HttpServletResponse response){
        JSONObject jsonObject=new JSONObject();
        if(note.getNoteid()>0) {
            String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
            String userid = ((NoteUser) request.getSession().getAttribute("userInfo")).getUserid();
            String notepath = rootPath + userid + "/notedirectory/" + noteDao.getDirOfNote(note.getNoteid());
            String suffix=userid + "/notedirectory/" + noteDao.getDirOfNote(note.getNoteid());
            File note1 = new File(notepath, note.getFilename() + ".html");
            jsonObject.put("message","打开成功");
            jsonObject.put("href",request.getContextPath()+"/uploadDirectory/"+suffix+"/"+note.getFilename()+".html");
            return jsonObject.toJSONString();
        }else{
            jsonObject.put("message","请先打开文件");
            return jsonObject.toJSONString();
        }

    }


    @RequestMapping(value="/checkReadPass",method=RequestMethod.POST)
    @ResponseBody
    public String checkReadPass(@RequestParam("flag") String flag,@RequestParam("readlock" )String readlock,HttpServletRequest request) {

        String userid=((NoteUser) request.getSession().getAttribute("userInfo")).getUserid();
        String readlockP=noteUserDao.getReadLock(userid);
        JSONObject object=new JSONObject();
        if(readlock.equals(readlockP)){
            if(flag.equals("open")) {
                object.put("message", "201");
            }else{
                object.put("message","202");
            }
        }else{
            object.put("message","401");
        }

        return object.toJSONString();
    }

    @RequestMapping(value="/checkForderPass",method=RequestMethod.POST)
    @ResponseBody
    public String checkForderPass(@RequestParam("readlock")String readlock,HttpServletRequest request){
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        String pass=noteUserDao.getReadLock(userid);
        JSONObject json=new JSONObject();

        if(pass.equals(readlock)){
            json.put("message","201");
        }else{
            json.put("message","202");
        }
        return json.toJSONString();
    }

    @RequestMapping(value="/setDirLock",method=RequestMethod.POST)
    @ResponseBody

    public String setDirLock(@RequestParam("directoryid")String directoryid){
        boolean rs=noteDao.changeisLockBydid(directoryid,"yes");
        boolean rs1=directoryDao.changeIsdLocked(directoryid,"yes");
        JSONObject json=new JSONObject();

        if(rs&&rs1){
            json.put("message","201");
        }else{
            json.put("message","401");
        }

        return json.toJSONString();

    }

    @RequestMapping(value="/lock",method=RequestMethod.POST)
    @ResponseBody
    public String lock(@RequestParam("noteid") int noteid,HttpServletRequest request){
       boolean rs= noteDao.changIsLocked(noteid,"yes");

       JSONObject jsonObject=new JSONObject();
       if(rs){
           jsonObject.put("message","201");
       }else{
           jsonObject.put("message","401");
       }
        return jsonObject.toJSONString();
    }


    @RequestMapping(value="/setReadPass",method=RequestMethod.POST)
    @ResponseBody
    public String setReadPass(@RequestParam("readlock")String readlock,HttpServletRequest request){
        NoteUser noteUser=(NoteUser)request.getSession().getAttribute("userInfo");
        String userid=noteUser.getUserid();
        System.out.println(readlock);
        boolean rs=noteUserDao.setReadLock(userid,readlock);
        noteUser.setReadlock(readlock);
        request.getSession().setAttribute("userInfo",noteUser);
        JSONObject jsonObject = new JSONObject();
        if(rs){
            jsonObject.put("message","201");
        }else{
            jsonObject.put("message","401");
        }

        return jsonObject.toString();
    }

    @RequestMapping(value="/getAllDir",method=RequestMethod.POST)
    @ResponseBody
    public String getAllDir(HttpServletRequest request){
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        List<Directory> dirs=directoryDao.getAllDirs(userid);
        Map<String,Object> map=new HashMap<>();
        map.put("message","201");
        map.put("dirs",dirs);
        String sjon="";
        ObjectMapper mapper=new ObjectMapper();
        try {
            sjon=mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return sjon;
    }

    @RequestMapping(value="/checkAndCreDir",method=RequestMethod.POST)
    @ResponseBody
    public String checkAndCreDir(@RequestParam("directory") String directory,HttpServletRequest request){
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        Directory dirObj=directoryDao.checkDir(userid,directory);
        JSONObject json=new JSONObject();
        if(dirObj!=null){
            directory=directory+new Random().nextInt(1000);
            while(directoryDao.checkDir(userid,directory)!=null){
                directory=directory+new Random().nextInt(1000);
            }
            json.put("message","201");
            json.put("directory",directory);
            return json.toJSONString();
        }else{
            Directory dio=new Directory();
            dio.setDirectoryid(UUID.randomUUID().toString().replace("-",""));
            dio.setDirectory(directory);
            dio.setIsdlocked("no");
            dio.setIsddele("no");
            dio.setUserid(userid);
            directoryDao.insertOneDirectory(dio);
            json.put("message","202");
            return json.toString();
        }

    }


    @RequestMapping(value="/renameDir",method=RequestMethod.POST)
    @ResponseBody
    public String renameDir(HttpServletRequest request,@RequestParam("directory")String directory ,@RequestParam("directoryid")String directoryid){
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        Directory dirObj=directoryDao.checkDir(userid,directory);
        JSONObject json=new JSONObject();
        if(dirObj!=null){
            directory=directory+new Random().nextInt(1000);
            while(directoryDao.checkDir(userid,directory)!=null){
                directory=directory+new Random().nextInt(1000);
            }
            json.put("message","201");
            json.put("directory",directory);
            return json.toJSONString();
        }else{
            directoryDao.changeDirectory(directoryid,directory);
            json.put("message","202");
            return json.toJSONString();
        }

    }

    @RequestMapping(value="/deletForder",method=RequestMethod.POST)
    @ResponseBody
    public String deletForder(@RequestParam("directoryid")String directoryid){
        boolean rs=noteDao.changDeletByDid(directoryid,"yes");
        boolean rs1=directoryDao.changeIsdDele(directoryid,"yes");


        JSONObject jsonObject=new JSONObject();
        jsonObject.put("message","201");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/rollDBack",method=RequestMethod.POST)
    @ResponseBody
    public String rollDBack(@RequestParam("directoryid")String directoryid){
        boolean rs=noteDao.changDeletByDid(directoryid,"no");
        boolean rs1=directoryDao.changeIsdDele(directoryid,"no");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("message","201");
        return jsonObject.toJSONString();
    }

    @RequestMapping(value="/deleteDReally",method=RequestMethod.POST)
    @ResponseBody

    public String deleteDReally(@RequestParam("directoryid")String directoryid, HttpServletRequest request){
        *//*具体文件：删除文件，文件夹，索引库索引，删除图片，可以参考删除笔记
        表：删除图表中信息，文件夹信息 文件信息，
        * *//*
        String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        String userid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        String indexDB=rootPath+userid+"/indexDB";
        String imgpath=rootPath+userid+"/imgs";
        String notepath=rootPath+userid+"/notedirectory/"+directoryid;
        *//*得到noteid ，从而的删除img，在通过得到的imgid，删除图片
        根据noteid删除索引
        删除note信息，然后直接删除文件夹夹，
        * *//*
        List<Integer> noteids=noteDao.getNoteidOfDir(directoryid);
        for (Integer noteid : noteids) {
           List<Img> imgs =noteDao.getImgsOfNote(noteid);
            for (Img img : imgs) {
                File imgfile=new File(imgpath,img.getIngname());
                if(imgfile.exists()){
                    imgfile.delete();
                }
            }
            noteDao.deleteImgsOfNote(noteid);
            LuceneUtil.testDeleteIndex(noteid,indexDB);
            noteDao.deletOneNote(noteid);
        }

        boolean rs=directoryDao.deletOneDir(directoryid);
        File dir=new File(notepath);
        if(dir.exists()){
            File[] files=dir.listFiles();
            for (File file : files) {
                file.delete();
            }
            dir.delete();
        }
        JSONObject json=new JSONObject();
        json.put("message","201");
        return json.toJSONString();


    }


    @RequestMapping(value="/setUnlock",method=RequestMethod.POST)
    @ResponseBody

    public String setUnlock(@RequestParam("noteid")int noteid){

       boolean rs= noteDao.changIsLocked(noteid,"no");
       JSONObject jsonObject=new JSONObject();

       if(rs){
           jsonObject.put("message","201");
       }else{
           jsonObject.put("message","401");
       }
       return jsonObject.toJSONString();
    }


    @RequestMapping(value="/getNoteOfDir",method=RequestMethod.POST)
    @ResponseBody

    public String getNotesOfDir(@RequestParam("directoryid")String directoryid){
        List<Note> notes=noteDao.getNotesOfDir(directoryid);
        Map<String,Object> map =new HashMap<>();
        map.put("notes",notes);
        map.put("message","201");
        ObjectMapper mapper=new ObjectMapper();
        String rs="" ;
        try {
            rs=mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @RequestMapping(value="/checkIsLock",method=RequestMethod.POST)
    @ResponseBody
    public String checkIsLock(@RequestParam("noteid")int noteid){
        Note note=noteDao.getOneNoteWithLabels(noteid);
        String islocked=note.getIslocked();
        JSONObject json=new JSONObject();
        if(islocked==null||islocked==""||islocked.equals("no")){
            json.put("message","no");
        }else{
            json.put("message","yes");
        }
        return json.toJSONString();
    }


    @RequestMapping(value="/getReadLock",method=RequestMethod.POST)
    @ResponseBody
    public String getReadLock(HttpServletRequest request){
        JSONObject json=new JSONObject();
        String readlock=((NoteUser)request.getSession().getAttribute("userInfo")).getReadlock();
        if(readlock.equals("")||readlock==null){
            json.put("message","401");
        }else{
            json.put("message","201");
        }
        return json.toJSONString();
    }
    */


}
