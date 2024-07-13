package com.project.demo.controller;

import com.project.demo.entity.ProjectCategory;
import com.project.demo.service.ProjectCategoryService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 项目类别：(ProjectCategory)表控制层
 *
 */
@RestController
@RequestMapping("/project_category")
public class ProjectCategoryController extends BaseController<ProjectCategory, ProjectCategoryService> {

    /**
     * 项目类别对象
     */
    @Autowired
    public ProjectCategoryController(ProjectCategoryService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
