package com.ptp.manager;

import com.ptp.mode.Project;
import com.ptp.util.PageUtils;

public interface BasicManager {
    Object addOrUpdateProject(Project project);

    Object listAllProject(PageUtils<Project> json);
}
