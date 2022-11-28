package com.f6.twodo.controller;

import com.f6.twodo.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    BlogService obj_blog_service;

    public BlogController(BlogService _obj){
        this.obj_blog_service = _obj;

    }

    @GetMapping("/test/blog")
    public String blogList(Model model){


        model.addAttribute("BLOG", this.obj_blog_service.getAllBlog());

        System.out.print(model);
        return "test";

    }
    //@GetMapping("/main/blog/insert")
    //public String blogInsert(Model _model) {
      //  return "bloginsert";
    //}
}
