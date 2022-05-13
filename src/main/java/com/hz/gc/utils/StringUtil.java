package com.hz.gc.utils;
 
import java.util.UUID;
 
/**七牛云生成唯一图片名称的工具类
 * @ClassName StringUtil
 **/
public class StringUtil {
    public static String getRandomImgName(String fileName) {
 
        // 获取文件后缀
        int index = fileName.lastIndexOf(".");
        String suffix = fileName.substring(index);
 
        //检验文件
        if(".jpg".equals(suffix) || ".jpeg".equals(suffix) || ".png".equals(suffix)){
            //改变上传到服务器的文件名  uuid + suffix
            // 生成UUID
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            String path = uuid + suffix;
            return path;
        }else{
            throw new IllegalArgumentException();
        }
    }
}