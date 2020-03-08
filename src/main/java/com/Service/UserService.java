package com.Service;

import com.Entity.NoteUser;
import com.Entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    public String checkPassWord(User noteUser , String validateCode, String theCode, HttpServletRequest request);

    public String checkEmailExist(String email);
//    public boolean updateUserInfo(NoteUser noteuser);
//    public NoteUser getUserInfo(String userid);
}
