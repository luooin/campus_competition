package com.project.demo.controller;

import com.project.demo.entity.Operator;
import com.project.demo.service.OperatorService;
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
 * 操作人员：(Operator)表控制层
 *
 */
@RestController
@RequestMapping("/operator")
public class OperatorController extends BaseController<Operator, OperatorService> {

    /**
     * 操作人员对象
     */
    @Autowired
    public OperatorController(OperatorService service) {
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
