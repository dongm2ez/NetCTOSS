package com.tarena.test;

import com.tarena.dao.CostDAO;
import com.tarena.entity.Cost;
import com.tarena.entity.page.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCostDAO {
    private ApplicationContext ctx;

    @Test
    public void testFindAll() {
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        List<Cost> list = dao.findAll();
        for (Cost c : list) {
            System.out.println(c.getCost_id() + " " + c.getName() + " "
                    + c.getDescr());
        }
    }

    @Test
    public void testSave() {
        // 创建Spring容器
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        Cost cost = new Cost();
        cost.setName("tarena");
        cost.setCost_id(7);
        cost.setBase_duration(90);
        cost.setBase_cost(90.0);
        cost.setUnit_cost(0.9);
        cost.setStatus("0");
        cost.setDescr("tarena套餐");
        cost.setCreatime(null);
        cost.setStartime(null);
        cost.setCost_type(1);
        dao.save(cost);
    }

    @Test
    public void testFindById() {
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        Cost cost = new Cost();
        cost = dao.findById(5);
        System.out.println(cost.getName());
    }

    @Test
    public void testUpdate() {
        // 创建Spring容器
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        Cost cost = new Cost();
        cost = dao.findById(100);
        cost.setName("5555");
        dao.update(cost);
    }

    @Test
    public void testDelete() {
        // 创建Spring容器
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        dao.deleteById(100);
    }

    @Test
    public void testFindrows() {
        // 创建Spring容器
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        System.out.println(dao.findRows());
    }

    @Test
    public void testFindPage() {
        // 创建Spring容器
        ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        // 通过容器创建CostDao实例
        CostDAO dao = ctx.getBean(CostDAO.class);
        Page page = new Page();

        List<Cost> costs = dao.findPage(page);
        for (Cost l : costs) {
            System.out.println(l.getCost_id() + "," + l.getName() + "," + l.getBase_cost());
        }
    }
}
