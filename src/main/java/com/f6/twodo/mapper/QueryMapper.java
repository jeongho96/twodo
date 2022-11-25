package com.f6.twodo.mapper;

import com.f6.twodo.vo.TestDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QueryMapper {
    List<TestDB> dbTest();
}
