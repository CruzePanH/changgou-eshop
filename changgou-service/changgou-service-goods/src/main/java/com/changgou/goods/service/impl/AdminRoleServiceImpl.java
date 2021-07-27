package com.changgou.goods.service.impl;

import com.changgou.goods.dao.AdminRoleMapper;
import com.changgou.goods.pojo.AdminRole;
import com.changgou.goods.service.AdminRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:AdminRole业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleMapper adminRoleMapper;


    /**
     * AdminRole条件+分页查询
     * @param adminRole 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<AdminRole> findPage(AdminRole adminRole, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(adminRole);
        //执行搜索
        return new PageInfo<AdminRole>(adminRoleMapper.selectByExample(example));
    }

    /**
     * AdminRole分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<AdminRole> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<AdminRole>(adminRoleMapper.selectAll());
    }

    /**
     * AdminRole条件查询
     * @param adminRole
     * @return
     */
    @Override
    public List<AdminRole> findList(AdminRole adminRole){
        //构建查询条件
        Example example = createExample(adminRole);
        //根据构建的条件查询数据
        return adminRoleMapper.selectByExample(example);
    }


    /**
     * AdminRole构建查询对象
     * @param adminRole
     * @return
     */
    public Example createExample(AdminRole adminRole){
        Example example=new Example(AdminRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(adminRole!=null){
            // 管理员ID
            if(!StringUtils.isEmpty(adminRole.getAdminId())){
                    criteria.andEqualTo("adminId",adminRole.getAdminId());
            }
            // 角色ID
            if(!StringUtils.isEmpty(adminRole.getRoleId())){
                    criteria.andEqualTo("roleId",adminRole.getRoleId());
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
        adminRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改AdminRole
     * @param adminRole
     */
    @Override
    public void update(AdminRole adminRole){
        adminRoleMapper.updateByPrimaryKey(adminRole);
    }

    /**
     * 增加AdminRole
     * @param adminRole
     */
    @Override
    public void add(AdminRole adminRole){
        adminRoleMapper.insert(adminRole);
    }

    /**
     * 根据ID查询AdminRole
     * @param id
     * @return
     */
    @Override
    public AdminRole findById(Integer id){
        return  adminRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询AdminRole全部数据
     * @return
     */
    @Override
    public List<AdminRole> findAll() {
        return adminRoleMapper.selectAll();
    }
}
