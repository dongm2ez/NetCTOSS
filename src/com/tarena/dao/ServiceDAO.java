package com.tarena.dao;


import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Service;
import com.tarena.entity.page.ServicePage;

import java.util.List;
import java.util.Map;

@MyBatisDAO
public interface ServiceDAO {
    /**
     * 分页查询业务账号
     *
     * @return
     */
    List<Map<String, Object>> findByPage(ServicePage page);

    /**
     * 查询出满足条件的总行数
     *
     * @return
     */
    int findRows(ServicePage page);

    /**
     * 开通
     */
    void start(int id);

    /**
     * 根据id查找业务账号
     *
     * @param id
     * @return
     */
    Service findById(int id);

    /**
     * 添加新业务账号
     *
     * @param service
     */
    void save(Service service);


}
