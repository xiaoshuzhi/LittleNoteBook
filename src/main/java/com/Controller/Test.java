package com.Controller;

import Utils.TokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin
public class Test {


    /*@RequestMapping("/hello")
    public String test(){
        return "hello";
    }

    @RequestMapping(value="/test/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> testVue(HttpServletRequest request){
        System.out.println(request.getRequestURL());
        Map<String,Object> map=new HashMap<String,Object>();
        Map<String,Object> data =new HashMap<>();
        data.put("token", TokenUtil.createToken("xiao123","uuid"));
        data.put("code", 20000);
        System.out.println("test");
        map.put("data",data);
        return map;
    }
    @RequestMapping(value="/api/info",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> testInfo(HttpServletRequest request){
        Map<String,Object> map=new HashMap<String,Object>();
        Map<String,Object> data =new HashMap<>();
        data.put("name", "BrunoLi");
        data.put("code", 20000);
        data.put("avatar", "testAvatar");
        data.put("testusername", request.getAttribute("username"));
        data.put("testuid", request.getAttribute("uid"));
        data.put("test_token_state", request.getAttribute("token_state"));
        System.out.println("test");
        //map.put("data",data);
        return data;
    }

    @RequestMapping(value="/api/testInsert",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> testInsert(HttpServletRequest request, UserRole userRole){

        //map.put("data",data);
        return data;
    }*/


}
