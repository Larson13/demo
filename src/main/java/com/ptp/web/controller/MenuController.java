package com.ptp.web.controller;

import com.ptp.mode.Menu;
import com.ptp.mode.RestResponse;
import com.ptp.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/sys/menu")
public class MenuController extends  BaseController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/api/list")
    @ResponseBody
    public RestResponse listMenu(HttpSession session){
        //从session拿到菜单
        List<Menu> menuList = (List<Menu>) session.getAttribute("menu");
        log.info("用户session中的菜单列表：{}", menuList);
        // 把菜单按照顺序和父子关系归纳好，然后再返回给前端
        if(menuList !=null){
            menuList = menuService.mergeMenu(menuList);
            log.info("合并成功，返回菜单为：{}", menuList);
        }

        return  success(menuList);

    }
}
