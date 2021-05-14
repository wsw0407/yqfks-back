package com.ly.service.impl;

import com.ly.entity.User;
import com.ly.mapper.UserMapper;
import com.ly.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-04-19
 */
@Service
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService {

}
