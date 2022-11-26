package com.f6.twodo.controller;

import com.f6.twodo.TwodoGlobal;
import com.f6.twodo.service.MainService;
import com.f6.twodo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

        _model.addAttribute("todayTodo",
                this.obj_mainservice.getTodayTodo(g_global.getDiplay_todo_list_count()));

        return "main";
    }
}
