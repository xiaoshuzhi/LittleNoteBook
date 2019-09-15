package com.Service;

import com.Entity.NoteUser;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    public boolean checkPassWord(NoteUser noteUser , String validateCode, String theCode, HttpServletRequest request);
    public boolean updateUserInfo(NoteUser noteuser);
    public NoteUser getUserInfo(String userid);
}
