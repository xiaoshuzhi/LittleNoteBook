package com.Dao;

import com.Entity.NoteUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteUserDao {
    /*用于注册的接口
    用户传入用户名,邮件，密码，其他信息都按默认值，在插入数据库前预装到对象中
    * */
    boolean insertUser (@Param("noteuser") NoteUser noteUser);

    /*用于登录验证，通过用户名获得密码等重要信息，登录成功后将存入session中，用于
    * 后续的标识*/
    NoteUser getUser(@Param("email") String email);

    /*显示用户个人信息，需要返回用
    户头像路径、用户名、用户已用空间、用户总空间、
    用户邮箱、地区和用户签名*/
    NoteUser getUserInfo(@Param("uuid") String uuid);

    boolean updateUserInfo(@Param("noteuser") NoteUser noteUser);

    boolean updateUserImg(@Param("headimg") String headimg,@Param("userid")String userid);

    String getReadLock(@Param("userid")String userid);

    boolean setReadLock(@Param("userid") String userid,@Param ("readlock") String readlock);

    String getEmail(@Param("email")String email);
}
