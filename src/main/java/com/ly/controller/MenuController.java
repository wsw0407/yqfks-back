package com.ly.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.entity.Menu;
import com.ly.entity.MenuTree;
import com.ly.entity.User;
import com.ly.service.MenuService;
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
@Api(tags = "菜单管理")
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "getAll",notes = "获取菜单全部数据")
    @RequestMapping(value="/list",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAll(){

        List<Menu> list  = menuService.list();

        RespondObj obj = new  RespondObj(200,list);
        return obj;
    }

    @ApiOperation(value = "getAllTree",notes = "获取菜单树数据")
    @RequestMapping(value="/listTree",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAllTree(){

        List<MenuTree> list  = menuService.getAllTree();

        RespondObj obj = new  RespondObj(200,list);
        return 	obj;

    }

    @ApiOperation(value = "register",notes = "添加菜单")
    @RequestMapping(value="/add",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj register(@RequestBody Menu menu){

        menuService.saveOrUpdate(menu);
        Integer menuId = menu.getId();
        RespondObj obj = new  RespondObj(200,menuId);
        return obj;
    }

    @ApiOperation(value = "updMenu",notes = "修改菜单")
    @RequestMapping(value = "/upd",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public RespondObj updMenu(Menu menu){

        menuService.updateById(menu);

        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }

    @ApiOperation(value = "delMenu",notes = "修改菜单")
    @RequestMapping(value = "/delete",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public RespondObj delMenu(Integer id) {

        menuService.removeById(id);
        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }

    @ApiOperation(value = "getMenuById",notes = "根据id查询菜单")
    @RequestMapping(value="/getMenuById",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getMenuById(Integer id) {

        Menu menu = menuService.getById(id);

        RespondObj obj = new  RespondObj(200,menu);
        return obj;
    }

    @ApiOperation(value = "getAllMenuPage",notes = "分页查询菜单数据")
    @RequestMapping(value="/listPage",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAllMenuPage(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
                               ){

        Page<Menu> page = new Page<>(pageNo,pageSize);

        HashMap<String, Object> map = new HashMap<String, Object>();
        menuService.page(page);

        map.put("PageSize",page.getSize());
        map.put("PageNum",pageNo);
        map.put("Total",page.getTotal());
        map.put("TotalPage",page.getPages());
        map.put("List",page.getRecords());

        RespondObj obj = new  RespondObj(200,map);
        return obj;
    }



}

