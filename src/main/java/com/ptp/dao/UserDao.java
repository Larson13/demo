package com.ptp.dao;

import com.ptp.mode.Duser;
import com.ptp.mode.User;


public interface UserDao {
    int insert(Duser user);
    Duser select(Integer id);
    int update(Duser user);
    int delete(Integer id);

    void addOrUpdateUser(User user);

    User getUserByLoginName(String loginName);
}
