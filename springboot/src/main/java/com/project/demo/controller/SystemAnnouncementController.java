package com.project.demo.controller;

import com.project.demo.entity.SystemAnnouncement;
import com.project.demo.service.SystemAnnouncementService;
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
 * 系统公告：(SystemAnnouncement)表控制层
 *
 */
@RestController
@RequestMapping("/system_announcement")
public class SystemAnnouncementController extends BaseController<SystemAnnouncement, SystemAnnouncementService> {

    /**
     * 系统公告对象
     */
    @Autowired
    public SystemAnnouncementController(SystemAnnouncementService service) {
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
