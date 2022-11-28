package com.f6.twodo.mapper;

import com.f6.twodo.vo.ToDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ToDoMapper {
    List<ToDo> getTodayTodo(Integer dispCount);
    List<ToDo> getBeforeTodo(Integer dispCount);
    ToDo getTodoOnce(@Param("id") Integer id);
    List<ToDo> getNextTodo(Integer dispCount);
    Integer addToDo(@Param("todo") ToDo todo);
    Integer doneToDo(Integer todoID);

    /*Count*/
    Integer getBeforeTodoTotalCount();
    Integer getBeforeTodoDoneCount();
    Integer getTodayTodoTotalCount();
    Integer getTodayTodoDoneCount();
    Integer getNextTodoTotalCount();
    Integer getNextTodoDoneCount();
    /*Count*/
}
