package com.f6.twodo.controller;

import com.f6.twodo.service.ToDoService;
import com.f6.twodo.vo.ToDo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                             @RequestParam("target_date")
                                 @DateTimeFormat(pattern="yyyy-MM-dd")
                                 Date target_date, // 형변환용
                             Model _model) {
        System.out.println("in todoAddNew");
        System.out.println("target_date:" + target_date);

        ToDo newToDo = new ToDo(subject, detail, target_date);

        System.out.println(newToDo.getSubject());
        System.out.println(newToDo.getTarget_date());
        Integer rowcount = this.obj_todo_service.addToDo(newToDo);
        _model.addAttribute("rowcount", rowcount);
        return "<Script> alert('등록완료'); location.href='/main'; </script>";
    }

    @GetMapping("/main/todo/modify/{id}")
    public String todomodify(@PathVariable("id") Integer id, Model _model) {
        _model.addAttribute("todo", id );

        ToDo currentrow = this.obj_todo_service.todomodify(id);
        _model.addAttribute("todoOnce", currentrow);

        return "todoedit";
    }

    @PutMapping("/main/todo")
    public String updateToDo(@RequestBody String id,
                             @RequestBody String subject,
                             @RequestBody String detail,
                             @RequestBody String target_date,
                             Model _model) {
        System.out.println("in todoUpdate:" + id);
        System.out.println("target_date:" + target_date);

//        ToDo updateToDo = new ToDo(subject, detail, target_date);
//
//        System.out.println(updateToDo.getSubject());
//        System.out.println(updateToDo.getTarget_date());
//        Integer rowcount = this.obj_todo_service.updateToDo(updateToDo);
//        _model.addAttribute("rowcount", rowcount);
        return "<Script> alert('수정완료'); location.href='/main'; </script>";
    }
}
