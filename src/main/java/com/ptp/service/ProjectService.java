package com.ptp.service;

import com.ptp.mode.Project;
import com.ptp.util.PageUtils;

public interface ProjectService {

    Object addOrUpdateProject(Project project);

    Object listAllProject(PageUtils<Project> page);
}
