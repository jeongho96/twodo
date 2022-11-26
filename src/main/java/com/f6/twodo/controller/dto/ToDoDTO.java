package com.f6.twodo.controller.dto;

import com.f6.twodo.vo.ToDo;
import lombok.Getter;

import java.util.Date;

@Getter
public class ToDoDTO {
    String subject;
    String detail;
    Date target_date;

    public ToDo getToDo() {
        System.out.println("GetTodo");
        System.out.println(subject + "," + detail + "," + target_date);
        return new ToDo(subject, detail, target_date);
    }
}
