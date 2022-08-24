package com.ptp.service.impl;

import com.ptp.dao.UserDao;
import com.ptp.manager.SystemManager;
import com.ptp.mode.Duser;
import com.ptp.mode.Menu;
import com.ptp.mode.User;
import com.ptp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private SystemManager systemManager;

    @Override
    public int add(Duser user) {
        log.info("新增用户--:{}", user);
        return userDao.insert(user);
    }

    @Override
    public Duser select(Integer id) {
        return userDao.select(id);
    }

    @Override
    public int update(Duser user) {
        return userDao.update(user);
    }

    @Override
    public int delete(Integer id) {
        return userDao.delete(id);
    }

    @Override
    public User getUserByLoginName(String loginName) {

        return systemManager.getUserByLoginName(loginName);
    }

    @Override
    public void addOrUpdate(User user) {
        systemManager.addOrUpdateUser(user);

    }

    @Override
    public User getUserByLoginNameAndPassword(String loginName, String passWord) {
        return systemManager.getUserByLoginNameAndPassword(loginName,passWord);
    }


}
