package com.jnshu.tool.aliMailUtil;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**阿里邮件推送
 * */

@Component
public class AliMailUtil {
    private static final Logger logger= LogManager.getLogger(AliMailUtil.class);

    @Autowired
    AliMailBean aliMailBean;

    public void sendMail(String email,String message) {
// 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou",aliMailBean.getAccessKeyId(),aliMailBean.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName(aliMailBean.getAccountName());
            request.setAddressType(1);
            request.setReplyToAddress(true);//发送到网易邮箱没有一点问题
            //这里设置发送的邮箱
            request.setToAddress(email);
            //邮箱主题
            request.setSubject(aliMailBean.getSubject());
            //邮件使用的标签
            request.setTagName(aliMailBean.getTagName());
            //邮件html主题的内容
            request.setHtmlBody("您的验证码为:"+message);
            //发件人昵称
            request.setFromAlias(aliMailBean.getFromAlias());
            logger.error("发送邮件");
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            logger.error(new Gson().toJson(httpResponse));
        } catch (ServerException e) {
            logger.error("bug1");
            e.printStackTrace();
        } catch (ClientException e) {
            logger.error("bug2");
            e.printStackTrace();
        }
    }
}
