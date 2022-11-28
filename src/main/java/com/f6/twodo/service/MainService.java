package com.f6.twodo.service;

import com.f6.twodo.mapper.ToDoMapper;
import com.f6.twodo.vo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    private ToDoMapper obj_todo_mapper;

    public List<ToDo> getTodayTodo(Integer dispCount) {
        System.out.println("getTodayTodo");
        List<ToDo> todayTodo =  obj_todo_mapper.getTodayTodo(dispCount);
        return todayTodo;
    }
    public List<ToDo> getBeforeTodo(Integer dispCount) {
        System.out.println("getBeforeTodo");
        List<ToDo> beforeTodo =  obj_todo_mapper.getBeforeTodo(dispCount);
        return beforeTodo;
    }
}
