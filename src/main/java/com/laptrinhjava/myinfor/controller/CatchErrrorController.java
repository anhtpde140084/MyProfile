package com.laptrinhjava.myinfor.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// handle when user type link not exits in website
@Controller
public class CatchErrrorController implements ErrorController {

    @RequestMapping(value ="/error")
    public String handleError() {
        return "404";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
