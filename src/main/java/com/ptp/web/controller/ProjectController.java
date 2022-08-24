package com.ptp.web.controller;

import com.ptp.mode.HttpClientResponse;
import com.ptp.mode.Project;
import com.ptp.mode.RestResponse;
import com.ptp.service.ProjectService;
import com.ptp.util.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
@RequestMapping("/basic/project")
public class ProjectController  extends  BaseController {
    @Autowired
    private ProjectService projectService;
    @GetMapping(value = "/page/manager")
    public String manager() {
        return "basic/project_manager";
    }

    @PostMapping(value = "/api/addOrUpdate", produces ="application/json;charset=utf-8" )
    @ResponseBody
    public RestResponse addOrUpdate(@Validated @RequestBody Project project, HttpSession session){
        if (project.getId() == null) {
            project.setCreateUserId((Long) session.getAttribute("nowUserId"));
        }else {
            project.setUpdateUserId((Long) session.getAttribute("nowUserId"));
        }
        return success(projectService.addOrUpdateProject(project));
    }
    @GetMapping(value = "/api/list")
    @ResponseBody
    public RestResponse listProject(PageUtils<Project> page, HttpSession session) {

        page.setIsAdmin((Integer) session.getAttribute("isAdmin"));
        page.setNowUserId((Long) session.getAttribute("nowUserId"));
        log.info("sdfdsfdfs:{}",page);
        Object object = projectService.listAllProject(page);
        return  success(object);
    }
}