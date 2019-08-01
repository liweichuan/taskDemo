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

public class SingleSendMail {
    private static final Logger logger= LogManager.getLogger(SingleSendMail.class);
    public static void main(String[] args) {
// 如果是除杭州region外的其它region（如新加坡、澳洲Region），需要将下面的"cn-hangzhou"替换为"ap-southeast-1"、或"ap-southeast-2"。
    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAIX0q3dXdy0Bpw", "tBWa4Mo3d4IFS0ty31Eojn4GVP0nYT");
    IAcsClient client = new DefaultAcsClient(profile);
    SingleSendMailRequest request = new SingleSendMailRequest();
     try {
       request.setAccountName("lianchen@lianchenyouxu.top");
       request.setAddressType(1);
       request.setReplyToAddress(true);//发送到网易邮箱没有一点问题
       request.setToAddress("1946931904@qq.com");
       request.setSubject("注册验证码");
       request.setTagName("task");
       request.setHtmlBody("您的验证码为666666");
       request.setFromAlias("liweichuan");
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
