package com.cc.back.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 文章分类
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-12-13
 */
@TableName("article_class")
public class ArticleClass extends Model<ArticleClass> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 分类名称
     */
	@TableField("type_name")
	private String typeName;
    /**
     * 备注
     */
	private String remark;
    /**
     * 是否启用(1.启用  2.禁用)
     */
	@TableField("is_use")
	private Integer isUse;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private String  createDate;
	@TableField("create_by")
	private Integer createBy;
	@TableField("update_date")
	private String updateDate;
	@TableField("update_by")
	private Integer updateBy;

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

	public Integer getId() {
		return id;
	}

	public ArticleClass setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getTypeName() {
		return typeName;
	}

	public ArticleClass setTypeName(String typeName) {
		this.typeName = typeName;
		return this;
	}

	public String getRemark() {
		return remark;
	}

	public ArticleClass setRemark(String remark) {
		this.remark = remark;
		return this;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public ArticleClass setIsUse(Integer isUse) {
		this.isUse = isUse;
		return this;
	}

	public String  getCreateDate() {
		return createDate;
	}

	public ArticleClass setCreateDate(String  createDate) {
		this.createDate = createDate;
		return this;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public ArticleClass setCreateBy(Integer createBy) {
		this.createBy = createBy;
		return this;
	}

	public String  getUpdateDate() {
		return updateDate;
	}

	public ArticleClass setUpdateDate(String  updateDate) {
		this.updateDate = updateDate;
		return this;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public ArticleClass setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
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

    @Override
	public String toString() {
		return "ArticleClass{" +
			"id=" + id +
			", typeName=" + typeName +
			", remark=" + remark +
			", isUse=" + isUse +
			", createDate=" + createDate +
			", createBy=" + createBy +
			", updateDate=" + updateDate +
			", updateBy=" + updateBy +
			"}";
	}
}
