package com.ly.service.impl;

import com.ly.entity.Menu;
import com.ly.entity.RoleMenu;
import com.ly.mapper.RoleMenuMapper;
import com.ly.service.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
@Service
public class RoleMenuServiceImp extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Override
    public List<Menu> getMenuByRoleId(Integer roleId) {
        return baseMapper.getMenuByRoleId(roleId);
    }
}
