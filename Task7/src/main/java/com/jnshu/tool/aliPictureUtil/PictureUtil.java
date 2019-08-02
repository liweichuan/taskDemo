package com.jnshu.tool.aliPictureUtil;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

/**缩略图
 * */

@Component
public class PictureUtil {
    private static final Logger logger= LogManager.getLogger(PictureUtil.class);

    @Autowired
    PictureBean pictureBean;

    //传入想修改的图片的对象名称
    public void setPicture(String objectName){
        pictureBean.setObjectName(objectName);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(pictureBean.getEndpoint(), pictureBean.getAccessKeyId(), pictureBean.getAccessKeySecret());
        // 缩放
        String style = "image/resize,m_fixed,w_100,h_100";
        GetObjectRequest request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
        request.setProcess(style);
        //这里给下载的缩略图进行重命名
        ossClient.getObject(request, new File("example-resize.jpg"));
        // 裁剪
//        style = "image/crop,w_100,h_100,x_100,y_100,r_1";
//        request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
//        request.setProcess(style);
//        ossClient.getObject(request, new File("example-crop.jpg"));
//        // 旋转
//        style = "image/rotate,90";
//        request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
//        request.setProcess(style);
//        ossClient.getObject(request, new File("example-rotate.jpg"));
//        // 锐化
//        style = "image/sharpen,100";
//        request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
//        request.setProcess(style);
//        ossClient.getObject(request, new File("example-sharpen.jpg"));
//        // 水印
//        style = "image/watermark,text_SGVsbG8g5Zu-54mH5pyN5YqhIQ";
//        request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
//        request.setProcess(style);
//        ossClient.getObject(request, new File("example-watermark.jpg"));
//        // 格式转换
//        style = "image/format,png";
//        request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
//        request.setProcess(style);
//        ossClient.getObject(request, new File("example-format.png"));
//        // 获取图片信息
//        style = "image/info";
//        request = new GetObjectRequest(pictureBean.getBucketName(), objectName);
//        request.setProcess(style);
//        ossClient.getObject(request, new File("example-info.txt"));
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
