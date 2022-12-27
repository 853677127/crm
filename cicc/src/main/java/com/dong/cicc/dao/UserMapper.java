package com.dong.cicc.dao;

import com.dong.cicc.base.BaseMapper;
import com.dong.cicc.vo.User;

/**
 * @author 86158
 */
public interface UserMapper extends BaseMapper<User,Integer> {

    public User queryUserByName(String userName);
}