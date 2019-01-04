package com.sipingsoft.back.service.impl;

import com.sipingsoft.back.entity.Article;
import com.sipingsoft.back.entity.SysUser;
import com.sipingsoft.back.mapper.ArticleMapper;
import com.sipingsoft.back.service.ArticleService;
import com.sipingsoft.core.entity.PageResponse;
import com.sipingsoft.core.entity.ResponseMessage;
import com.sipingsoft.core.shiro.ShiroUtils;
import com.sipingsoft.core.util.OperationImageUtil;
import com.sipingsoft.core.util.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 * @author HeChunXiao
 * @since 2018-12-21 16:07
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Value("${preview-path}")
    private String previewPath;

    /**
     * 文章列表
     *
     * @param article
     * @param page
     * @param rows
     * @return
     */
    @Override
    public PageResponse<Article> findArticleList(Article article, Integer page, Integer rows, String sord) {
        Map<String, Object> map = new HashMap<>();
        map.put("article", article);
        map.put("pageStart", (page - 1) * rows);
        map.put("pageSize", rows);
        map.put("sord", sord);
        List<Article> list = articleMapper.findArticleList(map);
        Integer totalCount = articleMapper.findArticleListConut(map);
        return PageResponse.getPageResponse(list, totalCount, page, rows);
    }

    /**
     * 更新文章信息
     *
     * @param article
     * @return
     */
    @Override
    public ResponseMessage<Article> updateArticle(Article article) {
        SysUser sysUser = ShiroUtils.getLoginUser();
        article.setUpdateBy(sysUser.getUserId().intValue());
        Date date = new Date();
        article.setUpdateDate(SimpleDateFormatUtil.dateToString(date, "yyyy-MM-dd hh:mm:ss"));
        articleMapper.updateById(article);
        return new ResponseMessage<>(200, "更新操作成功");
    }

    /**
     * 根据文章id 查找文章信息
     *
     * @param id
     * @return
     */
    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.getArticleById(id);
    }

    @Override
    public ResponseMessage<Integer> insertArticle(MultipartFile file, Article article) {
        //id不为空时   保存
        //图片处理
        // 1.如果传入的图片不为空  则删除原来的图片 更新现在的图片
        //   (1.)文章id为空 则是新增文章,不删除图片直接添加
        //   (2.)文章id不为空,则是保存文章,删除原来的图片,更新图片
        // 2. 如果传入的图片为空  则不做任何处理
        if (file != null && file.getSize() != 0) {
            dealImage(article, file);
        }
        List<Integer> list = new ArrayList<>();
        if (article.getId() != null) {
            SysUser sysUser = ShiroUtils.getLoginUser();
            article.setUpdateBy(sysUser.getUserId().intValue());
            article.setUpdateDate(SimpleDateFormatUtil.dateToString(new Date(), "yyyy-MM-dd hh:mm:ss"));
            articleMapper.updateById(article);
            list.add(article.getId());
        } else {
            //id为空时   新加入
            //上架
            article.setIsUse(1);
            article.setIsDelete(1);
            article.setUpdateBy(article.getCreateBy());
            article.setUpdateDate(article.getCreateDate());
            articleMapper.insert(article);
            list.add(article.getId());
        }
        return new ResponseMessage<Integer>(200, "文章保存成功", list);
    }

    /**
     * 文章保存/更新时  缩略图片的处理
     * @param article
     * @param file
     */
    private void dealImage(Article article, MultipartFile file) {
        String oFileName = file.getOriginalFilename();
        assert oFileName != null;
        String fileNameSuffix = oFileName.substring(oFileName.lastIndexOf("."));
        Date date = new Date();
        /*String dir = SimpleDateFormatUtil.dateToString(date, "yyyy-MM-dd");*/
        //创建日期:获取缩略图所在文件夹
        String createDate = article.getCreateDate().substring(0, 10);
        String nFileName = date.getTime() + fileNameSuffix;
        String path = null;
        try {
            path = previewPath + createDate + "/" + nFileName;
            File file1 = new File(previewPath + createDate + "/");
            if (article.getPreviewName() != null) {
                //删除原来的图片
                String oldPath = previewPath + createDate + "/" + article.getPreviewName();
                System.out.println(oldPath);
                File oldFile = new File(oldPath);
                if (oldFile.exists()) {
                    boolean flag = oldFile.delete();
                }
            }
            if (!file1.exists()) {
                boolean flag = file1.mkdirs();
            }
            //保存图片
            OperationImageUtil.saveImage(file, path);
            article.setPreview(path);
            article.setPreviewName(nFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
