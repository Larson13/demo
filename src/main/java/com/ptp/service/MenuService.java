package com.ptp.service;

import com.ptp.mode.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> mergeMenu(List<Menu> menuList);
    List<Menu> getMenuList();
}
