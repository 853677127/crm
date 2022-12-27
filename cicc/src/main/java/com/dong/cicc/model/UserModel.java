package com.dong.cicc.model;

/**
 * 用来邓庄返回的用户对象
 */
public class UserModel {

    // private Integer userId; // 用户ID
    private String userIdStr; // 编码后的用户Id
    private String userName; // 用户名称
    private String trueName; // 真实姓名

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
