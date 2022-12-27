package com.dong.cicc.dao;

import com.dong.cicc.base.BaseMapper;
import com.dong.cicc.model.TreeModel;
import com.dong.cicc.vo.Module;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModuleMapper extends BaseMapper<Module,Integer> {

    // 查询所有资源列表
    public List<TreeModel> queryAllModules();

    Integer countSubModuleByParentId(Integer moduleId);

    Integer deleteModule(Integer moduleId);

    // 通过层级与资源名查询
    Module queryModuleByGradeAndName(@Param("grade") Integer grade, @Param("moduleName") String moduleName);

    //  通过权限码查询
    Module queryModuleByOptValue(String optValue);
}