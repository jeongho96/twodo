package com.f6.twodo.service;

import com.f6.twodo.mapper.BlogMapper;
import com.f6.twodo.vo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper obj_blog_mapper;

    public List<Blog> getAllBlog(){
        return obj_blog_mapper.getBlogMemory();



    }

}
