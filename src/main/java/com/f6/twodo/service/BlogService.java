package com.f6.twodo.service;

import com.f6.twodo.mapper.BlogMapper;
import com.f6.twodo.vo.Blog;
import com.f6.twodo.vo.ToDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogMapper obj_blog_mapper;

    public List<Blog> getAllBlog(){
        return obj_blog_mapper.getBlogList(6);
    }

    public Integer addBlog(Blog _newrow){
        System.out.println("Add:" + _newrow.getTitle());
        Integer rowcount = obj_blog_mapper.addBlog(_newrow);
        return rowcount;
    }
    public Integer modBlog(Blog _modrow){
        System.out.println("Mod:" + _modrow.getTitle());
        Integer rowcount = obj_blog_mapper.modBlog(_modrow);
        return rowcount;
    }

    public Integer delBlog(Integer id) {
        System.out.println("delBlog : " + id);
        Integer rowcount =  this.obj_blog_mapper.delBlog(id);
        return rowcount;
    }
    public Blog viewBlog(Integer id) {
        System.out.println("viewTodo : " + id);
        return  obj_blog_mapper.getBlogOnce(id);
    }
}
