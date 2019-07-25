package com.jnshu.tool.aliSmsUtil;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 阿里短信验证码发送工具类
 */

/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.0.3</version>
</dependency>
*/
//这里我们把手机号和验证码设为变量,引入phone和message
@Component
public class AliSmsUtil {
    private static final Logger logger= LogManager.getLogger(AliSmsUtil.class);
    @Autowired
    private AliSmsBean aliSmsBean;

    final String domain="dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

    public void sendMesg(String phone,String message) throws ClientException,ServerException {
        System.setProperty("sun.net.client.defaultConnectTimeout", aliSmsBean.getConnectTimeout());
        System.setProperty("sun.net.client.defaultReadTimeout", aliSmsBean.getReadTimeout());

        //初始化acsClient,暂不支持region化
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou",aliSmsBean.getAccessKeyId(),aliSmsBean.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //必填:待发送手机号
        request.putQueryParameter("PhoneNumbers", phone);
        //必填:短信签名-可在短信控制台中找到
        request.putQueryParameter("SignName",aliSmsBean.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.putQueryParameter("TemplateCode",aliSmsBean.getTemplateCode());

        request.putQueryParameter("TemplateParam", "{\"code\":"+message+"}");

        CommonResponse response = client.getCommonResponse(request);
        logger.error(response.getData());

    }
}