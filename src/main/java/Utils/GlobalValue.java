package Utils;

import javax.servlet.http.HttpServletRequest;

public class GlobalValue {


    public final static long SUCCESS_ACCESS_API_CODE = 20020;
    public final static String SUCCESS_ACCESS_API_MESSAGE = "成功访问api";
    public final static long FAIL_ACCESS_API_CODE = 50020;
    public final static String FAIL_ACCESS_API_MESSAGE = "访问api失败";
    /*TOKEN类型的常量 5000* */
    public final static long ILLEGAL_TOKEN_CODE = 50002;
    public final static String ILLEGAL_TOKEN_MESSAGE = "非法token";
    public final static long EXPIRED_TOKEN_CODE = 50004;
    public final static String EXPIRED_TOKEN_MESSAGE = "过期token";
    public final static long FAIL_CREATE_TOKEN_CODE = 50006;
    public final static String FAIL_CREATE_TOKEN_MESSAGE = "创建token失败";
    public final static long  TOKEN_NEED_REFRESH_CODE = 20001;
    public final static String TOKEN_NEED_REFRESH_MESSAGE = "token即将过期，需要刷新";
    public final static long TOKEN_VALIDATE_CODE= 20000;
    public final static String TOKEN_VALIDATE_MESSAGE = "token合法";
    /*login类型的常量*/
    public final static long LOGIN_FAIL_CODE = 50011;
    public final static String LOGIN_FAIL_MESSAGE = "用户名或密码错误";
    public final static long LOGIN_SUCCESS_CODE = 20010;
    public final static String LOGIN_SUCCESS_MESSAGE="登录成功";
    public final static long LOGIN_FAIL_WRONG_VALIDATE_CODE_CODE = 50012;
    public final static String LOGIN_FAIL_WRONG_VALIDATE_CODE_MESSAGE = "验证码错误";
    /*数据是否存在*/
    public final static long NOT_EXIST_CODE = 50030;
    public final static String NOT_EXIST_MESSAGE = "不存在";
    public final static long EXIST_CODE = 20030;
    public final static String EXIST_MESSAGE = "存在";
    /*密匙类型*/
    public static final String SECRET_Of_API = "seliradfwetadsfaadfllisedsliserf";
    public static final String SECRET_Of_Password = "weojapsodfoweojgapasodfopw";
    public static final String SECRET_OF_CODE = "codeesa";
    /*路径类型*/
    public final static String HEADER_URL = "http://localhost:8081/uploadDirectory/header/";

    public final static long TOKEN_NOT_VALIDATE_CODE= 50040;
    public final static String EMAIL_NOT_VALIDATE_MESSAGE = "非法邮箱";
    public final static String TOKEN_NOT_NEW_MESSAGE = "请使用最新验证码";
    public final static String TOKEN_ILLEGAL_MESSAGE = "非法验证码";
    public final static long VALIDATE_CODE= 20040;
    public final static String VALIDATE_MESSAGE = "验证码合法";

    public final static String WANGYI_163_CODE= "Lizq3016";
    public final static String WANGYI_EMAIL = "BrunoLi_lzq@163.com";
    public final static String WANGYI_EMAIL_HOST = "smtp.163.com";

    public static final long ALIVE_TIME = 60*60*1000;
    public static final long P_ALIVE_TIME = 5 * 60 * 1000;



    public static String getHttpUploadDirectory(HttpServletRequest request){
        /*服务器文件访问路径*/
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/uploadDirectory";
    }

    public static String getUploadDirectory(HttpServletRequest request){
        /*服务问价存放地址*/
        return request.getServletContext().getRealPath("/uploadDirectory");
    }
}
