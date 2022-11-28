package com.f6.twodo.service;

import com.f6.twodo.mapper.ToDoMapper;
import com.f6.twodo.vo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private ToDoMapper obj_todo_mapper;

    public Integer addToDo(ToDo _newrow) {
        System.out.println("AddToDO:" + _newrow.getSubject());
        Integer rowcount =  obj_todo_mapper.addToDo(_newrow);
        return rowcount;
    }

    public Integer updateToDo(ToDo _newrow) {
        System.out.println("UpdateToDO:" + _newrow.getSubject());
        Integer rowcount =  obj_todo_mapper.updateToDo(_newrow);
        return rowcount;
    }
    public ToDo todomodify(Integer id) {
        System.out.println("viewTodo : " + id);
        return  obj_todo_mapper.getTodoOnce(id);
    }
}
