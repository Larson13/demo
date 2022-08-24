package com.ptp.web.controller;

import com.ptp.mode.RestResponse;
import com.ptp.mode.Menu;
import com.ptp.mode.User;
import com.ptp.service.MenuService;
import com.ptp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import javax.validation.groups.Default;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sys/user")
@Api("用户管理")
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;


    @GetMapping("/page/login")
    public String getlogin() {
        return "system/login";
    }

    @GetMapping("/page/index")
    public String getindex() {
        return "system/index";
    }

    @PostMapping("/api/register")
    @ResponseBody
    @ApiOperation(value = "注册帐号，返回成功", notes = "注册帐号")
    @ApiImplicitParam(name = "user", required = true, value = "用户的json对象")
    public RestResponse register(@RequestBody @Validated({Default.class}) User user) {
        log.info("请求注册的参数为：{}", user);
        // 检查用户是否合法，比如admin，superadmin
        if ("admin".equals(user.getLoginName()) || "superadmin".equals(user.getLoginName())) {
            log.info("注册失败，用户名重复 {}", user);
            return fail("此用户名不允许使用");
        }
        // 检查用户提交的用户名是否已存在
        User dbUser = userService.getUserByLoginName(user.getLoginName());
        log.info("查到用户：{}", dbUser);
        if (dbUser != null) {
            log.info("注册失败，用户名已存在 {}", user);
            return fail("此用户名已存在");
        }
        // 插入数据库
        userService.addOrUpdate(user);
        log.info("注册成功：{}", user);
        return success();
    }

    @PostMapping("/api/login")
    @ResponseBody
    @ApiOperation(value = "登陆，返回成功", notes = "登陆")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "loginName", value = "用户名", defaultValue = "admin", dataType = "String"),
                    @ApiImplicitParam(name = "passWord", value = "密码", defaultValue = "123456", dataType = "String")
            }
    )

    public RestResponse getUserByLoginNameAndPassword(String loginName, String passWord, @ApiIgnore HttpSession session) {
        User user = userService.getUserByLoginNameAndPassword(loginName, passWord);
        // log.info("查到用户:{}",user);
        if (user == null) {
            String errorMsg = "用户名或者密码错误";
            log.error("用户名或者密码错误，请求参数为:用户名={},密码={}", loginName, passWord);
            return fail(errorMsg);

        }
        List<Menu> menu = menuService.getMenuList();
        log.info("菜单列表为:{}",menu);
        session.setAttribute("menu",menu);
        session.setAttribute("nowUserId", user.getId());
        session.setAttribute("nowLoginName", user.getLoginName());
        return success();

    }
}
