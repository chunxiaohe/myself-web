package com.sipingsoft.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sipingsoft.core.util.FormatDateUtil;

import java.io.Serializable;

@TableName(value = "article")
public class Article implements Serializable {
     @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 文章分类id
     */
    @TableField(value = "article_class_id")
    private Integer articleClassId;

    /**
     * 标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 关键字
     */
    @TableField(value = "keyword")
    private String keyword;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 点击量
     */
    @TableField(value = "click")
    private Integer click;

    /**
     * 是否上架(1.上架  2.下架)
     */
    @TableField(value = "is_use")
    private Integer isUse;

    @TableField(value = "create_date")
    private String createDate;

    @TableField(value = "create_by")
    private Integer createBy;

    @TableField(value = "update_date")
    private String updateDate;

    @TableField(value = "update_by")
    private Integer updateBy;

    /**
     * 预览图地址
     */
    @TableField(value = "preview")
    private String preview;

    /**
     * 预览图名字
     */
    @TableField(value = "preview_name")
    private String previewName;

    /**
     * 1.未删除 2.已删除
     */
    @TableField(value = "is_delete")
    private Integer isDelete;

    /**
     * 创建人姓名
     */
    @TableField(exist = false)
    private String createName;

    /**
     * 更新人姓名
     */
    @TableField(exist = false)
    private String updateName;

    @TableField(exist = false)
    private ArticleClass articleClass;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取文章分类id
     *
     * @return atricle_class_id - 文章分类id
     */
    public Integer getArticleClassId() {
        return articleClassId;
    }

    /**
     * 设置文章分类id
     *
     * @param articleClassId 文章分类id
     */
    public void setArticleClassId(Integer articleClassId) {
        this.articleClassId = articleClassId;
    }

    /**
     * 获取标题
     *
     * @return title - 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取关键字
     *
     * @return keyword - 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置关键字
     *
     * @param keyword 关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取点击量
     *
     * @return click - 点击量
     */
    public Integer getClick() {
        return click;
    }

    /**
     * 设置点击量
     *
     * @param click 点击量
     */
    public void setClick(Integer click) {
        this.click = click;
    }

    /**
     * 获取是否上架(1.上架  2.下架)
     *
     * @return is_use - 是否上架(1.上架  2.下架)
     */
    public Integer getIsUse() {
        return isUse;
    }

    /**
     * 设置是否上架(1.上架  2.下架)
     *
     * @param isUse 是否上架(1.上架  2.下架)
     */
    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    /**
     * @return create_date
     */
    @JsonSerialize(using = FormatDateUtil.class)
    public String getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * @return create_by
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * @return update_date
     */
    @JsonSerialize(using = FormatDateUtil.class)
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * @param updateDate
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * @return update_by
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * @param updateBy
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取1.未删除 2.已删除
     *
     * @return delete - 1.未删除 2.已删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置1.未删除 2.已删除
     *
     * @param isDelete 1.未删除 2.已删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public ArticleClass getArticleClass() {
        return articleClass;
    }

    public void setArticleClass(ArticleClass articleClass) {
        this.articleClass = articleClass;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getPreviewName() {
        return previewName;
    }

    public void setPreviewName(String previewName) {
        this.previewName = previewName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleClassId=").append(articleClassId);
        sb.append(", title=").append(title);
        sb.append(", keyword=").append(keyword);
        sb.append(", content=").append(content);
        sb.append(", click=").append(click);
        sb.append(", isUse=").append(isUse);
        sb.append(", createDate=").append(createDate);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}