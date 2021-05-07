package com.laptrinhjava.myinfor.AdminController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {

    @RequestMapping(value = "admin-home", method = RequestMethod.GET)
    public String index(){
        return "admin/index";
    }
}
