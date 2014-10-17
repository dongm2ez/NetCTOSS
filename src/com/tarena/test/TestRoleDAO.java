package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.RoleDAO;
import com.tarena.entity.Module;
import com.tarena.entity.Role;
import com.tarena.entity.page.RolePage;

public class TestRoleDAO {
	
	@Test
	public void testFindByPage(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RoleDAO dao = ctx.getBean(RoleDAO.class);
		RolePage page = new RolePage();
		List<Role> list = dao.findByPage(page);
		
		for(Role r : list) {
			System.out.println(
					r.getRole_id() + " " + r.getName());
			List<Module> modules = r.getModules();
			for(Module m : modules) {
				System.out.println(
						m.getModule_id() + " " + m.getName());
			}
			System.out.println("---------------------");
		}
	}

}
