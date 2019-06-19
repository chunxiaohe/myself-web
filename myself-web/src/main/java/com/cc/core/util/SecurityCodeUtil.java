package com.cc.core.util;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 验证码生成类
 *
 * @author HeChunXiao
 * @since 2018-11-01 下午 2:10
 */
public class SecurityCodeUtil {

    /**
     * 定义图片的宽
     */
    private static final int WIDTH = 200;
    /**
     *定义图片的高
     */
    private static final int HEIGHT = 100;
    /**
     *定义图片上验证码的显示个数
     */
    private static final int CODE_COUNT = 4;
    /**
     *干扰线的个数
     */
    private static final int CIRCLE_COUNT = 15;



    /**
     * 验证码生成
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public static void genaratorVerificationCode(ShiroHttpServletRequest request, ShiroHttpServletResponse response) throws IOException {
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(WIDTH, HEIGHT, CODE_COUNT, CIRCLE_COUNT);
        captcha.createCode();
        String code = captcha.getCode();
        //将验证码存到session中,便于登录验证
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("randomCode", code.toUpperCase());
        captcha.write(response.getOutputStream());
    }


}
