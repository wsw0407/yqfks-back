package com.ly.service;

import com.ly.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.entity.MenuTree;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
public interface MenuService extends IService<Menu> {

    public List<MenuTree> getAllTree();

}
