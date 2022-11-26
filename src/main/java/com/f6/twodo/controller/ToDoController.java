package com.f6.twodo.controller;

import com.f6.twodo.controller.dto.ToDoDTO;
import com.f6.twodo.service.ToDoService;
import com.f6.twodo.vo.ToDo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

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
    public String todoAddNew(@RequestParam String subject,
                             @RequestParam String detail,
                             @RequestParam("target_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date target_date,
                             Model _model) {
        System.out.println("in todoAddNew");
        System.out.println("target_date:" + target_date);
        ToDo newToDo = new ToDo(subject, detail, target_date);

        System.out.println(newToDo.getSubject());
        System.out.println(newToDo.getTarget_date());
        Integer rowcount = this.obj_todo_service.addToDo(newToDo);
        _model.addAttribute("rowcount", rowcount);
        return "<Script> alert('등록완료') </script>";
    }
}
