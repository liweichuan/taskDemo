package com.jnshu.tool.aliOssUtil;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Component
public class OssUtil {
    private static final Logger logger= LogManager.getLogger(OssUtil.class);

    @Autowired
    private OssBean ossBean;
    // 创建OSSClient实例。
//    OSS ossClient = new OSSClientBuilder().build(ossBean.getEndpoint(),ossBean.getAccessKeyId(),ossBean.getAccessKeySecret());

    public void upFile(String ObjectName, MultipartFile file) throws IOException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossBean.getEndpoint(),ossBean.getAccessKeyId(),ossBean.getAccessKeySecret());

        // 判断Bucket是否存在。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
        if (ossClient.doesBucketExist(ossBean.getBucketName())) {
            logger.error("您已经创建Bucket：" + ossBean.getBucketName() + "。");
        } else {
            logger.error("您的Bucket不存在，创建Bucket：" + ossBean.getBucketName() + "。");
            // 创建Bucket。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
            // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
            ossClient.createBucket(ossBean.getBucketName());
        }
        // 查看Bucket信息。详细请参看“SDK手册 > Java-SDK > 管理Bucket”。
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_bucket.html?spm=5176.docoss/sdk/java-sdk/init
        BucketInfo info = ossClient.getBucketInfo(ossBean.getBucketName());
        logger.error("Bucket " + ossBean.getBucketName() + "的信息如下：");
        logger.error("\t数据中心：" + info.getBucket().getLocation());
        logger.error("\t创建时间：" + info.getBucket().getCreationDate());
        logger.error("\t用户标志：" + info.getBucket().getOwner());

        //设置下载时文件类型
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType(ossBean.getContentype());
        //上传文件，第一参数，存储空间，第二个参数储存在Oss上的位置（文件或对象），第三个参数是传入的文件
        ossClient.putObject(ossBean.getBucketName(), ObjectName, new ByteArrayInputStream(file.getBytes()), objectMetadata);
        ossClient.shutdown();
    }

    //查看只需要一个参数，存储空间
    public void check(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossBean.getEndpoint(),ossBean.getAccessKeyId(),ossBean.getAccessKeySecret());

        // 查看Bucket中的Object。详细请参看“SDK手册 > Java-SDK > 管理文件”。
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_object.html?spm=5176.docoss/sdk/java-sdk/manage_bucket
        ObjectListing objectListing = ossClient.listObjects(ossBean.getBucketName());
        List<OSSObjectSummary> objectSummary = objectListing.getObjectSummaries();
        System.out.println("您有以下Object：");
        for (OSSObjectSummary object : objectSummary) {
            logger.error("\t" + object.getKey());
        }
        ossClient.shutdown();
    }
    //下载,好像只能下载文字内容
    public void load(String ObjectName) throws IOException {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossBean.getEndpoint(),ossBean.getAccessKeyId(),ossBean.getAccessKeySecret());

        OSSObject ossObject = ossClient.getObject(ossBean.getBucketName(),ObjectName);
        InputStream inputStream = ossObject.getObjectContent();
        StringBuilder objectContent = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            objectContent.append(line);
        }
        inputStream.close();
        logger.error("Object：" + ObjectName + "的内容是：" + objectContent);
        ossClient.shutdown();
    }
    //删除
    public void delete(String ObjectName){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(ossBean.getEndpoint(),ossBean.getAccessKeyId(),ossBean.getAccessKeySecret());

        // 删除Object。详细请参看“SDK手册 > Java-SDK > 管理文件”。
        // 链接地址是：https://help.aliyun.com/document_detail/oss/sdk/java-sdk/manage_object.html?spm=5176.docoss/sdk/java-sdk/manage_bucket
        ossClient.deleteObject(ossBean.getBucketName(),ObjectName);
        logger.error("删除Object：" + ObjectName + "成功。");
        ossClient.shutdown();
    }
}