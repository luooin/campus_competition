package com.project.demo.controller;

import com.project.demo.entity.EventPlayers;
import com.project.demo.service.EventPlayersService;
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
 * 项目选手：(EventPlayers)表控制层
 *
 */
@RestController
@RequestMapping("/event_players")
public class EventPlayersController extends BaseController<EventPlayers, EventPlayersService> {

    /**
     * 项目选手对象
     */
    @Autowired
    public EventPlayersController(EventPlayersService service) {
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
