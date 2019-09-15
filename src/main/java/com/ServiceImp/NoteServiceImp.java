package com.ServiceImp;

import com.Dao.NoteDao;
import com.Entity.Note;
import com.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImp implements NoteService{

    @Autowired
    private NoteDao noteDao;

    /*该用户在该文件夹下是否文件重名*/
    public boolean checkNoteName(String userid,String directoryid,String filename) {
        Note note=noteDao.checkNoteName(userid,filename,directoryid);

        if(note==null){
            return true;
        }
        return false;
    }

    public String unUserName(String userid,String directoryid,String filename){
        filename=filename+ UUID.randomUUID().toString().substring(1,5);
        while(!checkNoteName(userid,directoryid,filename)){
            filename=filename+ UUID.randomUUID().toString().substring(1,5);
        }
        return filename;
    }

    public boolean changeOneNote(int noteid,String filename) {
        boolean rs=noteDao.changeOneNote(noteid,filename);
        return rs;
    }

}
