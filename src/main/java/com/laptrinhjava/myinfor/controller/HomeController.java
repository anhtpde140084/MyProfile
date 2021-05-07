package com.laptrinhjava.myinfor.controller;

import com.laptrinhjava.myinfor.DAO.InforAccountDAO;
import com.laptrinhjava.myinfor.model.InforAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Đây là một Controller
@Controller
public class HomeController extends BaseController{

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView index() {
        mvShare.setViewName("home");
        return mvShare;
    }

    @Autowired
    InforAccountDAO inforAccountDAO;

    @RequestMapping(value = "/about")
    public ModelAndView aboutUs(){
        mvShare.setViewName("/about");
        InforAccount acc = inforAccountDAO.GetInfor();
        mvShare.addObject("acc", acc);
        return mvShare;
    }


}
