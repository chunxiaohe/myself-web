package com.sipingsoft.core.util;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.util.ResourceUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 验证码生成类
 *
 * @author HeChunXiao
 * @since 2018-11-01 下午 2:10
 */
public class SecuritryCodeUtil {

    //定义图片的宽
    private static int width = 90;
    //定义图片的高
    private static int height = 20;
    //定义图片上验证码的显示个数
    private static int codeCount = 4;
    private static int xx = 15;
    //字体高度
    private static int fontHeight = 18;
    private static int codeY = 16;
    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   /* @Value("{webRoot}")
    private String path ;*/

    public static Map<String, Object> generateCodeAndPic(ShiroHttpServletRequest request) throws IOException {
        //定义图像的buffer
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //生成一个图片
        Graphics graphics = bufferedImage.createGraphics();
        //创建一个随机数生成器类
        Random random = new Random();
        //将图片填充成白色
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, width, height);

        //创建字体,字体的大小应该根据图片的高度来确定
        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);
        //设置字体
        graphics.setFont(font);

        //画边框
        graphics.setColor(Color.white);
        graphics.drawRect(0, 0, width - 1, height - 1);

        //随机生成40条干扰线,使图片中的验证码不易被其他程序检测到
        graphics.setColor(Color.black);
        int num = 30 ;
        for (int i = 0; i < num; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        // randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
        StringBuilder randomCode = new StringBuilder();
        int red = 0 ,green = 0 , blue = 0;
        // 随机产生codeCount数字的验证码。
        for (int i=0; i<codeCount; i++){
            //得到随机产生的验证码数字
            String code = String.valueOf(codeSequence[random.nextInt(36)]);
            // 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
            red = random.nextInt(255);
            green = random.nextInt(255);
            blue = random.nextInt(255);

            // 用随机产生的颜色将验证码绘制到图像中。
            graphics.setColor(new Color(red, green, blue));
            graphics.drawString(code,(i+1)*xx,codeY);
            randomCode.append(code);
        }
        Map<String,Object> map = new HashMap<>();
        //存放验证码(将验证码存放在session中方便用户登录时在后台验证验证码)
        HttpSession httpSession =  request.getSession();
        httpSession.setAttribute("randomCode",randomCode);
        //存放图片
        Random r = new Random();
        Integer randomNum =  r.nextInt(10000);
        String picName = System.currentTimeMillis()+randomNum +".jpg";
        String path = ResourceUtils.getURL("classpath:").getPath()+"/static/codeImage/"+ picName;
        File file = new File(ResourceUtils.getURL("classpath:").getPath()+"/static/codeImage/");
        if(!file.exists()){
            file.mkdirs();
        }
        OutputStream outputStream = new FileOutputStream(path);
        ImageIO.write( bufferedImage,"jpg",outputStream);
        //关闭流,如果不关闭的话,在验证码验证完成后,验证码图片会删除失败
        outputStream.close();
        map.put("picName",picName);
        map.put("randomNum",randomNum);
        return map;
    }

}
