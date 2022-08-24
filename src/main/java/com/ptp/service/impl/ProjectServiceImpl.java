package com.ptp.service.impl;

import com.ptp.manager.BasicManager;
import com.ptp.mode.Project;
import com.ptp.service.ProjectService;
import com.ptp.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
     private BasicManager basicManager;
    @Override
    public Object addOrUpdateProject(Project project) {
        return basicManager.addOrUpdateProject(project);
    }

    @Override
    public Object listAllProject(PageUtils<Project> page) {
        return basicManager.listAllProject(page);
    }
}
