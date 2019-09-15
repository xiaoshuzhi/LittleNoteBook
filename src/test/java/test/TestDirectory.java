package test;

import com.Dao.DirectoryDao;
import com.Entity.Directory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/dispatcher-servlet.xml","classpath:config/applicationContext.xml "})
public class TestDirectory {
    @Autowired
    private DirectoryDao directoryDao;

    @Test
    public void testInsertOneDirectory(){
        Directory directory=new Directory();
        directory.setDirectoryid("directoryuuid");
        directory.setUserid("useruuid");
        directory.setDirectory("测试文件夹");
        directory.setIsddele("no");
        directory.setIsdlocked("no");
        boolean rs=directoryDao.insertOneDirectory(directory);
        System.out.println(rs);
    }

    @Test
    public void testchangeDirectory(){
        directoryDao.changeDirectory("directoryuuid","修改文件夹1");
    }

    @Test
    public void testChangeIsdDele(){
        directoryDao.changeIsdDele("directoryuuid","yes");
    }
    @Test
    public void testChangeIsdLocked(){

        directoryDao.changeIsdLocked("directoryuuid","yes");

        String directory=directoryDao.getDirectory("directoryuuid");
        System.out.println(directory);
    }




}
