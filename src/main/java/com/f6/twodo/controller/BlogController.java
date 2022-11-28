package com.f6.twodo.controller;

import com.f6.twodo.service.BlogService;
import com.f6.twodo.vo.Blog;
import com.f6.twodo.vo.ToDo;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

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
    @GetMapping("/main/blog/insert")
    public String blogInsert(Model _model) {
        return "bloginsert";
    }
    @GetMapping("/main/blog/modify/{id}")
    public String todomodify(@PathVariable("id") Integer view_id, Model _model) {
        _model.addAttribute("id", view_id);

        Blog currentrow = this.obj_blog_service.viewBlog(view_id);
        _model.addAttribute("blogOnce", currentrow);
        return "blogEdit";
    }

    @GetMapping("/main/blog/view/{id}")
    public String blogView(@PathVariable("id") Integer view_id, Model _model) {
        _model.addAttribute("id", view_id);

        Blog currentrow = this.obj_blog_service.viewBlog(view_id);
        _model.addAttribute("blogOnce", currentrow);
        return "blogView";
    }

    @PostMapping("/main/blog")
    @ResponseBody
    public String blogAddNew(@RequestParam String secret,
                             @RequestParam String title,
                             @RequestParam String content,
                             @RequestParam("photo") MultipartFile photo,
                             @RequestParam String locationtag,
                             @RequestParam Integer star,
                             Model _model) throws IllegalStateException, IOException {
        System.out.println("in blogAddNew");

        Blog newBlog = new Blog(secret, title, content,
                photo.isEmpty() == true ? null : photo.getOriginalFilename(), null, locationtag, star);

        if(photo.isEmpty() == false) {
            System.out.println(photo.getSize());
            UUID one = UUID.randomUUID();
            String ext = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1);
            File newFileName = new File(one.toString().replace("-", "") + "." + ext);
            photo.transferTo(newFileName);
            newBlog.setOrifilename(photo.getOriginalFilename());
            newBlog.setFilename(newFileName.getName());
            System.out.println(newBlog.getFilename());
        }

        System.out.println(newBlog.getTitle());
        Integer rowcount = this.obj_blog_service.addBlog(newBlog);
        _model.addAttribute("rowcount", rowcount);

        return "<Script> alert('등록완료'); location.href='/main'; </script>";
    }

    @PostMapping("/main/blog/mod")
    @ResponseBody
    public String blogModify(@RequestParam Integer id,
                             @RequestParam String title,
                             @RequestParam String content,
                             @RequestParam String locationtag,
                             Model _model) {
        System.out.println("in blogModify:" + id);

        Blog modBlog = new Blog(id, title, content,locationtag);

        System.out.println(modBlog.getTitle());
        Integer rowcount = this.obj_blog_service.modBlog(modBlog);
        _model.addAttribute("rowcount", rowcount);
        return "<Script> alert('수정완료'); location.href='/main/blog/view/" + id + "'; </script>";
    }

    @GetMapping("/main/blog/del/{id}")
    @ResponseBody
    public String blogDelete(@PathVariable Integer id) {
        System.out.println("in blogDelete");
        Integer rowcount = this.obj_blog_service.delBlog(id);
        return "<Script> alert('삭제 완료'); location.href='/main'; </script>";
    }
}
