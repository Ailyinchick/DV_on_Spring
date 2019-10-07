package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.DAO.DAOAccount;
import net.proselyte.springmvc.DAO.DAOuser;
import net.proselyte.springmvc.model.Developer;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class DeveloperController {
    DAOAccount da = new DAOAccount();
    DAOuser du = new DAOuser();
    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    @GetMapping(value = "myAction")
    public String mymeth(ModelMap model) {
        model.addAttribute("attrib", "hello form myaction");
        return "index";
    }

    @GetMapping(value = "findRichest")
    public String mymeth1(ModelMap model) {
        //model.addAttribute("dev", Developer.create("Mike").getName());
        model.addAttribute("dev", da.findRichest().getName());
        return "index";
    }

}
