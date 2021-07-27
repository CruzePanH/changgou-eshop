package com.changgou.goods.service.impl;

import com.changgou.goods.dao.FreightTemplateMapper;
import com.changgou.goods.pojo.FreightTemplate;
import com.changgou.goods.service.FreightTemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:FreightTemplate业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class FreightTemplateServiceImpl implements FreightTemplateService {

    @Autowired
    private FreightTemplateMapper freightTemplateMapper;


    /**
     * FreightTemplate条件+分页查询
     * @param freightTemplate 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<FreightTemplate> findPage(FreightTemplate freightTemplate, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(freightTemplate);
        //执行搜索
        return new PageInfo<FreightTemplate>(freightTemplateMapper.selectByExample(example));
    }

    /**
     * FreightTemplate分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<FreightTemplate> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<FreightTemplate>(freightTemplateMapper.selectAll());
    }

    /**
     * FreightTemplate条件查询
     * @param freightTemplate
     * @return
     */
    @Override
    public List<FreightTemplate> findList(FreightTemplate freightTemplate){
        //构建查询条件
        Example example = createExample(freightTemplate);
        //根据构建的条件查询数据
        return freightTemplateMapper.selectByExample(example);
    }


    /**
     * FreightTemplate构建查询对象
     * @param freightTemplate
     * @return
     */
    public Example createExample(FreightTemplate freightTemplate){
        Example example=new Example(FreightTemplate.class);
        Example.Criteria criteria = example.createCriteria();
        if(freightTemplate!=null){
            // ID
            if(!StringUtils.isEmpty(freightTemplate.getId())){
                    criteria.andEqualTo("id",freightTemplate.getId());
            }
            // 模板名称
            if(!StringUtils.isEmpty(freightTemplate.getName())){
                    criteria.andLike("name","%"+freightTemplate.getName()+"%");
            }
            // 计费方式
            if(!StringUtils.isEmpty(freightTemplate.getType())){
                    criteria.andEqualTo("type",freightTemplate.getType());
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
        freightTemplateMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改FreightTemplate
     * @param freightTemplate
     */
    @Override
    public void update(FreightTemplate freightTemplate){
        freightTemplateMapper.updateByPrimaryKey(freightTemplate);
    }

    /**
     * 增加FreightTemplate
     * @param freightTemplate
     */
    @Override
    public void add(FreightTemplate freightTemplate){
        freightTemplateMapper.insert(freightTemplate);
    }

    /**
     * 根据ID查询FreightTemplate
     * @param id
     * @return
     */
    @Override
    public FreightTemplate findById(Integer id){
        return  freightTemplateMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询FreightTemplate全部数据
     * @return
     */
    @Override
    public List<FreightTemplate> findAll() {
        return freightTemplateMapper.selectAll();
    }
}
