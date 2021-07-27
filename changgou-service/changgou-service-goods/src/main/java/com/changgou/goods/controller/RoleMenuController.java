package com.changgou.goods.controller;
import com.changgou.goods.pojo.RoleMenu;
import com.changgou.goods.service.RoleMenuService;
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
@Api(value = "RoleMenuController")
@RestController
@RequestMapping("/roleMenu")
@CrossOrigin
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /***
     * RoleMenu分页条件搜索实现
     * @param roleMenu
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "RoleMenu条件分页查询",notes = "分页条件查询RoleMenu方法详情",tags = {"RoleMenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "RoleMenu对象",value = "传入JSON数据",required = false) RoleMenu roleMenu, @PathVariable  int page, @PathVariable  int size){
        //调用RoleMenuService实现分页条件查询RoleMenu
        PageInfo<RoleMenu> pageInfo = roleMenuService.findPage(roleMenu, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * RoleMenu分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "RoleMenu分页查询",notes = "分页查询RoleMenu方法详情",tags = {"RoleMenuController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用RoleMenuService实现分页查询RoleMenu
        PageInfo<RoleMenu> pageInfo = roleMenuService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param roleMenu
     * @return
     */
    @ApiOperation(value = "RoleMenu条件查询",notes = "条件查询RoleMenu方法详情",tags = {"RoleMenuController"})
    @PostMapping(value = "/search" )
    public Result<List<RoleMenu>> findList(@RequestBody(required = false) @ApiParam(name = "RoleMenu对象",value = "传入JSON数据",required = false) RoleMenu roleMenu){
        //调用RoleMenuService实现条件查询RoleMenu
        List<RoleMenu> list = roleMenuService.findList(roleMenu);
        return new Result<List<RoleMenu>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleMenu根据ID删除",notes = "根据ID删除RoleMenu方法详情",tags = {"RoleMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用RoleMenuService实现根据主键删除
        roleMenuService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改RoleMenu数据
     * @param roleMenu
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleMenu根据ID修改",notes = "根据ID修改RoleMenu方法详情",tags = {"RoleMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "RoleMenu对象",value = "传入JSON数据",required = false) RoleMenu roleMenu,@PathVariable Integer id){
        //设置主键值
        roleMenu.setRoleId(id);
        //调用RoleMenuService实现修改RoleMenu
        roleMenuService.update(roleMenu);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增RoleMenu数据
     * @param roleMenu
     * @return
     */
    @ApiOperation(value = "RoleMenu添加",notes = "添加RoleMenu方法详情",tags = {"RoleMenuController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "RoleMenu对象",value = "传入JSON数据",required = true) RoleMenu roleMenu){
        //调用RoleMenuService实现添加RoleMenu
        roleMenuService.add(roleMenu);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询RoleMenu数据
     * @param id
     * @return
     */
    @ApiOperation(value = "RoleMenu根据ID查询",notes = "根据ID查询RoleMenu方法详情",tags = {"RoleMenuController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<RoleMenu> findById(@PathVariable Integer id){
        //调用RoleMenuService实现根据主键查询RoleMenu
        RoleMenu roleMenu = roleMenuService.findById(id);
        return new Result<RoleMenu>(true,StatusCode.OK,"查询成功",roleMenu);
    }

    /***
     * 查询RoleMenu全部数据
     * @return
     */
    @ApiOperation(value = "查询所有RoleMenu",notes = "查询所RoleMenu有方法详情",tags = {"RoleMenuController"})
    @GetMapping
    public Result<List<RoleMenu>> findAll(){
        //调用RoleMenuService实现查询所有RoleMenu
        List<RoleMenu> list = roleMenuService.findAll();
        return new Result<List<RoleMenu>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
