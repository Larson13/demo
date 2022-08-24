package com.ptp.service;

import com.ptp.mode.Duser;
import com.ptp.mode.Menu;
import com.ptp.mode.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    int add (Duser user);
    Duser select(Integer id);
    int update(Duser user);
    int delete(Integer id);
    User getUserByLoginName(String loginName );

    void addOrUpdate(User user);

    User getUserByLoginNameAndPassword( String loginName, String passWord);


}
