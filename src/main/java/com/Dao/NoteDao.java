package com.Dao;

import com.Entity.Directory;
import com.Entity.Img;
import com.Entity.Note;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface NoteDao {

    /*插入一条数据到笔记表中*/
    boolean insertOneNote(@Param("note")Note note);

    /*重命名，根据笔记id，以及传入的文件名，修改笔记名*/
    boolean changeOneNote(@Param("noteid") int noteid,@Param("filename") String filename);

    /*移动到。根据笔记id,修改笔记的文件夹名、文件夹id*/
    boolean changeDirectory(@Param("noteid") int noteid,@Param("directory")String directory,@Param("directoryid") String directoryid);

    /*删除或者取消删除。根据笔记id,将isdele设置为yes*/
    boolean changeIsDele(@Param("noteid")int noteid,@Param("isdele") String isdele);

    /*设置阅读锁或者取消阅读锁。根据笔记id，将islocked设置为yes*/
    boolean changIsLocked(@Param("noteid") int noteid,@Param("islocked") String islocked);

    /*标签数改变*/
    boolean changLabelnum(@Param("noteid") int noteid,@Param("labelnum") int labelnum);

    /*得到指定id的文件基本信息，以及和它关联的标签*/
    Note getOneNoteWithLabels(@Param("noteid") int  noteid);

    String getNoteFilename(@Param("noteid") int noteid);

    /*得到指定用户的所有文件*/
    List<Note> getUserAllNotes(@Param("userid") String userid);

    /*修改文件名*//*创建文件之后，需要获取文件的id，也可通过这个方法*/
    Note checkNoteName(@Param("userid") String userid,@Param("filename") String filename,@Param("directoryid") String directoryid);

    /*修改文件后，改变笔记的修改时间和大小*/
    boolean updataNoteChange(@Param("note") Note note);

    boolean inserOneImg(@Param("img")Img img);

    /*boolean deleteAllPics(@Param("userid") String userid,@Param("noteid")int noteid);*/

    boolean changeNotePicIsDel(@Param("noteid")int noteid,@Param("isdelete") String isdelete);

    List<Img>  getImgsOfNote(@Param("noteid")int noteid);

    boolean deleteImgsOfNote(@Param("noteid")int noteid);

    boolean deletOneNote(@Param("noteid")int noteid);

    List<Note> getAllDeleteNotesd(@Param("userid") String userid, @Param("dirs")List<Directory> dirs);

    List<Note> getAllDeleteNotes(@Param("userid") String userid);

    String getDirOfNote(@Param("noteid") int noteid);

    boolean changDeletByDid(@Param("directoryid")String directoryid,@Param("isdele")String isdele);

    List<Integer> getNoteidOfDir(@Param("directoryid")String directoryid);

    boolean changeisLockBydid(@Param("directoryid")String directoryid, @Param("islocked") String islocked );

    List<Note> getNotesOfDir(@Param("directoryid") String directoryid);
}
