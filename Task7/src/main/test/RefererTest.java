import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.BucketReferer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RefererTest {
    private static final Logger logger= LogManager.getLogger(RefererTest.class);

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint;
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId ;
    String accessKeySecret;
    String bucketName;
    private OSS ossClient;

    @Before
    public void CreateOSS(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
         endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
         accessKeyId = "LTAIX0q3dXdy0Bpw";
         accessKeySecret = "tBWa4Mo3d4IFS0ty31Eojn4GVP0nYT";
         bucketName = "jnshu-task7";

        // 创建OSSClient实例。
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

    }

    //设置防盗链白名单
    @Test
    public void setReferer(){
        List<String> refererList = new ArrayList<String>();
        // 添加Referer白名单。Referer参数支持通配符星号（*）和问号（？）。
        refererList.add("http://www.aliyun.com");
        refererList.add("http://www.*.com");
        refererList.add("http://www.?.aliyuncs.com");
        logger.error(refererList);
        // 设置存储空间Referer列表。设为true表示Referer字段允许为空。
        BucketReferer br = new BucketReferer(true, refererList);
        ossClient.setBucketReferer(bucketName, br);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    //查询防盗链白名单
    @Test
    public void getReferer(){
        // 获取存储空间Referer白名单列表。
        BucketReferer br = ossClient.getBucketReferer(bucketName);
        List<String> refererList = br.getRefererList();
        for (String referer : refererList) {
            System.out.println(referer);
        }

         // 关闭OSSClient。
        ossClient.shutdown();
    }

    //删除防盗链白名单
    @Test
    public void deleteReferer(){
        // 防盗链不能直接清空，需要新建一个允许空Referer的规则来覆盖之前的规则。
        BucketReferer br = new BucketReferer();
        ossClient.setBucketReferer(bucketName, br);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
