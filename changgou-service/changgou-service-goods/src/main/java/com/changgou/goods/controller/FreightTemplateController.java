package com.changgou.goods.controller;
import com.changgou.goods.pojo.FreightTemplate;
import com.changgou.goods.service.FreightTemplateService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:shenkunlin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "FreightTemplateController")
@RestController
@RequestMapping("/freightTemplate")
@CrossOrigin
public class FreightTemplateController {

    @Autowired
    private FreightTemplateService freightTemplateService;

    /***
     * FreightTemplate分页条件搜索实现
     * @param freightTemplate
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "FreightTemplate条件分页查询",notes = "分页条件查询FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "FreightTemplate对象",value = "传入JSON数据",required = false) FreightTemplate freightTemplate, @PathVariable  int page, @PathVariable  int size){
        //调用FreightTemplateService实现分页条件查询FreightTemplate
        PageInfo<FreightTemplate> pageInfo = freightTemplateService.findPage(freightTemplate, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * FreightTemplate分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "FreightTemplate分页查询",notes = "分页查询FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用FreightTemplateService实现分页查询FreightTemplate
        PageInfo<FreightTemplate> pageInfo = freightTemplateService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param freightTemplate
     * @return
     */
    @ApiOperation(value = "FreightTemplate条件查询",notes = "条件查询FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @PostMapping(value = "/search" )
    public Result<List<FreightTemplate>> findList(@RequestBody(required = false) @ApiParam(name = "FreightTemplate对象",value = "传入JSON数据",required = false) FreightTemplate freightTemplate){
        //调用FreightTemplateService实现条件查询FreightTemplate
        List<FreightTemplate> list = freightTemplateService.findList(freightTemplate);
        return new Result<List<FreightTemplate>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FreightTemplate根据ID删除",notes = "根据ID删除FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用FreightTemplateService实现根据主键删除
        freightTemplateService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改FreightTemplate数据
     * @param freightTemplate
     * @param id
     * @return
     */
    @ApiOperation(value = "FreightTemplate根据ID修改",notes = "根据ID修改FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "FreightTemplate对象",value = "传入JSON数据",required = false) FreightTemplate freightTemplate,@PathVariable Integer id){
        //设置主键值
        freightTemplate.setId(id);
        //调用FreightTemplateService实现修改FreightTemplate
        freightTemplateService.update(freightTemplate);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增FreightTemplate数据
     * @param freightTemplate
     * @return
     */
    @ApiOperation(value = "FreightTemplate添加",notes = "添加FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "FreightTemplate对象",value = "传入JSON数据",required = true) FreightTemplate freightTemplate){
        //调用FreightTemplateService实现添加FreightTemplate
        freightTemplateService.add(freightTemplate);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询FreightTemplate数据
     * @param id
     * @return
     */
    @ApiOperation(value = "FreightTemplate根据ID查询",notes = "根据ID查询FreightTemplate方法详情",tags = {"FreightTemplateController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<FreightTemplate> findById(@PathVariable Integer id){
        //调用FreightTemplateService实现根据主键查询FreightTemplate
        FreightTemplate freightTemplate = freightTemplateService.findById(id);
        return new Result<FreightTemplate>(true,StatusCode.OK,"查询成功",freightTemplate);
    }

    /***
     * 查询FreightTemplate全部数据
     * @return
     */
    @ApiOperation(value = "查询所有FreightTemplate",notes = "查询所FreightTemplate有方法详情",tags = {"FreightTemplateController"})
    @GetMapping
    public Result<List<FreightTemplate>> findAll(){
        //调用FreightTemplateService实现查询所有FreightTemplate
        List<FreightTemplate> list = freightTemplateService.findAll();
        return new Result<List<FreightTemplate>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
