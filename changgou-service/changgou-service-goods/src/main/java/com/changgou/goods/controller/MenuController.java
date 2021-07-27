package com.changgou.goods.controller;
import com.changgou.goods.pojo.Menu;
import com.changgou.goods.service.MenuService;
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
@Api(value = "MenuController")
@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;

    /***
     * Menu分页条件搜索实现
     * @param menu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Menu条件分页查询",notes = "分页条件查询Menu方法详情",tags = {"MenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Menu对象",value = "传入JSON数据",required = false) Menu menu, @PathVariable  int page, @PathVariable  int size){
        //调用MenuService实现分页条件查询Menu
        PageInfo<Menu> pageInfo = menuService.findPage(menu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Menu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Menu分页查询",notes = "分页查询Menu方法详情",tags = {"MenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用MenuService实现分页查询Menu
        PageInfo<Menu> pageInfo = menuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param menu
     * @return
     */
    @ApiOperation(value = "Menu条件查询",notes = "条件查询Menu方法详情",tags = {"MenuController"})
    @PostMapping(value = "/search" )
    public Result<List<Menu>> findList(@RequestBody(required = false) @ApiParam(name = "Menu对象",value = "传入JSON数据",required = false) Menu menu){
        //调用MenuService实现条件查询Menu
        List<Menu> list = menuService.findList(menu);
        return new Result<List<Menu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Menu根据ID删除",notes = "根据ID删除Menu方法详情",tags = {"MenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable String id){
        //调用MenuService实现根据主键删除
        menuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Menu数据
     * @param menu
     * @param id
     * @return
     */
    @ApiOperation(value = "Menu根据ID修改",notes = "根据ID修改Menu方法详情",tags = {"MenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Menu对象",value = "传入JSON数据",required = false) Menu menu,@PathVariable String id){
        //设置主键值
        menu.setId(id);
        //调用MenuService实现修改Menu
        menuService.update(menu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Menu数据
     * @param menu
     * @return
     */
    @ApiOperation(value = "Menu添加",notes = "添加Menu方法详情",tags = {"MenuController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Menu对象",value = "传入JSON数据",required = true) Menu menu){
        //调用MenuService实现添加Menu
        menuService.add(menu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Menu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Menu根据ID查询",notes = "根据ID查询Menu方法详情",tags = {"MenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "String")
    @GetMapping("/{id}")
    public Result<Menu> findById(@PathVariable String id){
        //调用MenuService实现根据主键查询Menu
        Menu menu = menuService.findById(id);
        return new Result<Menu>(true,StatusCode.OK,"查询成功",menu);
    }

    /***
     * 查询Menu全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Menu",notes = "查询所Menu有方法详情",tags = {"MenuController"})
    @GetMapping
    public Result<List<Menu>> findAll(){
        //调用MenuService实现查询所有Menu
        List<Menu> list = menuService.findAll();
        return new Result<List<Menu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
