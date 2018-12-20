package com.sipingsoft.back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-08-24
 */
@TableName("sys_user")
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

	@TableId(value="user_id", type= IdType.AUTO)
	private Long userId;
	private String username;
	private String password;
    /**
     * 0.禁用 1.正常
     */
	private Integer status;
	@TableField("create_date")
	private Date createDate;

    /**
     * 是否是超级管理员
     * 1.是 2.不是
     */
	@TableField("is_admin")
	private  Integer isAdmin;

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Long getUserId() {
		return userId;
	}

	public SysUser setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public SysUser setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public SysUser setPassword(String password) {
		this.password = password;
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public SysUser setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public SysUser setCreateDate(Date createDate) {
		this.createDate = createDate;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.userId;
	}

	@Override
	public String toString() {
		return "SysUser{" +
			"userId=" + userId +
			", username=" + username +
			", password=" + password +
			", status=" + status +
			", createDate=" + createDate +
			"}";
	}
}
