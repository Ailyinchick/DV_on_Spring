package net.proselyte.springmvc.controller;

import net.proselyte.springmvc.DAO.DAOAccount;
import net.proselyte.springmvc.DAO.DAOuser;
import net.proselyte.springmvc.model.Developer;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        model.addAttribute("richestUser", Developer.create("Mike").getName());
       // model.addAttribute("dev", da.findRichest().getName());
        return "index";
    }

    @GetMapping(value = "findAll")
    public String findAll(ModelMap model) {
        List varList = du.findAll();
/*        for (int i = 0; i < 2; i++) {

        }*/
        model.addAttribute("allUsers"," varList.get(2).toString()");
        return "index";
    }


    @GetMapping(value = "bankSumm")
    public String bankSumm(ModelMap model) {

        return "index";
    }


    @GetMapping(value = "findById")
    public String findById(ModelMap model) {

        return "index";
    }

}
