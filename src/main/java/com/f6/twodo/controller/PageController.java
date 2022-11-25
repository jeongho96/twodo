package com.f6.twodo.controller;

import com.f6.twodo.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    TestService obj_testservice;

    public PageController(TestService _obj) {
        this.obj_testservice = _obj;
    }

    @GetMapping("/")
    public String index(Model _model) {
        _model.addAttribute("TestDBs", this.obj_testservice.ReadyTest());
        return "index";
    }
}
