package com.tarena.test;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.ServiceDAO;
import com.tarena.entity.page.ServicePage;

public class TestServiceDAO {
	@Test
	public void testFindByPage() {
		//´´½¨SpringÈÝÆ÷
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(
					"applicationContext.xml");
		ServiceDAO dao = ctx.getBean(ServiceDAO.class);
		ServicePage page = new ServicePage();
		List<Map<String, Object>> list = 
			dao.findByPage(page);
		for(Map<String, Object> map : list) {
			System.out.println(
				map.get("SERVICE_ID") + " " +
				map.get("OS_USERNAME") + " " +
				map.get("UNIX_HOST") + " " +
				map.get("IDCARD_NO") + " " +
				map.get("NAME")
			);
		}
	}								
}
