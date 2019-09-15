package com.ServiceImp;

import Utils.MD5;
import com.Dao.NoteUserDao;
import com.Entity.NoteUser;
import com.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private NoteUserDao noteUserDao;

    public boolean checkPassWord(NoteUser noteUser, String validateCode, String theCode, HttpServletRequest request) {
        /*
            1.验证码是否的正确
            2.查询用户名是否存在
            3.查询用户密码是否匹配
            4.返回检查结果
        * */
        System.out.println(theCode+" se"+validateCode);
        if(theCode.equals(validateCode)){
            NoteUser noteUser1=noteUserDao.getUser(noteUser.getEmail());/*通过邮箱得到用户重要的基本信息*/
            if(noteUser1!=null){
                if(noteUser1.getPassword().equals(MD5.strToMd5(noteUser.getPassword()))) {
                    request.getSession().setAttribute("userInfo",noteUser1);/*将用户重要的基本信息放入session中*/
                    return true;
                }else{
                    request.getSession().removeAttribute("userInfo");/*移除session*/
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateUserInfo(NoteUser noteuser) {
        /*将用户信息插入数据库中，如果发生异常，回滚。
         *这里需要用到事务。
        * */
        boolean rs=noteUserDao.updateUserInfo(noteuser);
        return rs;
    }

    public NoteUser getUserInfo(String userid) {
        NoteUser noteUser=noteUserDao.getUserInfo(userid);
        return noteUser;
    }
}
