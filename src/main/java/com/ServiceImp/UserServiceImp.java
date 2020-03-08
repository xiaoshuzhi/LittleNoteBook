package com.ServiceImp;

import Utils.GlobalValue;
import Utils.MD5;
import Utils.MyLogger;
import com.Dao.NoteUserDao;
import com.Dao.UserMapper;
import com.Entity.NoteUser;
import com.Entity.User;
import com.Entity.UserExample;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserMapper userMapper;
    private MyLogger logger = new MyLogger("UserServiceImp");

    public String checkPassWord(User user_bak, String serverCode, String clientCode, HttpServletRequest request) {
        /*
            1.验证码是否的正确
            2.查询用户名是否存在
            3.查询用户密码是否匹配
            4.返回检查结果
        * */

        logger.info("com.ServiceImp.UserServiceImp.checkPassWord: 服务端验证码", serverCode);
        logger.info("com.ServiceImp.UserServiceImp.checkPassWord: 客户端验证码", clientCode);
//        if(clientCode.equals(serverCode)){ //跨域丢失cookie信息，无法通过session获得serverCode，暂时不使用验证码登录
            //NoteUser noteUser1=noteUserDao.getUser(noteUser.getEmail());/*通过邮箱得到用户重要的基本信息*/
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andEmailEqualTo(user_bak.getEmail());
            List<User> user = userMapper.selectByExample(userExample);
            if(user.size()==1){
                if(user.get(0).getPassword().equals(MD5.strToMd5(user_bak.getPassword()))) {
                    // request.getSession().setAttribute("userInfo",noteUser1);/*将用户重要的基本信息放入session中*/
                    return GlobalValue.LOGIN_SUCCESS_MESSAGE;
                }else{
                    // request.getSession().removeAttribute("userInfo");/*移除session*/
                    return GlobalValue.LOGIN_FAIL_MESSAGE;
                }
            }else{
                return GlobalValue.LOGIN_FAIL_MESSAGE;
            }
//        }else{
//            return GlobalValue.LOGIN_FAIL_WRONG_VALIDATE_CODE_MESSAGE;
//        }
    }

    @Override
    public String checkEmailExist(String email) {
        UserExample userExample = new UserExample();
        UserExample.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() != 1) {
            return GlobalValue.NOT_EXIST_MESSAGE;
        }else {
            return GlobalValue.EXIST_MESSAGE;
        }

    }

    //    @Transactional(propagation = Propagation.REQUIRED)
//    public boolean updateUserInfo(NoteUser noteuser) {
//        /*将用户信息插入数据库中，如果发生异常，回滚。
//         *这里需要用到事务。
//        * */
//        boolean rs=noteUserDao.updateUserInfo(noteuser);
//        return rs;
//    }
//
//    public NoteUser getUserInfo(String userid) {
//        NoteUser noteUser=noteUserDao.getUserInfo(userid);
//        return noteUser;
//    }
}
