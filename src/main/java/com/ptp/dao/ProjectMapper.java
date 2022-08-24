package com.ptp.dao;

import com.ptp.mode.Project;

public interface ProjectMapper  extends PageMapper{
    int deleteByPrimaryKey(Long id);

    int insert(Project record);

    int insertSelective(Project record);

    Project selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}