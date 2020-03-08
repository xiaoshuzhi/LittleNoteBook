package test;


import com.Dao.NoteDao;
import com.Entity.Directory;
import com.Entity.Note;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/dispatcher-servlet.xml", "classpath:config/spring-applicationContext.xml "})
public class TestNote {
    @Autowired
    private NoteDao noteDao;
    @Test
    public void testInsertOneNote(){
        Note note=new Note();
        note.setUserid("305674b0918a44dd9d87f800454363dc");
        note.setAbstractnote("这是一个测试文件摘要");
       // note.setUsername("倾国倾城");
       // note.setSource(null);
       // note.setDirectory("我的文件");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime=format.format(new Date());
        note.setCreatetime(createTime);
        note.setUpdatetime(createTime);
       // note.setLabelnum(0);
        note.setIsdele("no");
        note.setIslocked("no");
      //  note.setDirectoryid("uuid");
        note.setFilename("新建文件");
       // note.setSize(0);
        noteDao.insertOneNote(note);

    }
    @Test
    public void testChangeOneNote(){
        boolean rs=noteDao.changeOneNote(2,"测试文件1");
        System.out.println(rs);
    }

    @Test
    public void testChangeDirectory(){
        boolean rs=noteDao.changeDirectory(2,"测试文件夹1","文件夹uuid");
        System.out.println(rs);
    }

    @Test
    public void testChangeIsDele(){
        boolean rs=noteDao.changeIsDele(2,"yes");
        System.out.println(rs);
    }

    @Test
    public void testChangeIsLocked(){
        boolean rs=noteDao.changIsLocked(2,"yes");
        System.out.println(rs);
    }


    @Test
    public void testChangLabelnum(){
        boolean rs=noteDao.changLabelnum(2,1);
        System.out.println(rs);
    }

    @Test
    public void testGetOneNoteWithLabels(){
        Note note=noteDao.getOneNoteWithLabels(99);
        System.out.println(note);
    }

    @Test
    public void testGetUserAllNotes(){
        /*List<Note> note=noteDao.getUserAllNotes("305674b0918a44dd9d87f880454363dc");
        for (Note note1 : note) {
            System.out.println(note1);
        }*/

        /*boolean rs=noteDao.deleteAllPics("305674b0918a44dd9d87f880454363dc",2);
        System.out.println(rs);*/
        /*Img img = new Img();
        img.setImgid("t3");;
        img.setImgsize((double)10);
        img.setUserid("305674b0918a44dd9d87f880454363dc");
        img.setIngname("插入");
        img.setNoteid(2);
      *//*  boolean rs2 = noteDao.inserOneImg(img);*//*
        List<Img> list=new ArrayList<>();
        list.add(img);
        list.add(img);
        ObjectMapper mapper=new ObjectMapper();
        try {

            System.out.println(mapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
*/

       /* Img imge=new Img();
        imge.setImgid(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString().substring(0,31));
        noteDao.inserOneImg(imge);*/
       List<Directory> dirs=new ArrayList<>();
        Directory dir = new Directory();
        // dir.setDirectoryid("directoryuui");
        dirs.add(dir);
        List<Note> notes=noteDao.getAllDeleteNotesd("305674b0918a44dd9d87f880454363dc",dirs);
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
