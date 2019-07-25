package com.jnshu.tool;


import org.springframework.stereotype.Component;

/**
 * 生成6位数的验证码的工具类
 */

@Component
public class MessageUtil {
    public String getMesgCode(){
        String message="";
        for (int i=0;i<6;i++){
            //使用concat将指定字符串连接到结尾
            message=message.concat(String.valueOf((int)(Math.random()*10)));
        }
        //把字符串转换成int返回
        return message;
    }
}
