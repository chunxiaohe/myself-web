package com.sipingsoft.back.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author He Chunxiao
 * @since 2018-08-24
 */
@TableName("sys_menu")
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

	@TableId(value="menu_id", type= IdType.AUTO)
	private Integer menuId;
    /**
     * 父id
     */
	@TableField("parent_id")
	private Integer parentId;
    /**
     * 菜单名称
     */
	private String name;
	/**
	 * 父菜单名字
	 */
	@TableField(exist=false)
	private String parentMenuName;
	
    /**
     * 菜单url
     */
	private String url;
	private String perms;
    /**
     * 类型:0.目录1.菜单
     */
	private Integer type;
    /**
     * 排序
     */
	@TableField("order_num")
	private Integer orderNum;
	
	private String icon;
	private String header;
	

	public String getParentMenuName() {
		return parentMenuName;
	}

	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public SysMenu setMenuId(Integer menuId) {
		this.menuId = menuId;
		return this;
	}

	public Integer getParentId() {
		return parentId;
	}

	public SysMenu setParentId(Integer parentId) {
		this.parentId = parentId;
		return this;
	}

	public String getName() {
		return name;
	}

	public SysMenu setName(String name) {
		this.name = name;
		return this;
	}

	public String getUrl() {
		return url;
	}

	public SysMenu setUrl(String url) {
		this.url = url;
		return this;
	}

	public String getPerms() {
		return perms;
	}

	public SysMenu setPerms(String perms) {
		this.perms = perms;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public SysMenu setType(Integer type) {
		this.type = type;
		return this;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public SysMenu setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.menuId;
	}

	@Override
	public String toString() {
		return "SysMenu [menuId=" + menuId + ", parentId=" + parentId + ", name=" + name + ", parentMenuName=" + parentMenuName
				+ ", url=" + url + ", perms=" + perms + ", type=" + type + ", orderNum=" + orderNum + ", icon=" + icon
				+ ", header=" + header + "]";
	}
}
