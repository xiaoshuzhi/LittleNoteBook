package com.Filter;

import Utils.GlobalValue;
import Utils.MyLogger;
import Utils.TokenUtil;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class TokenValidateInterceptor extends HandlerInterceptorAdapter {
    private MyLogger logger = new MyLogger("com.Filter.TokenValidateInterceptor");
    /*
    * 过滤器token验证
    * 1.token
    * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // return super.preHandle(request, response, handler);
        logger.info("----------------------------------", "进入Token 拦截器----------------------");
        Map<String,Object> resp = new HashMap<String,Object>();
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            /*resp.put("code",20000);
            resp.put("msg", GlobalValue.ILLEGAL_TOKEN_MESSAGE);*/
            return true;
        }
        String token = request.getHeader("x-token");
        logger.info("token:" ,token);

        boolean flag = false;
        if(!token.equals("")){
            Map<String, Object> data = TokenUtil.valid(token,GlobalValue.SECRET_Of_API);
            String validateResult = (String) data.get("Result");
            logger.info("验证结果:" ,validateResult);
            switch(validateResult){
                case GlobalValue.TOKEN_NEED_REFRESH_MESSAGE:
                case GlobalValue.TOKEN_VALIDATE_MESSAGE:
                    request.setAttribute("uid",(String)data.get("uid"));
                    request.setAttribute("username",(String)data.get("username"));
                    request.setAttribute("token_state",validateResult);
                    flag = true;
                    break;
                case GlobalValue.ILLEGAL_TOKEN_MESSAGE:
                    logger.info("过时token/非法token" ,token);
                    resp.put("code",validateResult);
                    resp.put("msg", GlobalValue.ILLEGAL_TOKEN_MESSAGE);
                    flag =false;
                    PrintWriter out =response.getWriter();
                    out.write(JSONObject.toJSONString(resp));
                    break;
            }
        }else{
            flag= false;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // super.postHandle(request, response, handler, modelAndView);
        // String token = request.getHeader("X-Token");
        // PrintWriter out =response.getWriter();
//        if(!token.equals("")){
//            if (TokenUtil.valid(token).get("Result").equals(GlobalValue.TOKEN_NEED_REFRESH)) {
//                JSONObject jsonObject =new JSONObject();
//                jsonObject.put("refresh_token", "yes");
//                ModelAndView mv=modelAndView;
//                // out.write(jsonObject.toJSONString());
//            }
//        }


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        /*String token = request.getHeader("X-Token");
        PrintWriter out =response.getWriter();
        if(!token.equals("")){
            if (TokenUtil.valid(token).get("Result").equals(GlobalValue.TOKEN_NEED_REFRESH)) {
                JSONObject jsonObject =new JSONObject();
                jsonObject.put("refresh_token", "yes");
                out.write(jsonObject.toJSONString());
            }
        }*/
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
