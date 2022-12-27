package com.dong.cicc.dao;

import com.dong.cicc.base.BaseMapper;
import com.dong.cicc.vo.UserRole;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole,Integer> {

    // 通过用户ID查询用户角色信息
    Integer countRoleByUserId(Integer userId);

    // 通过用户ID删除用户角色信息
    void deleteUserRole(Integer userId);

    // 批量添加
    Integer insertBatch(List<UserRole> userRoleList);

    // 通过userId批量删除
    void deleteBatchUserRole(Integer[] ids);
}