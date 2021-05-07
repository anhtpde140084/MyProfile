package com.laptrinhjava.myinfor.AdminController;

import com.laptrinhjava.myinfor.DAO.InforAccountDAO;
import com.laptrinhjava.myinfor.controller.BaseController;
import com.laptrinhjava.myinfor.model.InforAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping( value = "admin-login")
public class LoginController  extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String Login() {
        return "admin/Login";
    }

    @RequestMapping(value = "login-Action", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpSession session, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        try {
            InforAccountDAO adao = new InforAccountDAO();
            InforAccount acc;
            int result = adao.checkLogin(username, password);
            if (result > 0) {
                acc = adao.GetAccout(username);
                session.setAttribute("USER", acc);
                return "admin/index";

            } else {
                model.addAttribute("msg","Incorect Password or Username");
                return "admin/Login";
            }
        } catch (Exception e) {
            return "admin/Login";
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("USER");
        return "admin/Login";
    }
}
