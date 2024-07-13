package com.project.demo.controller;

import com.project.demo.entity.ParticipatingUsers;
import com.project.demo.service.ParticipatingUsersService;
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
 * 参赛用户：(ParticipatingUsers)表控制层
 *
 */
@RestController
@RequestMapping("/participating_users")
public class ParticipatingUsersController extends BaseController<ParticipatingUsers, ParticipatingUsersService> {

    /**
     * 参赛用户对象
     */
    @Autowired
    public ParticipatingUsersController(ParticipatingUsersService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapuser_student_id = new HashMap<>();
        mapuser_student_id.put("user_student_id",String.valueOf(paramMap.get("user_student_id")));
        List listuser_student_id = service.select(mapuser_student_id, new HashMap<>()).getResultList();
        if (listuser_student_id.size()>0){
            return error(30000, "字段用户学号内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
