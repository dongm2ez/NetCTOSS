package com.tarena.controller;

import com.tarena.dao.AccountDAO;
import com.tarena.dao.CostDAO;
import com.tarena.dao.ServiceDAO;
import com.tarena.entity.Account;
import com.tarena.entity.Cost;
import com.tarena.entity.Service;
import com.tarena.entity.page.ServicePage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/service")
@SessionAttributes("servicePage")
public class SerivceController extends BaseController {
    @Resource
    private ServiceDAO serviceDAO;
    @Resource
    private AccountDAO accountDAO;
    @Resource
    private CostDAO costDAO;

    @RequestMapping("/findService.do")
    public String find(ServicePage page, Model model) {
        //查询出当前页数据
        List<Map<String, Object>> list =
                serviceDAO.findByPage(page);
        model.addAttribute("services", list);
        //查询总行数
        page.setRows(serviceDAO.findRows(page));
        model.addAttribute("servicePage", page);
        return "service/service_list";
    }

    @RequestMapping("/startService.do")
    @ResponseBody
    public Map<String, Object> updateStart(int id) {
        Map<String, Object> result =
                new HashMap<String, Object>();
        //判断账务账号是否开通
        Service service = serviceDAO.findById(id);
        Account account =
                accountDAO.findById(service.getAccount_id());
        if (account.getStatus().equals("0")) {
            //开通账务账号，允许开通当前业务账号
            serviceDAO.start(id);
            result.put("success", true);
            result.put("message", "开通成功.");
            //{"success":true,"message":"开通成功."}
        } else {
            //没有开通账务账号，不允许开通当前业务账号
            result.put("success", false);
            result.put("message", "账务账号未开通，不能开通此业务账号.");
        }
        return result;
    }

    @RequestMapping("/toAddService.do")
    public String toAdd(Model model) {
        //查询出相关的资费数据，用来初始化下拉选
        List<Cost> list = costDAO.findAll();
        model.addAttribute("costs", list);
        return "service/add_service";
    }

    @RequestMapping("/addService.do")
    public String add(Service service) {
        //设置默认值
        service.setStatus("0");
        service.setCreate_date((new Timestamp(System.currentTimeMillis())));
        serviceDAO.save(service);
        return "redirect:findService.do";
    }

    @RequestMapping("/searchAccount.do")
    @ResponseBody
    public Account searchAccount(String idcard_no) {
        //{"account_id":1,"real_name":"张三",...}
        return accountDAO.findByIdcard_no(idcard_no);
    }
}
