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

    @GetMapping("/main/todo/view/{id}")
    public String todoView(@PathVariable("id") Integer view_id, Model _model) {
        _model.addAttribute("id", view_id);

        ToDo currentrow = this.obj_todo_service.viewToDo(view_id);
        _model.addAttribute("todoOnce", currentrow);
        return "todoContent";
    }

    @GetMapping("/main/todo/modify/{id}")
    public String todomodify(@PathVariable("id") Integer view_id, Model _model) {
        _model.addAttribute("id", view_id);

        ToDo currentrow = this.obj_todo_service.viewToDo(view_id);
        _model.addAttribute("todoOnce", currentrow);
        return "todoEdit";
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

    @PostMapping("/main/todo/mod")
    @ResponseBody
    public String todoModify(@RequestParam Integer id,
                             @RequestParam String subject,
                             @RequestParam String detail,
                             @RequestParam("target_date")
                             @DateTimeFormat(pattern="yyyy-MM-dd")
                             Date target_date, // 형변환용
                             Model _model) {
        System.out.println("in todoModify");
        System.out.println("target_date:" + target_date);

        ToDo modToDo = new ToDo(id, subject, detail, target_date);

        System.out.println(modToDo.getSubject());
        System.out.println(modToDo.getTarget_date());
        Integer rowcount = this.obj_todo_service.modifyToDo(modToDo);
        _model.addAttribute("rowcount", rowcount);
        return "<Script> alert('수정완료'); location.href='/main/todo/view/" + id + "'; </script>";
    }

    @GetMapping("/main/todo/del/{id}")
    @ResponseBody
    public String todoDelete(@PathVariable("id") Integer id) {
        System.out.println("in todoDelete");
        Integer rowcount = this.obj_todo_service.delTodo(id);
        return "<Script> alert('삭제 완료'); location.href='/main'; </script>";
    }
}
