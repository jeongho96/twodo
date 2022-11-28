package com.f6.twodo.mapper;

import com.f6.twodo.vo.Blog;
import com.f6.twodo.vo.TestDB;
import com.f6.twodo.vo.ToDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BlogMapper {
    List<Blog> getBlogMemory();

    Integer addBlog(@Param("blog")Blog blog);

}
