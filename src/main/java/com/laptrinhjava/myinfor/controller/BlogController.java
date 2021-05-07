package com.laptrinhjava.myinfor.controller;

import com.laptrinhjava.myinfor.DAO.BlogDAO;
import com.laptrinhjava.myinfor.Repository.BlogRepository;
import com.laptrinhjava.myinfor.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class BlogController extends BaseController {

    @Autowired
    BlogDAO blogDao;

    @Autowired
    BlogRepository blogRepository;

    @RequestMapping(value = "/show-blogs")
    public ModelAndView getAllBlog(){
        mvShare.setViewName("/weblog");
        mvShare.addObject("list", blogRepository.findAll());
        return mvShare;
    }

    @RequestMapping(value = "/get-blog/{name}", method = RequestMethod.GET)
    public String getBlogByName(@PathVariable String name, Model model){

        try {
            model.addAttribute("blogDetail", blogDao.getBlogByName(name));
            return "blog";
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "404";
    }
}
