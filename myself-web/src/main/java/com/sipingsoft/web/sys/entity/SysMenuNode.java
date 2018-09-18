package com.sipingsoft.web.sys.entity;

import java.util.List;

public class SysMenuNode {

	private Integer menuId;
	private String name;
	private Integer parentId;
	private String url;
	private String icon;
	private String ParentMenuName;
	private String header;
	private List<SysMenuNode> nodes;
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getParentMenuName() {
		return ParentMenuName;
	}
	public void setParentMenuName(String parentMenuName) {
		ParentMenuName = parentMenuName;
	}
	public List<SysMenuNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<SysMenuNode> nodes) {
		this.nodes = nodes;
	}
	@Override
	public String toString() {
		return "SysMenuNode [menuId=" + menuId + ", name=" + name + ", parentId=" + parentId + ", url=" + url
				+ ", icon=" + icon + ", ParentMenuName=" + ParentMenuName + ", header=" + header + ", nodes=" + nodes
				+ "]";
	}
	
}
