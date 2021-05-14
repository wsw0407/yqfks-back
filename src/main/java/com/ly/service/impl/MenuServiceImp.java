package com.ly.service.impl;

import com.ly.entity.Menu;
import com.ly.entity.MenuTree;
import com.ly.mapper.MenuMapper;
import com.ly.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class MenuServiceImp extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Override
    public List<MenuTree> getAllTree() {
        List<MenuTree> menuTrees = new ArrayList<MenuTree>();

        List<Menu> parentNodes = baseMapper.getMenuByParentId(0);

        for (Menu menu : parentNodes) {
            List<Menu> childNodes = baseMapper.getMenuByParentId(menu.getId());

            List<MenuTree> list = new ArrayList<MenuTree>();
            for (Menu ch : childNodes) {

                list.add(new MenuTree(ch.getId(), ch.getName(), null));
            }
            menuTrees.add(new MenuTree(menu.getId(), menu.getName(), list));
        }
        return menuTrees;
    }
}
