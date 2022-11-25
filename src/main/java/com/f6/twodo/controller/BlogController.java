package com.f6.twodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/main/blog/insert")
    public String blogInsert(Model _model) {
        return "bloginsert";
    }
}
