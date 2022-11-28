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

    /*BeforeTodo start*/
    public List<ToDo> getBeforeTodo(Integer dispCount) {
        System.out.println("getBeforeTodo");
        List<ToDo> beforeTodo =  obj_todo_mapper.getBeforeTodo(dispCount);
        return beforeTodo;
    }
    public Integer getBeforeTodoToTalCount() {
        System.out.println("getBeforeTodoToTalCount");
        Integer beforeTotalCount =  obj_todo_mapper.getBeforeTodoTotalCount();
        return beforeTotalCount;
    }
    public Integer getBeforeTodoDoneCount() {
        System.out.println("getBeforeTodoDoneCount");
        Integer beforeDoneCount =  obj_todo_mapper.getBeforeTodoDoneCount();
        return beforeDoneCount;
    }
    /*BeforeTodo end*/

    /*TodayTodo start*/
    public List<ToDo> getTodayTodo(Integer dispCount) {
        System.out.println("getTodayTodo");
        List<ToDo> todayTodo =  obj_todo_mapper.getTodayTodo(dispCount);
        return todayTodo;
    }
    public Integer getTodayTodoTotalCount() {
        System.out.println("getTodayTodoTotalCount");
        Integer TodayTotalCount =  obj_todo_mapper.getTodayTodoTotalCount();
        return TodayTotalCount;
    }
    public Integer getTodayTodoDoneCount() {
        System.out.println("getTodayTodoDoneCount");
        Integer TodayDoneCount =  obj_todo_mapper.getTodayTodoDoneCount();
        return TodayDoneCount;
    }
    /*TodayTodo end*/

    /*NextTodo start*/
    public List<ToDo> getNextTodo(Integer dispCount) {
        System.out.println("getNextTodo");
        List<ToDo> nextTodo =  obj_todo_mapper.getNextTodo(dispCount);
        return nextTodo;
    }
    public Integer getNextTodoTotalCount() {
        System.out.println("getNextTodoTotalCount");
        Integer nextTotalCount =  obj_todo_mapper.getNextTodoTotalCount();
        return nextTotalCount;
    }
    public Integer getNextTodoDoneCount() {
        System.out.println("getNextTodoDoneCount");
        Integer NextDoneCount =  obj_todo_mapper.getNextTodoDoneCount();
        return NextDoneCount;
    }
    /*NextTodo end*/

    public Integer doneToDo(Integer _todo_id) {
        System.out.println("doneToDo:" + _todo_id.toString());
        Integer rowcount =  obj_todo_mapper.doneToDo(_todo_id);
        return rowcount;
    }

}
