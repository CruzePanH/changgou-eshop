package com.changgou.goods.service.impl;

import com.changgou.goods.dao.MenuMapper;
import com.changgou.goods.pojo.Menu;
import com.changgou.goods.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:Menu业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    /**
     * Menu条件+分页查询
     * @param menu 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Menu> findPage(Menu menu, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(menu);
        //执行搜索
        return new PageInfo<Menu>(menuMapper.selectByExample(example));
    }

    /**
     * Menu分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Menu> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Menu>(menuMapper.selectAll());
    }

    /**
     * Menu条件查询
     * @param menu
     * @return
     */
    @Override
    public List<Menu> findList(Menu menu){
        //构建查询条件
        Example example = createExample(menu);
        //根据构建的条件查询数据
        return menuMapper.selectByExample(example);
    }


    /**
     * Menu构建查询对象
     * @param menu
     * @return
     */
    public Example createExample(Menu menu){
        Example example=new Example(Menu.class);
        Example.Criteria criteria = example.createCriteria();
        if(menu!=null){
            // 菜单ID
            if(!StringUtils.isEmpty(menu.getId())){
                    criteria.andEqualTo("id",menu.getId());
            }
            // 菜单名称
            if(!StringUtils.isEmpty(menu.getName())){
                    criteria.andLike("name","%"+menu.getName()+"%");
            }
            // 图标
            if(!StringUtils.isEmpty(menu.getIcon())){
                    criteria.andEqualTo("icon",menu.getIcon());
            }
            // URL
            if(!StringUtils.isEmpty(menu.getUrl())){
                    criteria.andEqualTo("url",menu.getUrl());
            }
            // 上级菜单ID
            if(!StringUtils.isEmpty(menu.getParentId())){
                    criteria.andEqualTo("parentId",menu.getParentId());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        menuMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Menu
     * @param menu
     */
    @Override
    public void update(Menu menu){
        menuMapper.updateByPrimaryKey(menu);
    }

    /**
     * 增加Menu
     * @param menu
     */
    @Override
    public void add(Menu menu){
        menuMapper.insert(menu);
    }

    /**
     * 根据ID查询Menu
     * @param id
     * @return
     */
    @Override
    public Menu findById(String id){
        return  menuMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Menu全部数据
     * @return
     */
    @Override
    public List<Menu> findAll() {
        return menuMapper.selectAll();
    }
}
