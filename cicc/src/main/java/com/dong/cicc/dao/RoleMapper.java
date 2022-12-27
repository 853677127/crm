package com.dong.cicc.dao;

import com.dong.cicc.base.BaseMapper;
import com.dong.cicc.vo.Role;

import java.util.List;
import java.util.Map;

public interface RoleMapper extends BaseMapper<Role, Integer> {

    // 查询所有的角色
    public List<Map<String,Object>> queryAllRoles(Integer userId);

    // 通过角色名查询对象
    Role queryRoleByName(String roleName);

    // 删除角色
    Integer deleteRole(Integer roleId);
}