package com.jnshu.tool.aliRefererUtil;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.BucketReferer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**防盗链
 * */

@Component
public class RefererUtil {
    private static final Logger logger= LogManager.getLogger(RefererUtil.class);

    @Autowired
    private RefererBean refererBean;

    //创建referer白名单
    public void setReferer(List<String> refererList,boolean referer){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(refererBean.getEndpoint(),refererBean.getAccessKeyId(),refererBean.getAccessKeySecret());
        //   List<String> refererList = new ArrayList<String>();
        //   // 添加Referer白名单。Referer参数支持通配符星号（*）和问号（？）。
        //   refererList.add("http://www.aliyun.com");
        //   refererList.add("http://www.*.com");
        //   refererList.add("http://www.?.aliyuncs.com");
        // 设置存储空间Referer列表。设为true表示Referer字段允许为空。
        BucketReferer br = new BucketReferer(referer, refererList);
        ossClient.setBucketReferer(refererBean.getBucketName(), br);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
    //查找referer白名单
    public void getReferer(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(refererBean.getEndpoint(),refererBean.getAccessKeyId(),refererBean.getAccessKeySecret());
        // 获取存储空间Referer白名单列表。
        BucketReferer br = ossClient.getBucketReferer(refererBean.getBucketName());
        List<String> refererList = br.getRefererList();
        for (String referer : refererList) {
            System.out.println(referer);
        }

        // 关闭OSSClient。
        ossClient.shutdown();
    }
    //删除白名单referer
    public void deleteReferer(){
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(refererBean.getEndpoint(),refererBean.getAccessKeyId(),refererBean.getAccessKeySecret());
        // 防盗链不能直接清空，需要新建一个允许空Referer的规则来覆盖之前的规则。
        BucketReferer br = new BucketReferer();
        ossClient.setBucketReferer(refererBean.getBucketName(), br);

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
