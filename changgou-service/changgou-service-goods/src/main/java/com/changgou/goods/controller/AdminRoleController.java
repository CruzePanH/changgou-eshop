package com.changgou.goods.controller;
import com.changgou.goods.pojo.AdminRole;
import com.changgou.goods.service.AdminRoleService;
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
@Api(value = "AdminRoleController")
@RestController
@RequestMapping("/adminRole")
@CrossOrigin
public class AdminRoleController {

    @Autowired
    private AdminRoleService adminRoleService;

    /***
     * AdminRole分页条件搜索实现
     * @param adminRole
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "AdminRole条件分页查询",notes = "分页条件查询AdminRole方法详情",tags = {"AdminRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "AdminRole对象",value = "传入JSON数据",required = false) AdminRole adminRole, @PathVariable  int page, @PathVariable  int size){
        //调用AdminRoleService实现分页条件查询AdminRole
        PageInfo<AdminRole> pageInfo = adminRoleService.findPage(adminRole, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * AdminRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "AdminRole分页查询",notes = "分页查询AdminRole方法详情",tags = {"AdminRoleController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用AdminRoleService实现分页查询AdminRole
        PageInfo<AdminRole> pageInfo = adminRoleService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param adminRole
     * @return
     */
    @ApiOperation(value = "AdminRole条件查询",notes = "条件查询AdminRole方法详情",tags = {"AdminRoleController"})
    @PostMapping(value = "/search" )
    public Result<List<AdminRole>> findList(@RequestBody(required = false) @ApiParam(name = "AdminRole对象",value = "传入JSON数据",required = false) AdminRole adminRole){
        //调用AdminRoleService实现条件查询AdminRole
        List<AdminRole> list = adminRoleService.findList(adminRole);
        return new Result<List<AdminRole>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AdminRole根据ID删除",notes = "根据ID删除AdminRole方法详情",tags = {"AdminRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用AdminRoleService实现根据主键删除
        adminRoleService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改AdminRole数据
     * @param adminRole
     * @param id
     * @return
     */
    @ApiOperation(value = "AdminRole根据ID修改",notes = "根据ID修改AdminRole方法详情",tags = {"AdminRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "AdminRole对象",value = "传入JSON数据",required = false) AdminRole adminRole,@PathVariable Integer id){
        //设置主键值
        adminRole.setRoleId(id);
        //调用AdminRoleService实现修改AdminRole
        adminRoleService.update(adminRole);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增AdminRole数据
     * @param adminRole
     * @return
     */
    @ApiOperation(value = "AdminRole添加",notes = "添加AdminRole方法详情",tags = {"AdminRoleController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "AdminRole对象",value = "传入JSON数据",required = true) AdminRole adminRole){
        //调用AdminRoleService实现添加AdminRole
        adminRoleService.add(adminRole);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询AdminRole数据
     * @param id
     * @return
     */
    @ApiOperation(value = "AdminRole根据ID查询",notes = "根据ID查询AdminRole方法详情",tags = {"AdminRoleController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<AdminRole> findById(@PathVariable Integer id){
        //调用AdminRoleService实现根据主键查询AdminRole
        AdminRole adminRole = adminRoleService.findById(id);
        return new Result<AdminRole>(true,StatusCode.OK,"查询成功",adminRole);
    }

    /***
     * 查询AdminRole全部数据
     * @return
     */
    @ApiOperation(value = "查询所有AdminRole",notes = "查询所AdminRole有方法详情",tags = {"AdminRoleController"})
    @GetMapping
    public Result<List<AdminRole>> findAll(){
        //调用AdminRoleService实现查询所有AdminRole
        List<AdminRole> list = adminRoleService.findAll();
        return new Result<List<AdminRole>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
