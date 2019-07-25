import com.jnshu.tool.RedisUtil;
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
public class redisUtilTest {
    private static final Logger logger= LogManager.getLogger(redisUtilTest.class);

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void setTest(){
        redisUtil.set("aaaa13699670397","123456");
        logger.error(redisUtil);
    }
    @Test
    public void getTest(){
        String key="lianchen";
        logger.error(redisUtil.get(key));
        //getkey 得到的是一个object，需要转成对应的格式
    }
}
