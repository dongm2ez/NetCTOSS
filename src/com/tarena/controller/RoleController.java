package com.tarena.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tarena.dao.RoleDAO;
import com.tarena.entity.Module;
import com.tarena.entity.Role;
import com.tarena.entity.page.RolePage;
/**
 * 角色模块控制器
 * @author DongYuxiang(dongm2ez@163.com)
 * @date 2014年10月18日
 */
@Controller
@RequestMapping("/role")
@SessionAttributes("rolePage")
public class RoleController extends BaseController{
	@Resource
	private RoleDAO roleDAO;
	
	@RequestMapping("/findRole.do")
	public String find(RolePage page, Model model){
		//查询当前页的数据
		List<Role> list = roleDAO.findByPage(page);
		model.addAttribute("roles",list);
		//查询总行数
		page.setRows(roleDAO.findRows());
		model.addAttribute("rolePage",page);
		return "role/role_list";
	}
	
	@RequestMapping("/toAddRole.do")
	public String toAdd(Model model){
		//查询出全部模块，用于初始化模块checkbox
		List<Module> list = roleDAO.findAllMoudles();
		model.addAttribute("modules",list);
		return "role/add_role";
	}
	
	@RequestMapping("/addRole.do")
	public String add(Role role){
		//新增角色
		roleDAO.save(role);
		//新增角色模块中间表
		List<Integer> moduleIds = role.getModuleIds();
		if(moduleIds != null && moduleIds.size()>0){
			for(Integer moduleId:moduleIds){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("role_id", role.getRole_id());
				map.put("module_id", moduleId);
				roleDAO.saveRoleModule(map);
			}
		}
		return "redirect:findRole.do";
	}
	@RequestMapping("/toUpdateRole.do")
	public String toUpdate(int id, Model model){
		//根据id查出角色及其对应模块
		Role role = roleDAO.findById(id);
		model.addAttribute("role",role);
		//查询出全部模块，用于初始化模块checkbox
		List<Module> list = roleDAO.findAllMoudles();
		model.addAttribute("modules",list);
		return "role/update_role";
	}
	
	@RequestMapping("/updateRole.do")
	public String update(Role role){
		//修改角色
		roleDAO.update(role);
		//删除角色对应中间表数据
		roleDAO.deleteRoleModule(role.getRole_id());
		//重新插入角色对应中间表数据
		List<Integer> moduleIds = role.getModuleIds();
		if(moduleIds != null && moduleIds.size() > 0){
			for(Integer moduleId : moduleIds){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("role_id", role.getRole_id());
				map.put("module_id", moduleId);
				roleDAO.saveRoleModule(map);
			}
		}
		return "redirect:findRole.do";
	}
	
	@RequestMapping("/deleteRole.do")
	public String delete(int roleId){
		//删除角色表数据
		roleDAO.delete(roleId);
		//删除角色中间表数据
		roleDAO.deleteRoleModule(roleId);
		return "redirect:findRole.do";
	}
}
