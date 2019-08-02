import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class UpLoad {

    public static void main(String[] args) {
        Configuration cfg = new Configuration(Zone.zone0()); //zong1() 代表华北地区
        UploadManager uploadManager = new UploadManager(cfg);

        String accessKey = "AaoYDkw7DwRw0i08Z0fKfoM0utpWyXYymOxad90l";//AccessKey的值
        String secretKey = "Va0RrU9nulAJw4bfCqCt37XpQq6SxhjDyhfHlHD3";//SecretKey的值
        String bucket = "lianchenyouxu";      //存储空间名
        String localFilePath = "C:\\Users\\liweichuan\\Pictures\\Saved Pictures\\10.jpg";//上传图片路径

        String key = "10.jpg";               //在七牛云中图片的命名
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}