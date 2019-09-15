package test.testservie;

import com.Entity.NoteUser;
import com.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/dispatcher-servlet.xml","classpath:config/applicationContext.xml "})
public class TestUserService {
    @Autowired
    private UserService userService;

    @Test
    public void testTransaction(){
        NoteUser user=new NoteUser();
        user.setUsername("hah");
        userService.updateUserInfo(user);
    }

    @Test
    public void testgetUserInfo(){
        NoteUser userinfo=userService.getUserInfo("305674b0918a44dd9d87f880454363dc");
        System.out.println(userinfo);
    }
}
