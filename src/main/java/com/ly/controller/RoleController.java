package com.ly.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.entity.Role;
import com.ly.entity.User;
import com.ly.service.RoleService;
import com.ly.utils.RespondObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
@Controller
@Api(tags = "角色管理")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;


    @ApiOperation(value = "getAll",notes = "获取角色全部信息")
    @RequestMapping(value="/list",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAll(){

        List<Role> list  = roleService.list();

        RespondObj obj = new  RespondObj(200,list);
        return obj;
    }

    @ApiOperation(value = "register",notes = "注册角色")
    @RequestMapping(value="/add",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj register(@RequestBody Role role){

        roleService.saveOrUpdate(role);
        RespondObj obj = new  RespondObj(200,role);
        return obj;
    }

    @ApiOperation(value = "updRole",notes = "修改角色")
    @RequestMapping(value="/upd",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj updRole(@RequestBody Role role){

        roleService.updateById(role);

        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }

    @ApiOperation(value = "delRole",notes = "删除角色")
    @RequestMapping("/delete")
    @ResponseBody
    public RespondObj delRole(Integer id) {

        roleService.removeById(id);
        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }

    @ApiOperation(value = "getRoleById",notes = "根据id获取角色")
    @RequestMapping(value="/getRoleById",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getRoleById(Integer id) {

		/*Role role = new Role();
		role.setId(7);
		role.setRolename("swds");
		role.setDescription("普通用户");*/

        Role role = roleService.getById(id);
        RespondObj obj = new  RespondObj(200,role);
        return obj;
    }

    @ApiOperation(value = "getAllRolePage",notes = "获取角色分页数据")
    @RequestMapping(value="/listPage",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAllRolePage(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                                 ){

        Page<Role> page = new Page<>(pageNo,pageSize);
        roleService.page(page);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("PageNum",pageNo);
        map.put("PageSize",page.getSize());
        map.put("Total",page.getTotal());
        map.put("TotalPage",page.getPages());
        map.put("List",page.getRecords());

        RespondObj obj = new  RespondObj(200,map);
        return obj;
    }

}

