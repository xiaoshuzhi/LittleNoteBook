package test.testservie;

import com.Service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/dispatcher-servlet.xml", "classpath:config/spring-applicationContext.xml "})
public class TestNoteService {

    /*@Autowired
    private NoteService noteService;
    @Test
    public void testcheckfilename(){
        boolean rs=noteService.checkNoteName("305674b0918a44dd9d87f880454363dc","文件夹uuid","测试文件1");
        System.out.println(rs);
    }*/
}
