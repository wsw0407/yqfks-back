package com.ly.controller;

import com.ly.entity.RegistCode;
import com.ly.service.RegCodeService;
import com.ly.utils.RegistRandomCode;
import com.ly.utils.RespondObj;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegCodeController {

    public static int NUM=0;

    @Autowired
    private RegCodeService regCodeService;


    @RequestMapping(value="/toCreateCode",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "toCreateCode",notes = "创建注册码")
    public RespondObj toCreateCode(){

        String  code = RegistRandomCode.getRegisCode();
        regCodeService.addRegCode(code);

        RespondObj obj = new  RespondObj(200,code);
        return obj;
    }

    @ApiOperation(value = "toregistCode",notes = "验证注册码")
    @RequestMapping(value="/toregistCode",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json;charset=utf-8")
    @ResponseBody
    public RespondObj toregistCode(String registCode) {

        String Message = null;
        Integer status;
        RegistCode regCode = regCodeService.getRegCode(registCode);
        if (registCode == null || registCode == "") {
            Message = "注册码为空";
            status=404;
        }

        else if (regCode == null) {
            Message = "验证错误";
            status=404;
        }
        else {Message = "验证成功";status=200;}

        RespondObj obj = new  RespondObj(status,Message);
        return obj;

    }

}
