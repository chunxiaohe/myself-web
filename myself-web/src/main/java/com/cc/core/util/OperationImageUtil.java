package com.cc.core.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;


/**
 *
 *  图片操作的工具类
 * @author HeChunXiao
 * @since 2019-01-04 16:43
 */
public class OperationImageUtil {

    /**
     * 保存图片
     * @param file
     * @param path
     * @throws IOException
     */
    public static void saveImage(MultipartFile file, String path) throws IOException {
        InputStream inputStream = file.getInputStream();
        // 设置数据缓冲
        byte[] bs = new byte[1024 * 2];
        // 读取到的数据长度
        int len;
        OutputStream outputStream = new FileOutputStream(path);
        while ((len = inputStream.read(bs)) != -1) {
            outputStream.write(bs, 0, len);
        }
        //关闭流
        inputStream.close();
        outputStream.close();
    }

    /**
     * 0:删除的文件不存在
     * 1: 删除成功
     * 删除图片
     */
    public static Integer delateImage(String path){
        File file = new File(path);
        if (!file.exists()){
            return 0;
        }
        file.delete();
        return 1;
    }
}
