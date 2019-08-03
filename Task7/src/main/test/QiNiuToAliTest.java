//import com.aliyuncs.exceptions.ClientException;
//import com.jnshu.tool.aliOssUtil.OssUtil;
//import com.jnshu.tool.qiNiuOssUtil.QiNiuOssUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.io.File;
//import java.io.IOException;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
//public class QiNiuToAliTest {
//    @Autowired
//    OssUtil ossUtil;
//    @Autowired
//    QiNiuOssUtil qiNiuOssUtil;
//
//    @Test
//    public void QiNiuToAli() throws ClientException, IOException {
//        //七牛下载
//        qiNiuOssUtil.downLoad("10.jpg","10.jpg","C:/task/Task7/");
//        //阿里上传
//        ossUtil.upFile("10.jpg", new File("C:/task/Task7/10.jpg"));
//    }
//    @Test
//    public void AliToQiNiu() throws IOException {
//        //阿里下载
//        ossUtil.load("10.jpg");
//        //七牛上传
//        qiNiuOssUtil.upload("C:\\task\\Task7\\"+"10.jpg","10.jpg");
//    }
//}
