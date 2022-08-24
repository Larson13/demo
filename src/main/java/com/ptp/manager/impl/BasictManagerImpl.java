package com.ptp.manager.impl;

import com.ptp.dao.PageMapper;
import com.ptp.dao.ProjectMapper;
import com.ptp.manager.BasicManager;
import com.ptp.mode.Project;
import com.ptp.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Slf4j
@Component
public class BasictManagerImpl  extends  PageManagerImpl implements BasicManager {
    @Autowired
    private ProjectMapper projectMapper;



    @Override
    public Object addOrUpdateProject(Project project) {
        int rows = 0;
        if (project.getId() != null) {
            //更新工程
            project.setUpdateTime(new Date());
            Date date = projectMapper.selectByPrimaryKey(project.getId()).getCreateTime();
            project.setCreateTime(date);
            log.info("更新工程为：{}", project);

            projectMapper.updateByPrimaryKey(project);
        } else {
            //新增工作

            project.setCreateTime(new Date());
            projectMapper.insertSelective(project);
            log.info("新增工程为：{}", project);
        }
        return rows;
    }

    @Override
    public Object listAllProject(PageUtils<Project> json) {
        return getPageJson(projectMapper, json);
    }


}