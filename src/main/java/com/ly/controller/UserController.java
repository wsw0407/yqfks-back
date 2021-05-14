package com.ly.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ly.entity.User;
import com.ly.service.UserService;
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
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "getAll",notes = "获取全部用户信息")
    @RequestMapping(value="/list",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAll(){

        List<User> list = userService.list();
		/*UserInfo user = new UserInfo();
		user.setId(1);
		user.setUsername("wsw");
		user.setPassword("123456789");*/

        RespondObj obj = new  RespondObj(200,list);

        return obj;
    }

    @ApiOperation(value = "getAllByContent",notes = "根据用户名和手机号模糊查找用户信息")
    @RequestMapping(value="/listByContent",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAllByContent(String content){

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.like("username",content)
                .or().like("phone",content);

        List<User> list = userService.list(wrapper);
        RespondObj obj = new  RespondObj(200,list);

        return obj;
    }

    @ApiOperation(value = "delUser",notes = "删除用户")
    @RequestMapping(value = "/delete",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public RespondObj delUser(Integer id) {

        userService.removeById(id);
        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }

    @ApiOperation(value = "getUserByNamePass",notes = "根据用户名和密码登录")
    @RequestMapping(value="/getUserByNamePass",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getUserByNamePass(String username,String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("username",username)
                .eq("password",password);


        User user = userService.getOne(wrapper,false);
        System.out.println(user);
        Integer status;

        if(user != null){
            status=200;
        }else {
            status=404;
        }
        RespondObj obj = new  RespondObj(status,user);
        return obj;
    }

    @ApiOperation(value = "getUserByNamePass",notes = "根据用户id查用户信息")
    @RequestMapping(value="/getUserById",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public RespondObj getUserById(Integer id) {
        User user = userService.getById(id);
        System.out.println(user);
        RespondObj obj = new  RespondObj(200,user);
        return obj;
    }

    @ApiOperation(value = "getAllUserPage",notes = "用户信息分页数据")
    @RequestMapping(value="/listPage",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj getAllUserPage(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize
    ){

        Page<User> page = new Page<>(pageNo,pageSize);

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.ne("id",1);
        userService.page(page,wrapper);

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("PageNum",pageNo);
        map.put("PageSize",page.getSize());
        map.put("Total",page.getTotal());
        map.put("TotalPage",page.getPages());
        map.put("List",page.getRecords());

        RespondObj obj = new  RespondObj(200,map);
        return obj;
    }


    @RequestMapping(value="/register",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public RespondObj register(@RequestBody User user){


		/*UserInfo user1 = new UserInfo();
		//user.setId(2);
		user1.setUsername("wswwswsw");
		user1.setPassword("123456789");*/
        userService.saveOrUpdate(user);

        RespondObj obj = new  RespondObj(200,user);
        return obj;
    }

    @RequestMapping(value="/upd",produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public RespondObj updUser(@RequestBody User user){

		/*UserInfo user = new UserInfo();
		user.setId(2);
		user.setUsername("wsw001");
		user.setPassword("123456789");*/
        System.out.print("+++++++++++++++++");
        System.out.print(user);
        userService.updateById(user);
        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }

    @RequestMapping(value="/updPass",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj updUserPass(Integer id,String password){

        UpdateWrapper<User> wrapper = new UpdateWrapper();
        wrapper.set("password",password).eq("id",id);

        userService.update(wrapper);
        RespondObj obj = new  RespondObj(200,null);
        return obj;
    }


}

