package com.dong.cicc.dao;

import com.dong.cicc.base.BaseMapper;
import com.dong.cicc.query.SaleChanceQuery;
import com.dong.cicc.vo.SaleChance;

import java.util.List;

public interface SaleChanceMapper extends BaseMapper<SaleChance,Integer> {

    // 多条件查询营销机列表
    List<SaleChance> querySaleChanceByParams(SaleChanceQuery saleChanceQuery);




}