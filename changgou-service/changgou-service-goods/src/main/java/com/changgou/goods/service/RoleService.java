package com.changgou.goods.service;

import com.changgou.goods.pojo.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Role业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RoleService {

    /***
     * Role多条件分页查询
     * @param role
     * @param page
     * @param size
     * @return
     */
    PageInfo<Role> findPage(Role role, int page, int size);

    /***
     * Role分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Role> findPage(int page, int size);

    /***
     * Role多条件搜索方法
     * @param role
     * @return
     */
    List<Role> findList(Role role);

    /***
     * 删除Role
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Role数据
     * @param role
     */
    void update(Role role);

    /***
     * 新增Role
     * @param role
     */
    void add(Role role);

    /**
     * 根据ID查询Role
     * @param id
     * @return
     */
     Role findById(Integer id);

    /***
     * 查询所有Role
     * @return
     */
    List<Role> findAll();
}
