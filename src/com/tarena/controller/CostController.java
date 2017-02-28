package com.tarena.controller;

import com.tarena.dao.CostDAO;
import com.tarena.entity.Cost;
import com.tarena.entity.page.CostPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * 资费模块控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/cost")
@SessionAttributes("costPage")
public class CostController extends BaseController {
    @Resource
    private CostDAO costDAO;

//	@RequestMapping("/findCost.do")
//	public String find(Model model) {
//		//调用DAO查询全部的资费数据
//		List<Cost> list = costDAO.findAll();
//		//将数据传递给JSP页面
//		model.addAttribute("costs", list);
//		//匹配JSP
//		return "cost/cost_list";
//	}

    @RequestMapping("/findCost.do")
    public String execute(CostPage costPage, Model model) {
        //查询总行数，用来计算总页数
        int rows = costDAO.findRows();
        costPage.setRows(rows);
        //调用DAO查询某一页的资费数据
        List<Cost> list = costDAO.findPage(costPage);
        //绑定数据
        model.addAttribute("costPage", costPage);
        model.addAttribute("costs", list);
        //匹配JSP
        return "cost/cost_list";
    }

    @RequestMapping("/toAddCost.do")
    public String toAdd() {
        //直接转发到新增页面
        return "cost/add_cost";
    }

    @RequestMapping("/addCost.do")
    public String add(Cost cost) {
        //设置默认值
        cost.setStatus("1");
        cost.setCreatime(new Timestamp(System.currentTimeMillis()));
        //新增数据
        costDAO.save(cost);
        //重定向到查询
        return "redirect:findCost.do";
    }

    @RequestMapping("/toUpdateCost.do")
    public String toUpdate(int id, Model model) {
        Cost cost = costDAO.findById(id);
        model.addAttribute("cost", cost);
        //转发修改页面
        return "cost/update_cost";
    }

    @RequestMapping("/updateCost.do")
    public String update(Cost cost) {
        costDAO.update(cost);
        return "redirect:findCost.do";
    }

    @RequestMapping("/deleteCost.do")
    public String delete(@RequestParam("id") int id) {
        costDAO.deleteById(id);
        return "redirect:findCost.do";
    }


}
