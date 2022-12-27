package com.dong.cicc.dao;

import com.dong.cicc.base.BaseMapper;
import com.dong.cicc.query.CusDevPlanQuery;
import com.dong.cicc.vo.CusDevPlan;

import java.util.List;

public interface CusDevPlanMapper extends BaseMapper<CusDevPlan, Integer> {

    // 通过营销机会ID查询客户开发项列表
     List<CusDevPlan> selectByParams(CusDevPlanQuery cusDevPlanQuery);




}