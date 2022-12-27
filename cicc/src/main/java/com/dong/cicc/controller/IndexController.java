package com.dong.cicc.controller;

import com.dong.cicc.base.BaseController;
import com.dong.cicc.service.UserService;
import com.dong.cicc.utils.LoginUserUtil;
import com.dong.cicc.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController extends BaseController {

    @Resource
    private UserService userService;
//    @Resource
//    private PermissionMapper permissionMapper;

    /**
     * 系统登录页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }


    // 系统界面欢迎页
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 后端管理主页面
     * @return
     */
    @RequestMapping("main")
    public String main( HttpServletRequest request){

          // 获取cookie中设置的用户id
          Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
          // 通过用户ID查询用户对象
          User user = userService.selectByPrimaryKey(userId);
          // 将用户对象设置到作用域中
          request.getSession().setAttribute("user", user);
//
//
//        // 当用户登录成功后，查询当前登录用户拥有的所有资源的权限码，返回集合
//        List<String> permissions = permissionMapper.queryPermissionsByUserId(userId);
//        // 设置到session请求域中，让前端判断权限是否拥有
//        request.getSession().setAttribute("permissions",permissions);

        return "main";
    }
}
