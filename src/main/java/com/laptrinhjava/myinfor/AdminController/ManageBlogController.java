package com.laptrinhjava.myinfor.AdminController;


import com.laptrinhjava.myinfor.DAO.BlogDAO;
import com.laptrinhjava.myinfor.controller.BaseController;
import com.laptrinhjava.myinfor.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "admin-blog")
public class ManageBlogController extends BaseController {
    @Autowired
    BlogDAO dao = new BlogDAO();

    @RequestMapping(method = RequestMethod.GET)
    public String blogPage(){
        return "admin/BlogPost";
    }

    @RequestMapping(value = "add-new-blog", method = RequestMethod.POST)
    public String AddBlog(HttpServletRequest request, Model model){

        String title = request.getParameter("title");
        String img = request.getParameter("img");
        String tag = request.getParameter("tag");
        String content = request.getParameter("content");
        Date now = new Date();
        java.sql.Date Create_date = new java.sql.Date(now.getTime());
        try {
            if(dao.AddBlog(new Blog(title,content,img, Create_date, tag))){
                return "redirect:get-all-blogs";
            } else return "admin/BlogPost";

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "admin/BlogPost";
    }

    @RequestMapping(value = "get-all-blogs", method= RequestMethod.GET)
    public String getAllBlog(Model model){
            model.addAttribute("list",dao.selectAll());
       return "admin/BlogManage";
    }

    @RequestMapping(value = "delete-blog/{id}", method = RequestMethod.GET)
    public String deleteBlog(@PathVariable int id, RedirectAttributes redirect){
        dao.DeleteBlog(id);
        redirect.addFlashAttribute("message", "Blog was delected");
        return "redirect:/admin-blog/get-all-blogs";
    }

    @RequestMapping(value = "edit-blog/{id}", method = RequestMethod.GET)
    public String getBlogById(@PathVariable int id, Model model){
        model.addAttribute("blogDetail", dao.getBlogById(id));
        return "admin/BlogModify";
    }
}
