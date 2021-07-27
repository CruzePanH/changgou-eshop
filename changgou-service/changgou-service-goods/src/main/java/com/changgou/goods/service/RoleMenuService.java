package com.changgou.goods.service;

import com.changgou.goods.pojo.RoleMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:RoleMenu业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface RoleMenuService {

    /***
     * RoleMenu多条件分页查询
     * @param roleMenu
     * @param page
     * @param size
     * @return
     */
    PageInfo<RoleMenu> findPage(RoleMenu roleMenu, int page, int size);

    /***
     * RoleMenu分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<RoleMenu> findPage(int page, int size);

    /***
     * RoleMenu多条件搜索方法
     * @param roleMenu
     * @return
     */
    List<RoleMenu> findList(RoleMenu roleMenu);

    /***
     * 删除RoleMenu
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改RoleMenu数据
     * @param roleMenu
     */
    void update(RoleMenu roleMenu);

    /***
     * 新增RoleMenu
     * @param roleMenu
     */
    void add(RoleMenu roleMenu);

    /**
     * 根据ID查询RoleMenu
     * @param id
     * @return
     */
     RoleMenu findById(Integer id);

    /***
     * 查询所有RoleMenu
     * @return
     */
    List<RoleMenu> findAll();
}
