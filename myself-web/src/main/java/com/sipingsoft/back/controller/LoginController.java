package com.sipingsoft.back.controller;

import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.exception.RandomCodeException;
import com.sipingsoft.core.util.SecuritryCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public ResponseMessage createCode(String picName, ShiroHttpServletRequest request) {
        try {
            //刷新验证码,删除之前生成的验证码图片
            if (picName != null) {
                String path = ResourceUtils.getURL("classpath:").getPath() + "/static/codeImage/" + picName;
                File file = new File(path);
                if (file.exists() && file.isFile()) {
                    file.delete();
                }
            }
            Map<String, Object> map = SecuritryCodeUtil.generateCodeAndPic(request);
            List<Map<String, Object>> list = new ArrayList();
            list.add(map);
            return new ResponseMessage(200, "验证码获取成功", list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseMessage(500, "验证码获取失败", null);
    }


    /**
     * 验证码校验
     *
     * @param code 验证码
     * @return
     */
    @PostMapping("/back/login/checkCode")
    @ResponseBody
    public ResponseMessage checkCode(String picName, String code, ShiroHttpServletRequest request) throws RandomCodeException, FileNotFoundException {
        if (checkRandomCode(picName, code, request)) {
            return new ResponseMessage(200, "验证成功");
        }
        return new ResponseMessage(500, "验证码校验失败");
    }

    /**
     * 验证校验码
     *
     * @param picName 校验码图片名称
     * @param code    校验码
     * @param request 请求对象
     * @throws RandomCodeException   校验码错误异常
     * @throws FileNotFoundException 文件不存在异常
     */
    private boolean checkRandomCode(String picName, String code, ShiroHttpServletRequest request) throws RandomCodeException, FileNotFoundException {
        if (code == null) {
            throw new RandomCodeException("验证码不能为空");
        } else {
            String sessionCode = request.getSession().getAttribute("randomCode").toString();
            if (!sessionCode.toUpperCase().equals(code.toUpperCase())) {
                throw new RandomCodeException("验证码错误");
            }
        }
        //删除验证码图片
        String path = ResourceUtils.getURL("classpath:").getPath() + "/static/codeImage/" + picName;
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        return true;
    }

}
