package com.cc.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * @author He Chunxiao
 * @date 2019-03-07 11:47
 * @desc
 */
@RestController
public class WechatController {

    /**
     * 微信URL验证
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @GetMapping("/wechat/getWechat")
    public String getCheket(String signature, String timestamp, String nonce, String echostr) {
        System.out.println(signature);
        System.out.println(timestamp);
        System.out.println(nonce);
        System.out.println(echostr);
        return echostr;
    }

    @GetMapping("/wechat")
    public String getWechatMessage(){
        return null;
    }















    @PostMapping("/wechat/getWechat")
    public String returnMessage(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = request.getReader()) {
            String str;
            while ((str = reader.readLine()) != null) {
                builder.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(builder);
        return "没有消息";
    }

    public static void main(String[] args) {
        //获取token
        getAccessToken();
    }


    private static void getAccessToken() {
        String result = "";
        BufferedReader in = null;
        try {
            String urlAddr = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx76cf3befc99015e3&secret=e8819474aa3001631a9085bbf4b45341";
            URL url = new URL(urlAddr);
            //打开URL连接
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        System.out.println(result);
    }

}
