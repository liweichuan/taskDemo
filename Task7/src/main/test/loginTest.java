import com.jnshu.dao.UserDao;
import com.jnshu.entity.User;
import com.jnshu.service.StudentService;
import com.jnshu.tool.Md5Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//使用注解完成测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
public class loginTest {
    private static final Logger logger= LogManager.getLogger(loginTest.class);

    @Autowired
    Md5Util md5Util;

    @Autowired
    UserDao userDao;
    @Test
    public void login(){
        //将密码加密加盐
        User user=userDao.findUserByName("lianchen");
        logger.error(user);
        String passWord = Md5Util.generate(user.getPassword());//对密码进行加密加盐
        user.setPassword(passWord);//将加密加盐的密码存储在user的属性中
        userDao.updateUser(user);
    }

}
