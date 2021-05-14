package com.ly.entity;


import io.swagger.annotations.ApiModel;

@ApiModel(value = "RegistCode对象",description = "注册码对象")
public class RegistCode {

    private Integer id;
    private String code;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }



}
