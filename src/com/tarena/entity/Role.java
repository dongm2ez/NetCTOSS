package com.tarena.entity;

import java.util.List;

/**
 * 角色管理实体类
 * @author Administrator
 *
 */
public class Role {
	private Integer role_id;
	private String name;
	/**
	 * 模块ID,用于保存时接收表单传入的一组模块ID值
	 */
	private List<Integer> moduleIds;
	/**
	 * 关联属性，用于封装对应的多个模块,查询时使用
	 */
	private List<Module> modules;
	
	public List<Integer> getModuleIds() {
		return moduleIds;
	}
	public void setModuleIds(List<Integer> moduleIds) {
		this.moduleIds = moduleIds;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
