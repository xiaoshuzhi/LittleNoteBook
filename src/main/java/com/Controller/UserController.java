package com.Controller;

import Utils.*;
import cn.dsna.util.images.ValidateCode;
import com.Dao.*;
import com.Entity.*;
import com.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private FindMapper findMapper;
    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private DirectoryMapper directoryMapper;
    private MyLogger logger = new MyLogger("UserController");

    @RequestMapping(value = "/static/codeImg", method = RequestMethod.GET)
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        request.getSession().setAttribute("code", vc.getCode());
        logger.info("code", (String) request.getSession().getAttribute("code"));
        try {
            vc.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("验证码出错了");
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> checkLogin1(@RequestBody  Map<String, Object> map, HttpServletRequest request) {
        Map<String, Object> resp = new HashMap<>();
        /*String clientCode = request.getParameter("thecode");*/
        String clientCode = (String)map.get("thecode");
        User user_bak = new User();
        user_bak.setPassword((String) map.get("password"));
        user_bak.setEmail((String) map.get("email"));
        logger.info("com.Controller.UserController.checkLogin1: theCode:", clientCode);
        logger.info("com.Controller.UserController.checkLogin1: session Code:", (String) request.getSession().getAttribute("code"));
        String rs = userService.checkPassWord(user_bak, (String) request.getSession().getAttribute("code"), clientCode, request);
        // String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        logger.info("com.Controller.UserController.checkLogin1: 用户验证结果：", rs);
        logger.info("com.Controller.UserController.checkLogin1: noterUser:", user_bak.toString());
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andEmailEqualTo(user_bak.getEmail());
        List<User> userList = userMapper.selectByExample(userExample);
        User user = userList.get(0);
       /* String imgPath="";*/
        if (rs.equals(GlobalValue.LOGIN_SUCCESS_MESSAGE)) {
            resp.put("code", GlobalValue.LOGIN_SUCCESS_CODE);
            resp.put("message", GlobalValue.LOGIN_SUCCESS_MESSAGE);
            resp.put("token", TokenUtil.createToken(user.getUsername(), user.getUserid(), GlobalValue.SECRET_Of_API, GlobalValue.ALIVE_TIME));
        } else if (rs.equals(GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_MESSAGE)) {
            resp.put("code", GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_CODE);
            resp.put("message", GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_MESSAGE);
        } else {
            resp.put("code", GlobalValue.LOGIN_FAIL_CODE);
            resp.put("message", GlobalValue.LOGIN_FAIL_MESSAGE);
        }
        return resp;
    }

    @RequestMapping(value = "/api/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserInfo1(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<String, Object>();
        String uid = (String) request.getAttribute("uid");
        String username = (String) request.getAttribute("username");
        logger.info("com.Controller.UserController.getUserInfo1 uid", uid);
        logger.info("com.Controller.UserController.getUserInfo1 username", username);
        User userDetial = userMapper.selectByPrimaryKey(uid);
        data.put("code", GlobalValue.SUCCESS_ACCESS_API_CODE);
        data.put("message", GlobalValue.SUCCESS_ACCESS_API_MESSAGE);
        data.put("name", username);
        data.put("avatar", GlobalValue.getHttpUploadDirectory(request)+"/header/" + userDetial.getVatar());
        UserRoleExample userRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria = userRoleExample.createCriteria();
        criteria.andUserIdEqualTo(userDetial.getUserid());
        List<UserRole> userRoleList = userRoleMapper.selectByExample(userRoleExample);
        List<Integer> roleIds = ListConvertUtil.getList("roleid", userRoleList);

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria roleCriteria = roleExample.createCriteria();
        roleCriteria.andRoleIdIn(roleIds);
        List<Role> roleList = roleMapper.selectByExample(roleExample);
        List<String> roleNames = ListConvertUtil.getList("roleName", roleList);
        data.put("roles", roleNames);
        return data;
    }

    @RequestMapping(value = "/api/getUserDetailInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getUserDetailInfo(HttpServletRequest request) {
        String uid = (String) request.getAttribute("uid");
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        User user = userMapper.selectByPrimaryKey(uid);
        user.setPassword("");
        Map<String, Object> data = new HashMap<>();
        data.put("code", GlobalValue.SUCCESS_ACCESS_API_CODE);
        data.put("message", GlobalValue.SUCCESS_ACCESS_API_MESSAGE);
        data.put("data", user);
        return data;
    }

    @RequestMapping(value = "/user/refrashToken", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> refrashToken(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> result = TokenUtil.valid(request.getHeader("X-Token"), GlobalValue.SECRET_Of_API);
        logger.info("-----------------------com.Controller.UserController.refrashToken --------------", "");
        logger.info("token解析结果", (String) result.get("Result"));
        if (((String) result.get("Result")).equals(GlobalValue.TOKEN_NEED_REFRESH_CODE)) {
            String newToken = TokenUtil.createToken((String) result.get("username"), (String) result.get("uid"), GlobalValue.SECRET_Of_API, GlobalValue.ALIVE_TIME);
            data.put("code", GlobalValue.SUCCESS_ACCESS_API_CODE);
            data.put("message", GlobalValue.SUCCESS_ACCESS_API_MESSAGE);/*token 刷星成功*/
            data.put("token", newToken);
        } else {
            data.put("code", GlobalValue.FAIL_ACCESS_API_CODE);
            data.put("message", GlobalValue.FAIL_ACCESS_API_MESSAGE);
        }
        return data;
    }

    /*@Param email
      @Param type
    * */
    @RequestMapping(value = "/user/chechEmail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> checkEmail(@RequestParam("email")String email) {
        logger.info("-----------------------com.Controller.UserController.checkEmail --------------", "");
        //String type = (String) paramMap.get("type");
        logger.info(" com.Controller.UserController.checkEmail email", email);
        Map<String, Object> data = new HashMap<String, Object>();
        if (userService.checkEmailExist(email).equals(GlobalValue.EXIST_MESSAGE)) {
            data.put("code", 20000);
            data.put("message", "邮箱" + GlobalValue.EXIST_MESSAGE);
            return data;
        } else {
            data.put("code", 24000);
            data.put("message", "邮箱" + GlobalValue.NOT_EXIST_MESSAGE);
            return data;
        }
    }


    /*
    * @Param email
    * @Param token
    * */
    @RequestMapping(value = "/user/validataPassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> validatePassword(@RequestBody Map<String,Object> paramMap) {
        String email = (String) paramMap.get("email");
        String token = (String) paramMap.get("token");
        FindExample findExample = new FindExample();
        FindExample.Criteria findCriteria = findExample.createCriteria();
        findCriteria.andEmailEqualTo(email);
        List<Find> find = findMapper.selectByExampleWithBLOBs(findExample);
        logger.info("validatePassword findSize",find.size()+"");
        Map<String, Object> data = new HashMap<>();
        if (find.size() != 1) {
            data.put("code", GlobalValue.TOKEN_NOT_VALIDATE_CODE);
            data.put("message", GlobalValue.EMAIL_NOT_VALIDATE_MESSAGE);
            return data;
        } else {
            logger.info("validatePassword find",find.get(0).toString());

            if (!(find.get(0).getToken().equals(token))) {
                data.put("code", GlobalValue.TOKEN_NOT_VALIDATE_CODE);
                data.put("message", GlobalValue.TOKEN_NOT_NEW_MESSAGE);
                return data;
            } else {
                Map<String, Object> result = TokenUtil.validPassword(token, GlobalValue.SECRET_Of_Password);
                logger.info("validatePassword Result",(String)result.get("Result"));
                if (result.get("Result").equals(GlobalValue.TOKEN_VALIDATE_MESSAGE)) {
                    data.put("code", GlobalValue.VALIDATE_CODE);
                    data.put("message", GlobalValue.VALIDATE_MESSAGE);
                    data.put("uid", result.get("uid"));
                    return data;
                } else {
                    data.put("code", GlobalValue.TOKEN_NOT_VALIDATE_CODE);
                    data.put("message", GlobalValue.TOKEN_ILLEGAL_MESSAGE);
                    return data;
                }
            }
        }
    }

    @RequestMapping(value = "/user/sendEmail", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> sendEmial(@RequestParam("email") String toEmail) {
        Map<String, Object> data = new HashMap<>();
        int line = -1;
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEmailEqualTo(toEmail);
        List<User> users = userMapper.selectByExample(userExample);
        User user = users.get(0);
        logger.info("sendEmial user", user.toString());
        String token = TokenUtil.createToken(user.getUsername(), user.getUserid(), GlobalValue.SECRET_Of_Password, GlobalValue.P_ALIVE_TIME);
        logger.info( "sendEmial token", token);
        boolean isSuccess = false;
        if (!token.equals("")) {
            isSuccess = EmailUtil.sendEmail(toEmail, "您正在进行安全邮箱验证操作，验证码：\n" + token, "小小笔记密码找回");
            if (isSuccess) {
                FindExample findExample = new FindExample();
                FindExample.Criteria findCriteria = findExample.createCriteria();
                findCriteria.andEmailEqualTo(toEmail);
                List<Find> find = findMapper.selectByExample(findExample);
                if (find.size() == 0) {
                    Find findRecord = new Find();
                    findRecord.setEmail(toEmail);
                    findRecord.setToken(token);
                    findRecord.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                    line = findMapper.insertSelective(findRecord);
                } else if (find.size() == 1) {
                    Find findRecord = find.get(0);
                    findRecord.setToken(token);
                    logger.info("sendEmial findRecord", findRecord.toString());
                    FindExample findExample1 = new FindExample();
                    FindExample.Criteria findCriteria1 = findExample1.createCriteria();
                    findCriteria1.andIdEqualTo(findRecord.getId());
                    line = findMapper.updateByExampleWithBLOBs(findRecord,findExample1);
                }
                data.put("code", 20000);
                data.put("message", "邮件已经发送成功");
            }else{
                data.put("code", 24000);
                data.put("message", "邮件发送失败，请确保您的邮箱可用");
            }
        } else {
            data.put("code",20000 );
            data.put("message", GlobalValue.FAIL_CREATE_TOKEN_MESSAGE);
        }
        return data;
    }

    /*
    @Param username
    @Param password
    @Param email
    @Param token

    * */
    @RequestMapping(value = "/user/validateRejest", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> validataRejest(@RequestBody Map<String,Object> paramMap) {

        String token = (String) paramMap.get("token");
        String email = (String) paramMap.get("email");
        CodeExample codeExample = new CodeExample();
        CodeExample.Criteria codeCriteria = codeExample.createCriteria();
        codeCriteria.andEmailEqualTo(email);
        List<Code> code = codeMapper.selectByExampleWithBLOBs(codeExample);
        logger.info("com.Controller.UserController.validataRejest findSize",code.size()+"");
        Map<String, Object> data = new HashMap<>();
        if (code.size() != 1) {
            data.put("code", GlobalValue.TOKEN_NOT_VALIDATE_CODE);
            data.put("message", GlobalValue.EMAIL_NOT_VALIDATE_MESSAGE);
            return data;
        } else {
            logger.info("com.Controller.UserController.validataRejest code",code.get(0).toString());
            if (!(code.get(0).getToken().equals(token))) {
                data.put("code", GlobalValue.TOKEN_NOT_VALIDATE_CODE);
                data.put("message", GlobalValue.TOKEN_NOT_NEW_MESSAGE);
                return data;
            } else {
                Map<String, Object> result = TokenUtil.validCode(token, GlobalValue.SECRET_OF_CODE);
                logger.info("com.Controller.UserController.validataRejest Result",(String)result.get("Result"));
                if (result.get("Result").equals(GlobalValue.TOKEN_VALIDATE_MESSAGE)&&email.equals(result.get("email"))) {
                    User user = new User();
                    String userid = UUID.randomUUID().toString().replace("-","");
                    user.setUserid(userid);
                    user.setUsername((String) paramMap.get("username"));
                    user.setEmail((String) paramMap.get("email"));
                    user.setPassword(MD5.strToMd5((String) paramMap.get("password")));
                    user.setTotal(1);
                    user.setVatar("defaultHead.gif");
                    int line = userMapper.insert(user);
                    /*创建默认文件夹*/
                    Directory directory = new Directory();
                    directory.setUserid(userid);
                    directory.setDirectoryName("我的文件夹");
                    directory.setCreateTime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
                    directory.setFileNum(0);
                    directory.setDefuatforder("Y");
                    directory.setIsddele("N");
                    directory.setIsdlocked("N");
                    int directoryLine = directoryMapper.insert(directory);
                    /*设置用户权限*/
                    UserRole userRole = new UserRole();
                    userRole.setCreateTime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
                    userRole.setUpdateTime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
                    userRole.setUserId(userid);
                    userRole.setRoleId(7);
                    int userRoleLine = userRoleMapper.insert(userRole);
                    logger.info("userRoleLine", userRoleLine + "");
                    data.put("code", 20000);
                    data.put("message","注册成功");
                    return data;
                } else {
                    data.put("code", GlobalValue.TOKEN_NOT_VALIDATE_CODE);
                    data.put("message", GlobalValue.TOKEN_ILLEGAL_MESSAGE);
                    return data;
                }
            }
        }
    }


    @RequestMapping(value = "/user/sendEmailCode", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> sendEmialCode(@RequestParam("email") String toEmail) {
        Map<String, Object> data = new HashMap<>();
        int line = -1;
        logger.info("com.Controller.UserController.sendEmialCode toEmail", toEmail);
        String token = TokenUtil.createTokenCode(toEmail, GlobalValue.SECRET_OF_CODE, GlobalValue.P_ALIVE_TIME);
        logger.info( "com.Controller.UserController.sendEmialCode token", token);
        boolean isSuccess = false;
        if (!token.equals("")) {
            isSuccess = EmailUtil.sendEmail(toEmail, "您正在进行安全邮箱验证操作，验证码：\n" + token, "小小笔记密码找回");
            if (isSuccess) {
                CodeExample codeExample = new CodeExample();CodeExample.Criteria criteria = codeExample.createCriteria();criteria.andEmailEqualTo(toEmail);
                List<Code> code = codeMapper.selectByExample(codeExample);
                if (code.size() == 0) {
                    Code code1 = new Code();
                    code1.setEmail(toEmail);
                    code1.setToken(token);
                    code1.setCreatetime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
                    line = codeMapper.insertSelective(code1);
                } else if (code.size() == 1) {
                    Code code1= code.get(0);
                    code1.setToken(token);
                    logger.info("sendEmial findRecord", code1.toString());
                    code1.setCreatetime(new SimpleDateFormat("yyyy-MM-DD HH:mm:ss").format(new Date()));
                    CodeExample codeExample1 = new  CodeExample();CodeExample.Criteria codeCriteria1 = codeExample1.createCriteria();
                    codeCriteria1.andIdEqualTo(code1.getId());
                    line = codeMapper.updateByExampleWithBLOBs(code1,codeExample1);
                }
                data.put("code", 20000);
                data.put("message", "邮件发送成功");
            }else{
                data.put("code", 50000);
                data.put("message", "邮件发送失败，请确保您的邮箱可用");
            }
        } else {
            data.put("code", GlobalValue.FAIL_CREATE_TOKEN_CODE);
            data.put("message", GlobalValue.FAIL_CREATE_TOKEN_MESSAGE);
        }
        return data;
    }

    @RequestMapping(value = "/user/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> changePassword(@RequestBody Map<String,Object> paramMap){
        String uid = (String) paramMap.get("uid");
        String password = (String) paramMap.get("password");
        Map<String,Object> data = new HashMap<String,Object>();
        User user = userMapper.selectByPrimaryKey(uid);
        user.setPassword(MD5.strToMd5(password));
        int line = userMapper.updateByPrimaryKey(user);
        if (line>=0) {
            data.put("code", 20000);
            data.put("message", "密码修成功");
        }else{
            data.put("code", 50000);
            data.put("message", "密码修改失败");
        }
        return data;
    }

    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> logout(){
        Map<String, Object> data = new HashMap<>();
        data.put("code", 20000);
        data.put("message", "退出成功");
        return data;
    }

    @RequestMapping(value = "/user/checkUsername", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkUsername(@RequestParam("username") String username){
        Map<String, Object> data = new HashMap<>();
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andUsernameEqualTo(username);
        List<User> user = userMapper.selectByExample(userExample);
        if(user.size()==0) {
            data.put("code", 20000);
            data.put("message", "用户名未重复");
        }else{
            data.put("code", 20400);
            data.put("message", "用户名重复");
        }
        return data;
    }

    @RequestMapping(value = "/api/checkUsernameForUpdate", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> checkUsernameForUpdate(@RequestParam("username") String username,HttpServletRequest request){
        Map<String, Object> data = new HashMap<>();
        String uid = (String) request.getAttribute("uid");
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andUsernameEqualTo(username);
        userCriteria.andUseridNotEqualTo(uid);
        List<User> user = userMapper.selectByExample(userExample);
        if(user.size()==0) {
            data.put("code", 20000);
            data.put("message", "用户名未重复");
        }else{
            data.put("code", 20400);
            data.put("message", "用户名重复");
        }
        return data;
    }

    @PostMapping(value = "/api/user")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user, HttpServletRequest request) {
        String uid = (String) request.getAttribute("uid");
        user.setUserid(uid);
        int line = userMapper.updateByPrimaryKeySelective(user);
        logger.info("com.Controller.UserController.updateUser line =", line + "");
        return Utils.Result.createResult(20000, "修改成功", null);
    }


    /*@Autowired
    private UserService userService;
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private NoteUserDao noteUserDao;
    @Autowired
    private DirectoryDao directoryDao;
    private MyLogger logger = new MyLogger("UserController");
    @CrossOrigin
    @RequestMapping("/user/code")
    public void getImg(HttpServletRequest request, HttpServletResponse response) {
        ValidateCode vc = new ValidateCode(110, 25, 4, 9);
        request.getSession().setAttribute("code",vc.getCode());
        logger.info("code",(String)request.getSession().getAttribute("code"));
        try {
            vc.write(response.getOutputStream());
        } catch (IOException e) {
            System.out.println("验证码出错了");
            e.printStackTrace();
        }
    }

    *//*刷新token：
    * 1.解析token，如果token解析结果为即将到期，创建新的token，否则显示创建token失败*//*
    @CrossOrigin
    @RequestMapping(value = "/user/refrashToken",method = RequestMethod.POST)
    @ResponseBody
    public void refrashToken(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> data = new HashMap<>();

        Map<String, Object> result = TokenUtil.valid(request.getHeader("X-Token"));
        if(((String)result.get("Result")).equals(GlobalValue.TOKEN_NEED_REFRESH_CODE)){
            String newToken=TokenUtil.createToken((String)result.get("username"), (String) result.get("uid"));
            data.put("code", GlobalValue.SUCCESS_ACCESS_API_CODE);
            data.put("message", GlobalValue.SUCCESS_ACCESS_API_MESSAGE);
            data.put("token", newToken);
        }else{
            data.put("code", GlobalValue.FAIL_ACCESS_API_CODE);
            data.put("message", GlobalValue.FAIL_ACCESS_API_MESSAGE);
        }
    }

    @RequestMapping(value = "/checklogin", method=RequestMethod.POST)
    public String checkLogin(Map<String,Object> map, HttpServletRequest request, @RequestParam("thecode") String thecode, NoteUser noteuser){
        String rs=userService.checkPassWord(noteuser,(String)request.getSession().getAttribute("code"),thecode,request);
      *//*  String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";*//*
        //System.out.println(rs);
        logger.info("登陆验证结果：" , rs);
        String imgPath="";
        if(rs.equals(GlobalValue.LOGIN_SUCCESS_MESSAGE)){
            System.out.println("success"+"black");
            *//*1将用户信息放到session(在服务测做好了)
            * 2.根据用户id查询用户所有笔记简单信息
            * 3.将查询出来的第一笔记问价具体内容交给富文本显示，所有的标签信息一并显示*//*
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
                *//*根据相应的笔记信息，获得文件内容，将文件内容转为NRC
                * *//*
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

    *//*前后端分离之后的登陆验证*//*
    @CrossOrigin
    @RequestMapping(value = "/user/login", method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> checkLogin1(Map<String,Object> map, HttpServletRequest request, @RequestParam("thecode") String thecode, NoteUser noteuser){
        Map<String,Object> resp=new HashMap<>();
        logger.info("com.Controller.UserController.checkLogin1: session Code:",(String)request.getSession().getAttribute("code"));
        String rs=userService.checkPassWord(noteuser,(String)request.getSession().getAttribute("code"),thecode,request);
        // String rootPath = request.getServletContext().getRealPath("/") + "uploadDirectory/";
        logger.info("用户验证结果：",rs);
        logger.info("noterUser:", noteuser.toString());
        NoteUser user = noteUserDao.getUser(noteuser.getEmail());
       *//* String imgPath="";*//*
        if(rs.equals(GlobalValue.LOGIN_SUCCESS_MESSAGE)){
            resp.put("code",GlobalValue.LOGIN_SUCCESS_CODE);
            resp.put("message", GlobalValue.LOGIN_SUCCESS_MESSAGE);
            resp.put("token", TokenUtil.createToken(user.getUsername(),user.getUserid()));
        }else if(rs.equals(GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_MESSAGE)){
            resp.put("code",GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_CODE);
            resp.put("message", GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_MESSAGE);
        }else{
            resp.put("code",GlobalValue.LOGIN_FAIL_CODE);
            resp.put("message", GlobalValue.LOGIN_FAIL_MESSAGE);
        }
        return resp;
    }

    @CrossOrigin
    @RequestMapping(value="/api/getUserInfo",method=RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUserInfo1(HttpServletRequest request,@RequestParam("uid") String uid ,@RequestParam("username" ) String username){
        //String uuid=((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        // System.out.println(uuid);
        Map<String, Object> data = new HashMap<String,Object>();
        logger.info("com.Controller.UserController.getUserInfo1 uid", uid);
        logger.info("com.Controller.UserController.getUserInfo1 username", username);
        NoteUser userDetial=noteUserDao.getUserInfo(uid);
        data.put("code", GlobalValue.SUCCESS_ACCESS_API_CODE);
        data.put("message", GlobalValue.SUCCESS_ACCESS_API_MESSAGE);
        data.put("name", username);
        // data.put("roles",)
        return data;
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
        *//*查看用户id路径下是否存在头像文件夹，如果不存在就添加一个，并将图片放入其中，
        * 如果存在，查看删除其中的文件，并将文件放入
        *设置用户信息中img，返回上传结果*//*

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        String path=request.getServletContext().getRealPath("/")+"uploadDirectory/"+((NoteUser)request.getSession().getAttribute("userInfo")).getUserid();
        File headImgFile=new File(path,"headImgFile");
        String userid=((NoteUser) request.getSession().getAttribute("userInfo")).getUserid();
        *//*是否是图片类型*//*
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
    }*/
}
