package com.changgou.goods.service.impl;

import com.changgou.goods.dao.RoleMenuMapper;
import com.changgou.goods.pojo.RoleMenu;
import com.changgou.goods.service.RoleMenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:RoleMenu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    /**
     * RoleMenu条件+分页查询
     * @param roleMenu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<RoleMenu> findPage(RoleMenu roleMenu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(roleMenu);
        //执行搜索
        return new PageInfo<RoleMenu>(roleMenuMapper.selectByExample(example));
    }

    /**
     * RoleMenu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<RoleMenu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<RoleMenu>(roleMenuMapper.selectAll());
    }

    /**
     * RoleMenu条件查询
     * @param roleMenu
     * @return
     */
    @Override
    public List<RoleMenu> findList(RoleMenu roleMenu){
        //构建查询条件
        Example example = createExample(roleMenu);
        //根据构建的条件查询数据
        return roleMenuMapper.selectByExample(example);
    }


    /**
     * RoleMenu构建查询对象
     * @param roleMenu
     * @return
     */
    public Example createExample(RoleMenu roleMenu){
        Example example=new Example(RoleMenu.class);
        Example.Criteria criteria = example.createCriteria();
        if(roleMenu!=null){
            // 
            if(!StringUtils.isEmpty(roleMenu.getRoleId())){
                    criteria.andEqualTo("roleId",roleMenu.getRoleId());
            }
            // 
            if(!StringUtils.isEmpty(roleMenu.getMenuId())){
                    criteria.andEqualTo("menuId",roleMenu.getMenuId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        roleMenuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改RoleMenu
     * @param roleMenu
     */
    @Override
    public void update(RoleMenu roleMenu){
        roleMenuMapper.updateByPrimaryKey(roleMenu);
    }

    /**
     * 增加RoleMenu
     * @param roleMenu
     */
    @Override
    public void add(RoleMenu roleMenu){
        roleMenuMapper.insert(roleMenu);
    }

    /**
     * 根据ID查询RoleMenu
     * @param id
     * @return
     */
    @Override
    public RoleMenu findById(Integer id){
        return  roleMenuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询RoleMenu全部数据
     * @return
     */
    @Override
    public List<RoleMenu> findAll() {
        return roleMenuMapper.selectAll();
    }
}
