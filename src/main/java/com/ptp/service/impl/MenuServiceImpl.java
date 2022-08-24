package com.ptp.service.impl;

import com.ptp.manager.SystemManager;
import com.ptp.mode.Menu;
import com.ptp.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private SystemManager systemManager;
    @Override
    public List<Menu> getMenuList() {
        return systemManager.listMenu();
    }
    @Override
    public List<Menu> mergeMenu(List<Menu> menuList) {
        // 拆分菜单，分为一级菜单列表和非一级菜单列表
        List<Menu> firstMenuList = new ArrayList<Menu>();
        List<Menu> otherMenuList = new ArrayList<Menu>();
        for (Menu menu : menuList) {
            if (menu.getLevel().intValue() == 1) {
                firstMenuList.add(menu);

            } else {
                otherMenuList.add(menu);

            }

        }
        log.info("一级菜单：{}",firstMenuList);
        log.info("二级级菜单：{}",otherMenuList);
        // 对一级菜单做遍历
        for (Menu fmenu : firstMenuList) {
            List<Menu> subMenu = new ArrayList<>();
            Long level = fmenu.getId();

            for (Menu menu : otherMenuList) {
                if (menu.getParentId() == level) {
                    subMenu.add(menu);
                }
            }
            fmenu.setSubMenuList(subMenu);
        }
        return firstMenuList;
    }
}
