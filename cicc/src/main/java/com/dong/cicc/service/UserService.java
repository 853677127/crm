package com.dong.cicc.service;

import com.dong.cicc.base.BaseService;
import com.dong.cicc.base.ResultInfo;
import com.dong.cicc.dao.UserMapper;
import com.dong.cicc.model.UserModel;
import com.dong.cicc.utils.AssertUtil;
import com.dong.cicc.utils.Md5Util;
import com.dong.cicc.utils.UserIDBase64;
import com.dong.cicc.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author 86158
 */
@Service
public class UserService extends BaseService<User, Integer> {

    @Resource
    private UserMapper userMapper;


    public UserModel userLogin(String userName, String userPwd){

        // 判断用户名或密码是否为空，如果为空则抛出异常 （用户名称或密码不能为空！）
        AssertUtil.isTrue(StringUtils.isBlank(userName) || StringUtils.isBlank(userPwd), "用户名称或密码不能为空！");
        // 调用Dao层的方法，通过用户名查询用户对象，返回用户对象
        User user = userMapper.queryUserByName(userName);
        // 判断用户对象是否为空
        AssertUtil.isTrue(user == null, "该用户不存在！");
        // 将前台传递的密码，通过MD5算法加密
        String pwd = Md5Util.encode(userPwd);
        // 将加密后的密码与数据库中查询用户对象中的密码作比较
        AssertUtil.isTrue(!pwd.equals(user.getUserPwd()), "用户密码不正确！");
        // 构建用户模型，并返回
        return buildUserModel(user);
    }

    private UserModel buildUserModel(User user) {
        UserModel userModel = new UserModel();

        // 将userId进行编码
        // userModel.setUserId(user.getId());
        userModel.setUserIdStr(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUserName(user.getUserName());
        userModel.setTrueName(user.getTrueName());

        return userModel;
    }

    @Transactional(propagation  = Propagation.REQUIRED)
    public void updatePwd(Integer userId, String oldPwd, String newPwd, String rePwd){

        User user = userMapper.selectByPrimaryKey(userId);

        AssertUtil.isTrue( user == null,"待更新用户不存在!");
        // 判断原始密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(oldPwd), "原始密码不能为空！");
        // 判断原始密码是否正确
        AssertUtil.isTrue(!Md5Util.encode(oldPwd).equals(user.getUserPwd()), "原始密码不正确！");
        // 判断新密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(newPwd), "新密码不能为空！");
        // 判断原始密码是否和新密码一致
        AssertUtil.isTrue(newPwd.equals(oldPwd), "新密码不能与原始密码一致！");
        // 判断重复密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(rePwd), "重复密码不能为空！");
        // 判断重复密码与新密码是否一致
        AssertUtil.isTrue(!newPwd.equals(rePwd), "重复密码与新密码不一致！");

        user.setUserPwd(Md5Util.encode(newPwd));
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) < 1, "修改密码失败！");
    }

}
