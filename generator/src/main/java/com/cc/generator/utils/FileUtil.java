package com.cc.generator.utils;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author He Chunxiao
 * @date 2019-02-26 9:09
 * @desc
 */
public class FileUtil {

    /**
     * @param type     使用模板类型
     * @param data     填充数据
     * @param filePath 输出文件
     * @throws IOException
     * @throws TemplateException
     */
    public static String generateToJava(int type, Object data, String filePath, String path) throws IOException, TemplateException {
        File fileP = new File(path);
        if (!fileP.exists()) {
            boolean mkdirs = fileP.mkdirs();
        }
        Template tpl = getTemplate(type); // 获取模板文件
        // 填充数据
        StringWriter writer = new StringWriter();
        tpl.process(data, writer);
        writer.flush();
        // 写入文件
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        BufferedWriter bw = new BufferedWriter(osw, 1024);
        tpl.process(data, bw);
        fos.close();
        return null;
    }

    /**
     * 获取模板
     *
     * @param type 模板类型
     * @return
     * @throws IOException
     */
    private static Template getTemplate(int type) throws IOException {
        switch (type) {
            case FreemarketConfigUtils.TYPE_ENTITY:
                return FreemarketConfigUtils.getInstance().getTemplate("Entity.ftl");
            case FreemarketConfigUtils.TYPE_DAO:
                return FreemarketConfigUtils.getInstance().getTemplate("Dao.ftl");
            case FreemarketConfigUtils.TYPE_SERVICEIMPL:
                return FreemarketConfigUtils.getInstance().getTemplate("ServiceImpl.ftl");
            case FreemarketConfigUtils.TYPE_CONTROLLER:
                return FreemarketConfigUtils.getInstance().getTemplate("Controller.ftl");
            case FreemarketConfigUtils.TYPE_MAPPER:
                return FreemarketConfigUtils.getInstance().getTemplate("Mapper.ftl");
            case FreemarketConfigUtils.TYPE_SERVICE:
                return FreemarketConfigUtils.getInstance().getTemplate("Service.ftl");
            case FreemarketConfigUtils.TYPE_VIEW:
                return FreemarketConfigUtils.getInstance().getTemplate("View.ftl");
            case FreemarketConfigUtils.TYPE_ENTITY_CUSTOM:
                return FreemarketConfigUtils.getInstance().getTemplate("EntityCustom.ftl");
            default:
                return null;
        }
    }

    private static String getBasicProjectPath() {
        String path = new File(FileUtil.class.getClassLoader().getResource("").getFile()).getPath() + File.separator;
        StringBuilder sb = new StringBuilder();
        sb.append(path, 0, path.indexOf("target")).append("src").append(File.separator).append("main").append(File.separator);
        return sb.toString();
    }


    /**
     * ZIP下载
     * @param response
     */
    public static void downLoadZip(HttpServletResponse response,String  downloadPath,String fileName) throws IOException {
            File file = new File(downloadPath);
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + new String(fileName.getBytes("ISO8859-1"), "UTF-8"));
            response.setContentLength((int) file.length());
            // 定义输出类型
            response.setContentType("application/zip");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream buff = new BufferedInputStream(fis);
            // 相当于我们的缓存
            byte[] b = new byte[1024];
            // 该值用于计算当前实际下载了多少字节
            long k = 0;
            // 从response对象中得到输出流,准备下载
            OutputStream myout = response.getOutputStream();
            // 开始循环下载
            while (k < file.length()) {
                int j = buff.read(b, 0, 1024);
                k += j;
                myout.write(b, 0, j);
            }
            myout.flush();
            buff.close();
            file.delete();
    }


    /**
     * 压缩文件
     * @param srcFilePath  压缩路径
     * @param destFilePath 存放zip的路径
     */
    public static void compress(String srcFilePath, String destFilePath) throws IOException {
        File src = new File(srcFilePath);
        if (!src.exists()) {
            throw new RuntimeException(srcFilePath + "不存在");
        }
        File zipFile = new File(destFilePath);
        FileOutputStream fos = new FileOutputStream(zipFile);
        ZipOutputStream zos = new ZipOutputStream(fos);
        String baseDir = "";
        compressbyType(src, zos, baseDir);
        zos.close();

    }

    /**
     * 按照原路径的类型就行压缩。文件路径直接把文件压缩，
     *
     * @param src
     * @param zos
     * @param baseDir
     */
    private static void compressbyType(File src, ZipOutputStream zos, String baseDir) throws IOException {
        if (!src.exists()) {
            return;
        }
        //判断文件是否是文件，如果是文件调用compressFile方法,如果是路径，则调用compressDir方法；
        if (src.isFile()) {
            //src是文件，调用此方法
            compressFile(src, zos, baseDir);
        } else if (src.isDirectory()) {
            //src是文件夹，调用此方法
            compressDir(src, zos, baseDir);
        }

    }

    /**
     * 压缩文件
     */
    private static void compressFile(File file, ZipOutputStream zos, String baseDir) throws IOException {
        if (!file.exists()) {
            return;
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        ZipEntry entry = new ZipEntry(baseDir + file.getName());
        zos.putNextEntry(entry);
        int count;
        byte[] buf = new byte[1024];
        while ((count = bis.read(buf)) != -1) {
            zos.write(buf, 0, count);
        }
        bis.close();
    }

    /**
     * 压缩文件夹
     */
    private static void compressDir(File dir, ZipOutputStream zos, String baseDir) throws IOException {
        if (!dir.exists()) {
            return;
        }
        File[] files = dir.listFiles();
        if (files.length == 0) {
            zos.putNextEntry(new ZipEntry(baseDir + dir.getName() + File.separator));
        }
        for (File file : files) {
            compressbyType(file, zos, baseDir + dir.getName() + File.separator);
        }
    }

}
