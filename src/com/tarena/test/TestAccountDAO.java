package com.tarena.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tarena.dao.AccountDAO;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;


public class TestAccountDAO {
	private ApplicationContext ctx;
	@Test
	public void testFindByPage(){				
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDAO dao = ctx.getBean(AccountDAO.class);
		AccountPage page = new AccountPage();
		List<Account> list = dao.findByPage(page);
		for(Account l:list){
			System.out.println(
					l.getAccount_id()+" "+
					l.getIdcard_no()+" "+
					l.getStatus()		
					);
		}
	}
	
	@Test
	public void testAdd(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountDAO dao = ctx.getBean(AccountDAO.class);
		Account account = new Account();
		account.setLogin_name(" ");
		account.setLogin_passwd(" ");
		account.setReal_name(" ");
		account.setIdcard_no(" ");
		account.setTelephone(" ");
		dao.save(account);
	}
}
