package com.tarena.controller;

import com.tarena.dao.AccountDAO;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * 帐务账号模块控制器
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/account")
@SessionAttributes("accountPage")
public class AccountController extends BaseController {
    @Resource
    private AccountDAO accountDAO;

    /**
     * Spring创建page对象的规则
     * 1.查看session中是否有page对象，若存在直接使用对象
     * 2.若session中不存在这个对象则new新对象
     * 3.从请求中获取参数，设置给对象
     * <p>
     * 注意：
     * 访问该方法时，Spring会首先尝试从session中
     * 取该对象的值，取值规则如下：
     * session.getAttribute("accountPage");
     * 即Spring会以参数类型（首字母小写）为key从
     * session中取值，那么为了保证能够取到这个值，
     * 我们向session放数据时，名称应该是其类名（首字母小写）。
     *
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("/findAccount.do")
    public String find(AccountPage page, Model model) {
        //查询出当前页的数据，传递给页面
        List<Account> list = accountDAO.findByPage(page);
        model.addAttribute("accounts", list);
        //查询出总行数，设置到page中，将page传递给页面
        page.setRows(accountDAO.findRows(page));
        //默认情况下，Spring会将数据放入request传到页面
        //当通过注解@SessionAttributes声明某数据时,Spring就会使用session向页面传递数据
        model.addAttribute("accountPage", page);
        return "account/account_list";
    }

    @RequestMapping("/pauseAccount.do")
    public String updatePause(int id) {
        accountDAO.pause(id);
        return "redirect:findAccount.do";
    }

    @RequestMapping("/startAccount.do")
    public String updateStart(int id) {
        accountDAO.start(id);
        return "redirect:findAccount.do";
    }

    @RequestMapping("/toAddAccount.do")
    public String toAdd() {
        return "account/add_account";
    }

    @RequestMapping("/addAccount.do")
    public String add(Account account) {
        //设置默认值
        account.setStatus("1");
        account.setCreate_date(new Timestamp(System.currentTimeMillis()));
        accountDAO.save(account);
        return "redirect:findAccount.do";
    }
}
