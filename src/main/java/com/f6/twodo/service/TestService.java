package com.f6.twodo.service;

import com.f6.twodo.TwodoGlobal;
import com.f6.twodo.mapper.QueryMapper;
import com.f6.twodo.vo.TestDB;
import com.f6.twodo.vo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    QueryMapper obj_query_mapper;

    @Autowired
    TwodoGlobal g_global;

    public TestService(QueryMapper _obj) {
        this.obj_query_mapper = _obj;
    }

    public List<TestDB> ReadyTest() {
        return this.obj_query_mapper.dbTest();
    }

    public List<ToDo> getTodoList() {
        return this.obj_query_mapper.getToDo(g_global.getDiplay_todo_list_count(), 0);
    }
}
