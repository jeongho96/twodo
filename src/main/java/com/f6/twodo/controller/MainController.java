package com.f6.twodo.controller;

import com.f6.twodo.TwodoGlobal;
import com.f6.twodo.service.MainService;
import com.f6.twodo.service.TestService;
import com.f6.twodo.vo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List<ToDo> beforeList = this.obj_mainservice.getBeforeTodo(g_global.getDiplay_todo_list_count());
        List<ToDo> todayList = this.obj_mainservice.getTodayTodo(g_global.getDiplay_todo_list_count());
        List<ToDo> nextList = this.obj_mainservice.getNextTodo(g_global.getDiplay_todo_list_count());
        _model.addAttribute("todayTodo", todayList);
        _model.addAttribute("beforeTodo", beforeList);
        _model.addAttribute("nextTodo", nextList);
        _model.addAttribute("empty",todayList.isEmpty());
        _model.addAttribute("beforeempty",beforeList.isEmpty());
        _model.addAttribute("nextempty",nextList.isEmpty());
        return "main";
    }
    @GetMapping("/main/tododone/{id}")
    @ResponseBody
    public String todoDone(@PathVariable("id") Integer todoID) {
        if(this.obj_mainservice.doneToDo(todoID) == 1) {
            return "<script> alert('일정완료'); location.href='/main'; </script>";
        }
        return "<script> alert('id 또는 시스템 오류 오류');</script>";
    }
}
