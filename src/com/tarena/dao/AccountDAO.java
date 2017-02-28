package com.tarena.dao;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Account;
import com.tarena.entity.page.AccountPage;

import java.util.List;

/**
 * Account表操作类
 *
 * @author Administrator
 */
@MyBatisDAO
public interface AccountDAO {
    /**
     * 分页查询帐务账号
     *
     * @param page
     * @return
     */
    List<Account> findByPage(AccountPage page);

    /**
     * 查询出满足搜索条件的总行数
     *
     * @param page
     * @return
     */
    int findRows(AccountPage page);

    /**
     * 将指定的帐务账号设置为暂停态
     *
     * @param id
     */
    void pause(int id);

    /**
     * 将指定帐务账号设置为开通状态
     *
     * @param id
     */
    void start(int id);

    /**
     * 新增帐务账号
     *
     * @param account
     */
    void save(Account account);

    /**
     * 根据id查询帐务账号
     *
     * @param id
     * @return
     */
    Account findById(int id);

    /**
     * 根据身份证号查询帐务账号
     *
     * @param idcard_no
     * @return
     */
    Account findByIdcard_no(String idcard_no);
}
