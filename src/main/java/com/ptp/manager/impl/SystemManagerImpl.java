package com.ptp.manager.impl;
import com.ptp.dao.MenuMapper;
import com.ptp.dao.UserMapper;
import com.ptp.manager.SystemManager;
import com.ptp.mode.Menu;
import com.ptp.mode.User;
import com.ptp.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class SystemManagerImpl implements SystemManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public User getUserByLoginName(String loginName) {
        return userMapper.getByLoginName(loginName);
    }


    @Override
    public User getUserByLoginNameAndPassword(String loginName, String passWord) {
        // log.info("用户名：{},密码:{}",loginName,passWord);
        return userMapper.getUserByLoginNameAndPassword(loginName,CommonUtils.getMD5(passWord));
    }


    @Override
    public List<Menu> listMenu() {
        return menuMapper.listAll();
   }

    @Override
    public void addOrUpdateUser(User user) {
        if(userMapper.getByLoginName(user.getLoginName())!=null){
            user.setPassword(CommonUtils.getMD5(user.getPassword()));
            userMapper.updateByPrimaryKey(user);
            log.info("更新用户");
        }else {
            user.setUsedFlag((byte)1);
            user.setCreateTime(new Date());
            user.setPassword(CommonUtils.getMD5(user.getPassword()));
            userMapper.insertSelective(user);
            log.info("新增用户");
        }

    }




}
