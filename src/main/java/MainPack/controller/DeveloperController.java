package MainPack.controller;

import MainPack.service.MyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class DeveloperController {
    MyService ms = new MyService();

    @GetMapping(value = "/")
    public String index() {
        return "/index";
    }

    @GetMapping(value = "findRichest")
    public String mymeth1(ModelMap model) {
        model.addAttribute("richestUser", ms.showRichest());
        return "index";
    }

    @GetMapping(value = "findAll")
    public String findAll(ModelMap model) {
        model.addAttribute("allUsers", ms.displayAll());
        return "index";
    }

    @GetMapping(value = "bankSumm")
    public String bankSumm(ModelMap model) {
        model.addAttribute("bankSumm", ms.bankSumm());
        return "index";
    }

    @GetMapping(value = "findById")
    public String findById(ModelMap model) {

        return "index";
    }

}
