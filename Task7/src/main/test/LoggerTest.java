//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;
//
//public class LoggerTest {
//
//   private static Logger logger = LogManager.getLogger(LoggerTest.class);
//
//
//
//    public static void main(String[] args) {
//
//        logger.trace("开始主程序");
//
//        for (int i = 0; i < 10000; i++) {
//            //random()方法取大于等于0,小于1的double型数据
//            String message="";
//            for (int k=0;k<6;k++){
//                //使用concat将指定字符串连接到结尾
//                message=message.concat(String.valueOf((int)(Math.random()*10)));
//            }
//             logger.error(message);
//        }
//
//        logger.trace("退出程序");
//    }
//}