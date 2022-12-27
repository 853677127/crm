package com.dong.cicc.query;

import com.dong.cicc.base.BaseQuery;

/**
 * 营销机会查询类
 */
public class SaleChanceQuery extends BaseQuery {

    /**
     * 营销机会管理参数
     */
    private String customerName; // 客户名
    private String createMan; // 创建人
    private String state; // 分配状态 1=已分配  0=未分配


    /**
     * 客户开发计划参数
     */
    // 指派人
    private Integer assignMan;
    // 开发状态
    private Integer devResult;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCreateMan() {
        return createMan;
    }

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getAssignMan() {
        return assignMan;
    }

    public void setAssignMan(Integer assignMan) {
        this.assignMan = assignMan;
    }

    public Integer getDevResult() {
        return devResult;
    }

    public void setDevResult(Integer devResult) {
        this.devResult = devResult;
    }
}
