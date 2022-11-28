package com.f6.twodo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

// Todo 용 Value Object
@Getter
@Setter
public class ToDoCount {
    Integer totalCount;
    Integer doneCount;
    Integer waitCount;

    public ToDoCount(Integer totalCount, Integer doneCount, Integer waitCount) {
        this.totalCount = totalCount;
        this.doneCount = doneCount;
        this.waitCount = waitCount;
    }
}
