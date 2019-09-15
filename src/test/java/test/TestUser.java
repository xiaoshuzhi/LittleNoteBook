package test;

import com.Dao.NoteUserDao;
import com.Entity.NoteUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/dispatcher-servlet.xml","classpath:config/applicationContext.xml "})
public class TestUser {

    @Autowired

    private NoteUserDao userDao;

    @Test
    public void testInsertUser(){
        NoteUser user=new NoteUser();
        user.setUserid(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("小李");
        user.setPassword("xiao123");
        user.setGender(1);
        user.setAddress("江西萍乡");
        user.setUse(0);
        user.setTotal(3);
        user.setReadlock("no");
        user.setDatalocation("D:\\mynotebook\\data");
        user.setEmail("xiaoshuzhi@163.com");
        user.setType(1);
        System.out.println(user);
        userDao.insertUser(user);
        System.out.println("hah ");
    }

    @Test
    public void testGetUser(){
        NoteUser noteUser=userDao.getUser(".com");
        System.out.println(noteUser);
    }

    @Test
    public void testGetUserInfo(){
        NoteUser noteuser=userDao.getUserInfo("305674b0918a44dd9d87f880454363dc");
        System.out.println(noteuser);
    }

    @Test
    public void testUpdateUserInfo(){
        NoteUser noteuser=userDao.getUserInfo("305674b0918a44dd9d87f880454363dc");
        noteuser.setUsername("倾国倾城");
        noteuser.setAddress("江西南昌");
        noteuser.setLogo("你问我爱你值不值得，爱不问值不值得");
        userDao.updateUserInfo(noteuser);

    }
}
