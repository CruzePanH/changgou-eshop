package com.changgou.goods.service;

import com.changgou.goods.pojo.AdminRole;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:AdminRole业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface AdminRoleService {

    /***
     * AdminRole多条件分页查询
     * @param adminRole
     * @param page
     * @param size
     * @return
     */
    PageInfo<AdminRole> findPage(AdminRole adminRole, int page, int size);

    /***
     * AdminRole分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<AdminRole> findPage(int page, int size);

    /***
     * AdminRole多条件搜索方法
     * @param adminRole
     * @return
     */
    List<AdminRole> findList(AdminRole adminRole);

    /***
     * 删除AdminRole
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改AdminRole数据
     * @param adminRole
     */
    void update(AdminRole adminRole);

    /***
     * 新增AdminRole
     * @param adminRole
     */
    void add(AdminRole adminRole);

    /**
     * 根据ID查询AdminRole
     * @param id
     * @return
     */
     AdminRole findById(Integer id);

    /***
     * 查询所有AdminRole
     * @return
     */
    List<AdminRole> findAll();
}
