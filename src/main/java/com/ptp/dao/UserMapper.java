package com.ptp.dao;


import com.ptp.mode.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    User getByLoginName(String loginName);

    User getUserByLoginNameAndPassword(@Param("loginName") String loginName, @Param("passWord") String passWord);
}