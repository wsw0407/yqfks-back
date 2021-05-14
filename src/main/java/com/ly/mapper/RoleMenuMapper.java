package com.ly.mapper;

import com.ly.entity.Menu;
import com.ly.entity.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    public List<Menu> getMenuByRoleId(Integer roleId);

}
