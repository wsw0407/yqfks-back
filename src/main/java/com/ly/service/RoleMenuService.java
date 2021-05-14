package com.ly.service;

import com.ly.entity.Menu;
import com.ly.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
public interface RoleMenuService extends IService<RoleMenu> {

    public List<Menu> getMenuByRoleId(Integer roleId);

}
