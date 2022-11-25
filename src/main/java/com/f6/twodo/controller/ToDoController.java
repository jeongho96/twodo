package com.f6.twodo.controller;

import com.f6.twodo.controller.dto.ToDoDTO;
import com.f6.twodo.service.ToDoService;
import com.f6.twodo.vo.ToDo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ToDoController {
    ToDoService obj_todo_service;


    public ToDoController(ToDoService _obj) {
        this.obj_todo_service = _obj;
    }

    @GetMapping("/main/todo/insert")
    public String todoInsert(Model _model) {
        return "todoinsert";
    }

    @PostMapping("/main/todo")
    @ResponseBody
    public String todoAddNew(ToDoDTO _recvFormValues, Model _model) {
        System.out.println("in todoAddNew");
        ToDo newToDo = _recvFormValues.getToDo();

        System.out.println(newToDo.getSubject());
        Integer rowcount = this.obj_todo_service.addToDo(newToDo);
        _model.addAttribute("rowcount", rowcount);
        return "<Script> alert('등록완료') </script>";
    }
}
