package com.f6.twodo.service;

import com.f6.twodo.mapper.QueryMapper;
import com.f6.twodo.vo.TestDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    QueryMapper obj_query_mapper;

    public TestService(QueryMapper _obj) {
        this.obj_query_mapper = _obj;
    }

    public List<TestDB> ReadyTest() {
        return this.obj_query_mapper.dbTest();
    }
}
