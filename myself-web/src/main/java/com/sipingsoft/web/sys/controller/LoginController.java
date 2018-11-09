package com.sipingsoft.web.sys.controller;

import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.exception.RandomCodeException;
import com.sipingsoft.core.util.SecuritryCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
     * @param code 验证码
     * @param picName 验证码名称
     * @param model
     * @return
     */
    @PostMapping("sys/login")
    public String login(String username, String password,String code,String picName,String randomNum,  RedirectAttributes model,ShiroHttpServletRequest request) {
        //对比验证码
        Subject subject = SecurityUtils.getSubject();
        //记住我
        //rememberMe = true;
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            if(code==null ){
                throw new RandomCodeException();
            }else{
                String sessionCode =  request.getSession().getAttribute("randomCode").toString();
                if(!sessionCode.toUpperCase().equals(code.toUpperCase())){
                    throw new RandomCodeException();
                }
            }
            //删除验证码图片
            String path = ResourceUtils.getURL("classpath:").getPath()+"/static/codeImage/"+picName;
            File file = new File(path);
            if (file.exists()&&file.isFile()){
                file.delete();
            }
            return "redirect:/";
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
        } catch (RandomCodeException e){
            model.addAttribute("errorMsg","验证码错误");
        } catch (FileNotFoundException e){
            model.addAttribute("errorMsg","系统异常");
        }
        return "redirect:/page/login";
    }

    /**
     * 退出
     *
     * @return
     */
    @GetMapping("/sys/loginOut")
    public String loginOut() {
        SecurityUtils.getSubject().logout();
        return "redirect:/page/login";
    }

    /**
     * 生成验证码
     *
     * @return
     */
    @GetMapping("/login/createCode")
    @ResponseBody
    public ResponseMessage createCode(String picName, ShiroHttpServletRequest request) {
        try {
            //刷新验证码,删除之前生成的验证码图片
            if(picName != null){
                String path = ResourceUtils.getURL("classpath:").getPath()+"/static/codeImage/"+picName;
                File file = new File(path);
                if (file.exists()&&file.isFile()){
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
        return new ResponseMessage(500,"验证码获取失败",null);
    }

}
