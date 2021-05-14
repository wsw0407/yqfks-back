package com.ly.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ly.entity.Menu;
import com.ly.entity.RoleMenu;
import com.ly.service.RoleMenuService;
import com.ly.utils.RespondObj;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
@Api(tags = "角色菜单管理")
@RequestMapping("/rolemenu")
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    @ApiOperation(value = "addRoleMenu",notes = "添加角色菜单")
    @RequestMapping(value="/add", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj addRoleMenu(@RequestBody List<RoleMenu> list){

        System.out.println("=============================");
        System.out.println(list);

        for (RoleMenu roleMenu : list){
            roleMenuService.saveOrUpdate(roleMenu);
        }

        RespondObj obj = new  RespondObj(200,list);
        return obj;
    }

    @ApiOperation(value = "getMenuByRoleId",notes = "根据角色id查拥有菜单")
    @RequestMapping(value = "/getMenu",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public RespondObj getMenuByRoleId(Integer roleid){

        List<Menu> list = roleMenuService.getMenuByRoleId(roleid);

        RespondObj obj = new  RespondObj(200,list);
        return obj;
    }

    @ApiOperation(value = "getRoleMenuByRoleId",notes = "根据角色id查角色菜单")
    @RequestMapping(value="/getRoleMenu",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getRoleMenuByRoleId(Integer roleid){

        QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("roleid",roleid);
        List<RoleMenu> list = roleMenuService.list(wrapper);

        RespondObj obj = new  RespondObj(200,list);
        return obj;
    }

    @ApiOperation(value = "delRoleMenuByList",notes = "删除角色菜单")
    @RequestMapping(value="/deleteList", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj delRoleMenuByList(@RequestBody List<RoleMenu> list) {

		/*roleMenuService.delRoleMenuByList(list);
        RespondObj obj = new  RespondObj(200,null);
		return JSON.toJSONString(obj);*/

        System.out.println("=============================");
        System.out.println(list);

        for (RoleMenu roleMenu : list){
            QueryWrapper<RoleMenu> wrapper = new QueryWrapper<>();
            wrapper.eq("roleid",roleMenu.getRoleid()).eq("menuid",roleMenu.getMenuid());
        }

        RespondObj obj = new  RespondObj(200,list);
        return obj;
    }

    @ApiOperation(value = "delRoleMenuByRoleId",notes = "根据用户id删除角色菜单")
    @RequestMapping(value="/deleteId",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj delRoleMenuByRoleId(Integer roleid) {

        roleMenuService.removeById(roleid);

        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }



}

