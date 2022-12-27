package com.dong.cicc.controller;

import com.alibaba.fastjson.JSON;
import com.dong.cicc.base.BaseController;
import com.dong.cicc.base.ResultInfo;
import com.dong.cicc.model.UserModel;
import com.dong.cicc.service.UserService;
import com.dong.cicc.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public ResultInfo userLogin(String userName, String userPwd){
        ResultInfo resultInfo = new ResultInfo();

        UserModel userModel = userService.userLogin(userName,userPwd);
        // 将返回的对象设置resultInfo对象中
        resultInfo.setCode(200);
        resultInfo.setResult(userModel);

        return resultInfo;
    }

    @PostMapping("updatePwd")
    @ResponseBody
    public ResultInfo updatePwd(HttpServletRequest request, String oldPwd, String newPwd, String rePwd){
        ResultInfo resultInfo = new ResultInfo();

        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        userService.updatePwd( userId, oldPwd, newPwd, rePwd);

        resultInfo.setCode(200);
        return resultInfo;
    }

    @RequestMapping("toPasswordPage")
    public String toPasswordPage() {

        return "user/password";
    }
}
