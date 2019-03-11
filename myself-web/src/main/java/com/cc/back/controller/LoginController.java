package com.cc.back.controller;

import com.cc.core.entity.ResponseMessage;
import com.cc.core.exception.RandomCodeException;
import com.cc.core.util.SecuritryCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.servlet.ShiroHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 登录
 *
 * @author He Chunxiao
 */
@Controller
public class LoginController {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param model    提示信息模型
     * @return
     */
    @PostMapping("/back/login/submit")
    public String login(String username, String password, RedirectAttributes model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //校验用户名以及密码
            subject.login(token);
            return "redirect:/back/page/index";
        } catch (UnknownAccountException e) {
            //账号不存在
            model.addAttribute("errorMsg", "账号不存在");
        } catch (IncorrectCredentialsException e) {
            //密码错误
            model.addAttribute("errorMsg", "密码错误");
        } catch (LockedAccountException e) {
            model.addAttribute("errorMsg", "账号已被禁用");
        } catch (AuthenticationException e) {
            model.addAttribute("errorMsg", "账号或密码错误");
        }
        return "redirect:/back/page/login";
    }

    /**
     * 退出
     *
     * @return
     */
    @GetMapping("/back/login/loginOut")
    public String loginOut() {
        SecurityUtils.getSubject().logout();
        return "redirect:/back/page/login";
    }

    /**
     * 生成验证码
     *
     * @return
     */
    @GetMapping("/back/login/createCode")
    @ResponseBody
    public void createCode(ShiroHttpServletRequest request, ShiroHttpServletResponse response) throws IOException {
        SecuritryCodeUtil.genaratorVerificationCode(request,response);
    }


    /**
     * 验证码校验
     *
     * @param code 验证码
     * @return
     */
    @PostMapping("/back/login/checkCode")
    @ResponseBody
    public ResponseMessage checkCode(String code, ShiroHttpServletRequest request) throws RandomCodeException, FileNotFoundException {
        if (checkRandomCode(code, request)) {
            return new ResponseMessage(200, "验证成功");
        }
        return new ResponseMessage(500, "验证码校验失败");
    }

    /**
     * 验证校验码
     *
     * @param code    校验码
     * @param request 请求对象
     * @throws RandomCodeException   校验码错误异常
     * @throws FileNotFoundException 文件不存在异常
     */
    private boolean checkRandomCode(String code, ShiroHttpServletRequest request) throws RandomCodeException, FileNotFoundException {
        if (code == null) {
            throw new RandomCodeException("验证码不能为空");
        } else {
            String sessionCode = request.getSession().getAttribute("randomCode").toString();
            if (!sessionCode.toUpperCase().equals(code.toUpperCase())) {
                throw new RandomCodeException("验证码错误");
            }
        }
        return true;
    }
}

