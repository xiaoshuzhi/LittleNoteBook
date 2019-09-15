package com.Service;

public interface NoteService {
    public boolean checkNoteName(String userid,String directoryid,String filename);
    public boolean changeOneNote(int noteid,String filename);
    /*得到没有重复的问价名*/
    public String unUserName(String userid,String directoryid,String filename);
}
