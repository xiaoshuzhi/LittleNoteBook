package test;

import com.Dao.LabelDao;
import com.Entity.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/dispatcher-servlet.xml","classpath:config/applicationContext.xml "})
public class TestLabel {
    @Autowired
    LabelDao labelDao;
    @Test
    public void testchangeLabelname(){
        boolean rs=labelDao.changeLabelname(1,"修改标签1");
        System.out.println(rs);
    }

    @Test
    public void testchangeLabeldele(){
        boolean rs=labelDao.changeLabeldele(1,"no");
        System.out.println(rs);
    }

    @Test
    public void testinsertLabel(){
        Label label=new Label();
        label.setLabelname("插入一条标签");
        label.setLabeldele("yes");
        boolean rs=labelDao.insertLabel(label);
        System.out.println(rs);
    }

    @Test
    public void testgetAllLabel(){
       List<Label> list=labelDao.getAllLabel("305674b0918a44dd9d87f880454363dc");
        for (Label label : list) {
            System.out.println(label);
        }
    }

    @Test
    public void testgetAllLabelOfNote(){
        List<Label> list= labelDao.getAllLabelOfNote(2);
        for (Label label : list) {
            System.out.println(label);
        }
    }
}
