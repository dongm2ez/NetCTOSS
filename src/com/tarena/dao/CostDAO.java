package com.tarena.dao;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Cost;
import com.tarena.entity.page.Page;

import java.util.List;

/**
 * cost表操作类
 *
 * @author Administrator
 */
@MyBatisDAO
public interface CostDAO {
    /**
     * 查询所有资费数据
     *
     * @return
     */
    List<Cost> findAll();

    /**
     * 新增一条资费数据
     *
     * @param cost
     */
    void save(Cost cost);

    /**
     * 根据ID查询资费数据
     *
     * @param id
     * @return
     */
    Cost findById(int id);

    /**
     * 更新资费数据
     *
     * @param cost
     */
    void update(Cost cost);

    /**
     * 删除资费数据
     *
     * @param id
     */
    void deleteById(int id);

    /**
     * 获得分页数据
     *
     * @param page
     * @return
     */
    List<Cost> findPage(Page page);

    /**
     * 获得数据总条数
     *
     * @return
     */
    int findRows();
}

