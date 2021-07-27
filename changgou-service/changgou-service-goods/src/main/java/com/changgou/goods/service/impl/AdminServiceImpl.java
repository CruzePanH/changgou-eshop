package com.changgou.goods.service.impl;

import com.changgou.goods.dao.AdminMapper;
import com.changgou.goods.pojo.Admin;
import com.changgou.goods.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Admin业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;


    /**
     * Admin条件+分页查询
     * @param admin 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Admin> findPage(Admin admin, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(admin);
        //执行搜索
        return new PageInfo<Admin>(adminMapper.selectByExample(example));
    }

    /**
     * Admin分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Admin> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Admin>(adminMapper.selectAll());
    }

    /**
     * Admin条件查询
     * @param admin
     * @return
     */
    @Override
    public List<Admin> findList(Admin admin){
        //构建查询条件
        Example example = createExample(admin);
        //根据构建的条件查询数据
        return adminMapper.selectByExample(example);
    }


    /**
     * Admin构建查询对象
     * @param admin
     * @return
     */
    public Example createExample(Admin admin){
        Example example=new Example(Admin.class);
        Example.Criteria criteria = example.createCriteria();
        if(admin!=null){
            // 
            if(!StringUtils.isEmpty(admin.getId())){
                    criteria.andEqualTo("id",admin.getId());
            }
            // 用户名
            if(!StringUtils.isEmpty(admin.getLoginName())){
                    criteria.andEqualTo("loginName",admin.getLoginName());
            }
            // 密码
            if(!StringUtils.isEmpty(admin.getPassword())){
                    criteria.andEqualTo("password",admin.getPassword());
            }
            // 状态
            if(!StringUtils.isEmpty(admin.getStatus())){
                    criteria.andEqualTo("status",admin.getStatus());
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
        adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Admin
     * @param admin
     */
    @Override
    public void update(Admin admin){
        adminMapper.updateByPrimaryKey(admin);
    }

    /**
     * 增加Admin
     * @param admin
     */
    @Override
    public void add(Admin admin){
        adminMapper.insert(admin);
    }

    /**
     * 根据ID查询Admin
     * @param id
     * @return
     */
    @Override
    public Admin findById(Integer id){
        return  adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Admin全部数据
     * @return
     */
    @Override
    public List<Admin> findAll() {
        return adminMapper.selectAll();
    }
}
