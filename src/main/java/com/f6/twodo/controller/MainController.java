package com.f6.twodo.controller;

import com.f6.twodo.TwodoGlobal;
import com.f6.twodo.service.MainService;
import com.f6.twodo.service.TestService;
import com.f6.twodo.vo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    MainService obj_mainservice;

    @Autowired
    TwodoGlobal g_global;

    public MainController(MainService _obj) {
        this.obj_mainservice = _obj;
    }

    @GetMapping("/maintest")
    public String maintest(Model _model) {
        _model.addAttribute("value", "valuevalue");
        return "test";
    }

    @GetMapping("/main")
    public String main(Model _model) {
        List<ToDo> todayList = this.obj_mainservice.getTodayTodo(g_global.getDiplay_todo_list_count());
        List<ToDo> beforeList = this.obj_mainservice.getBeforeTodo(g_global.getDiplay_todo_list_count());
        _model.addAttribute("todayTodo", todayList);
        _model.addAttribute("beforeTodo", beforeList);
        _model.addAttribute("empty",todayList.isEmpty());
        return "main";
    }
}
