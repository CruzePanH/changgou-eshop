package com.changgou.goods.service;

import com.changgou.goods.pojo.FreightTemplate;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:FreightTemplate业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface FreightTemplateService {

    /***
     * FreightTemplate多条件分页查询
     * @param freightTemplate
     * @param page
     * @param size
     * @return
     */
    PageInfo<FreightTemplate> findPage(FreightTemplate freightTemplate, int page, int size);

    /***
     * FreightTemplate分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<FreightTemplate> findPage(int page, int size);

    /***
     * FreightTemplate多条件搜索方法
     * @param freightTemplate
     * @return
     */
    List<FreightTemplate> findList(FreightTemplate freightTemplate);

    /***
     * 删除FreightTemplate
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改FreightTemplate数据
     * @param freightTemplate
     */
    void update(FreightTemplate freightTemplate);

    /***
     * 新增FreightTemplate
     * @param freightTemplate
     */
    void add(FreightTemplate freightTemplate);

    /**
     * 根据ID查询FreightTemplate
     * @param id
     * @return
     */
     FreightTemplate findById(Integer id);

    /***
     * 查询所有FreightTemplate
     * @return
     */
    List<FreightTemplate> findAll();
}
