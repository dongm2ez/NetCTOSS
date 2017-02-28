package com.tarena.dao;

import com.tarena.annotation.MyBatisDAO;
import com.tarena.entity.Module;
import com.tarena.entity.Role;
import com.tarena.entity.page.RolePage;

import java.util.List;
import java.util.Map;

/**
 * Role表操作类
 *
 * @author Administrator
 */
@MyBatisDAO
public interface RoleDAO {
    /**
     * 分页查询角色信息
     *
     * @return
     */
    List<Role> findByPage(RolePage page);

    /**
     * 查询角色总行数
     *
     * @return
     */
    int findRows();

    /**
     * 查询全部模块数据
     *
     * @return
     */
    List<Module> findAllMoudles();

    /**
     * 保存角色数据
     *
     * @param module
     */
    void save(Role role);

    /**
     * 保存角色模块中间表数据
     * 一条中间表数据，其中key是字段名，值是字段值
     *
     * @param map
     */
    void saveRoleModule(Map<String, Object> map);

    /**
     * 根据id查找角色数据
     *
     * @param id
     * @return
     * @author DongYuxiang(dongm2ez@163.com)
     * @date 2014年10月17日
     */
    Role findById(int id);

    /**
     * 更新角色数据
     *
     * @param role
     * @author DongYuxiang(dongm2ez@163.com)
     * @date 2014年10月17日
     */
    void update(Role role);

    /**
     * 根据id删除角色中间表数据
     *
     * @param id
     * @author DongYuxiang(dongm2ez@163.com)
     * @date 2014年10月18日
     */
    void deleteRoleModule(int roleId);

    /**
     * 根据id删除角色数据
     *
     * @param id
     * @author DongYuxiang(dongm2ez@163.com)
     * @date 2014年10月18日
     */
    void delete(int roleId);

}
