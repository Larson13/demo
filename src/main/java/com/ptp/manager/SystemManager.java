package com.ptp.manager;

import com.ptp.mode.Menu;
import com.ptp.mode.User;

import java.util.List;

public interface SystemManager {
    User getUserByLoginName(String loginName);

    void addOrUpdateUser(User user);

    User getUserByLoginNameAndPassword(String loginaName, String passWord);

    List<Menu> listMenu();
}
