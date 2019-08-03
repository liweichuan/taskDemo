//import com.aliyun.oss.OSS;
//
//import java.io.*;
//
//import com.aliyun.oss.OSSClientBuilder;
//import com.aliyun.oss.model.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:spring/applicationContext.xml")
//public class OssTest {
//    private static final Logger logger= LogManager.getLogger(OssTest.class);
//    // Endpoint以杭州为例，其它Region请按实际情况填写。
//    String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
//    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
//    String accessKeyId = "LTAIX0q3dXdy0Bpw";
//    String accessKeySecret = "tBWa4Mo3d4IFS0ty31Eojn4GVP0nYT";
//    String bucketName = "jnshu-task7";
//    // 创建OSSClient实例。
//    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//    //上传
//    @Test
//    public void Upload(){
//        // 判断Bucket是否存在。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//        if (ossClient.doesBucketExist(bucketName)) {
//            logger.error("您已经创建Bucket：" + bucketName + "。");
//        } else {
//            logger.error("您的Bucket不存在，创建Bucket：" + bucketName + "。");
//            // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//            ossClient.createBucket(bucketName);
//        }
//
//        // 查看Bucket信息。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
//        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
//        BucketInfo info = ossClient.getBucketInfo(bucketName);
//        logger.error("Bucket " + bucketName + "的信息如下：");
//        logger.error("\t数据中心：" + info.getBucket().getLocation());
//        logger.error("\t创建时间：" + info.getBucket().getCreationDate());
//        logger.error("\t用户标志：" + info.getBucket().getOwner());
//
//        //第二个参数yourObjectName就是你的文件名（OSS）
//        // 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
//        ossClient.putObject(bucketName, "picture/14.jpg", new File("C:\\Users\\liweichuan\\Pictures\\Saved Pictures\\14.jpg"));
//
//
//    }
//
//    //查看
//    @Test
//    public void check(){
//        // 查看Bucket中的Object。详细请参看“SDK手册 > Java-SDK > 管理文件”。
//        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_object.html?spm=5176.docoss/sdk/java-sdk/manage_bucket
//        ObjectListing objectListing = ossClient.listObjects(bucketName);
//        List<OSSObjectSummary> objectSummary = objectListing.getObjectSummaries();
//        System.out.println("您有以下Object：");
//        for (OSSObjectSummary object : objectSummary) {
//            logger.error("\t" + object.getKey());
//        }
//    }
//    //下载
//    @Test
//    public void load(String name) throws IOException {
//        GetObjectRequest request = new GetObjectRequest(bucketName, "picture/14.jpg");
//        ossClient.getObject(request, new File(name));
//    }
//    //删除
//    @Test
//    public void delete(){
//        // 删除Object。详细请参看“SDK手册 > Java-SDK > 管理文件”。
//        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_object.html?spm=5176.docoss/sdk/java-sdk/manage_bucket
//        ossClient.deleteObject(bucketName,"picture/14.jpg");
//        logger.error("删除Object：" + "" + "成功。");
//    }
//    @After
//    public void close(){
//        // 关闭OSSClient。
//        ossClient.shutdown();
//    }
//}
//
