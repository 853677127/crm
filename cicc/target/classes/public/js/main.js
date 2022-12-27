layui.use(['element', 'layer', 'layuimini','jquery','jquery_cookie'], function () {
    var $ = layui.jquery,
        layer = layui.layer,
        $ = layui.jquery_cookie($);

    // 菜单初始化
    $('#layuiminiHomeTabIframe').html('<iframe width="100%" height="100%" frameborder="0"  src="welcome"></iframe>')
    layuimini.initTab();


    /**
     * 用户退出登录
     */
    $(".login-out").click(function () {

        layer.confirm("确定要退出吗？", {icon: 3, title:"系统提示"} , function (index){

            layer.close(index);

            // 清空cookie对象
            $.removeCookie("userIdStr", {domain:"localhost",path:"/cicc"});
            $.removeCookie("userName", {domain:"localhost",path:"/cicc"});
            $.removeCookie("trueName", {domain:"localhost",path:"/cicc"});

            // 跳转到登录页面 (父窗口跳转)
            window.parent.location.href = ctx + "/index";
        });

    });


});