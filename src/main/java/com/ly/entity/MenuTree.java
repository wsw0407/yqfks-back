package com.ly.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;


@ApiModel(value = "MenuTree对象",description = "菜单数据树结构对象")
public class MenuTree implements Serializable{

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String label;
    private List<MenuTree> children;
    public MenuTree(Integer id2, String name, List<MenuTree> children2) {
        this.id = id2;
        this.label = name;
        this.children=children2;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    public List<MenuTree> getChildren() {
        return children;
    }
    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }
    @Override
    public String toString() {
        return "MenuTree [id=" + id + ", label=" + label + ", children=" + children + "]";
    }

}
