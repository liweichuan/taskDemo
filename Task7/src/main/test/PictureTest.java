import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.GetObjectRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Date;

public class PictureTest {
    private static final Logger logger=LogManager.getLogger(PictureTest.class);


    @Test
    public void urlTest(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "<yourAccessKeyId>";
        String accessKeySecret = "<yourAccessKeySecret>";
        String bucketName = "<yourBucketName>";
        String objectName = "<yourObjectName>";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 设置图片处理样式。
        String style = "image/resize,m_fixed,w_100,h_100/rotate,90";
        // 指定过期时间为10分钟。
        Date expiration = new Date(new Date().getTime() + 1000 * 60 * 10 );
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.GET);
        req.setExpiration(expiration);
        req.setProcess(style);
        URL signedUrl = ossClient.generatePresignedUrl(req);
        System.out.println(signedUrl);
        // 关闭OSSClient。
        ossClient.shutdown();
//        sClient.shutdown();
    }

    @Test
    public void pictureTest(){
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIX0q3dXdy0Bpw";
        String accessKeySecret = "tBWa4Mo3d4IFS0ty31Eojn4GVP0nYT";
        String bucketName = "jnshu-task7";
        String objectName = "picture/liweichuan";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 缩放
        String style = "image/resize,m_fixed,w_100,h_100";
        GetObjectRequest request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-resize.jpg"));
        // 裁剪
        style = "image/crop,w_100,h_100,x_100,y_100,r_1";
        request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-crop.jpg"));
        // 旋转
        style = "image/rotate,90";
        request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-rotate.jpg"));
        // 锐化
        style = "image/sharpen,100";
        request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-sharpen.jpg"));
        // 水印
        style = "image/watermark,text_SGVsbG8g5Zu-54mH5pyN5YqhIQ";
        request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-watermark.jpg"));
        // 格式转换
        style = "image/format,png";
        request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-format.png"));
        // 获取图片信息
        style = "image/info";
        request = new GetObjectRequest(bucketName, objectName);
        request.setProcess(style);
        ossClient.getObject(request, new File("example-info.txt"));
        // 关闭OSSClient。
        ossClient.shutdown();
    }



}
