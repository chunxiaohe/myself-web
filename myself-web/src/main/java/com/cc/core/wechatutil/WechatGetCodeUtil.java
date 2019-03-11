package com.cc.core.wechatutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author He Chunxiao
 * @date 2019-03-08 9:54
 * @desc
 */
public class WechatGetCodeUtil {

    public static String getWechatCode(){
        String code = "";
        StringBuilder result = new StringBuilder();
        String path = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=wx76cf3befc99015e3" +
                "&redirect_uri=REDIRECT_URI" +
                "&response_type=code" +
                "&scope=snsapi_base " +
                "#wechat_redirect";
        try {
            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            code = result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  code;
    }

    public static void main(String[] args) {
        String wechatCode = WechatGetCodeUtil.getWechatCode();
        System.out.println(wechatCode);
    }
}
