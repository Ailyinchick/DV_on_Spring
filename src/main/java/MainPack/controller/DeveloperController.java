package MainPack.controller;

import MainPack.service.MyService;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Service
@Controller

public class DeveloperController {

    MyService ms = new MyService();

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/findRichest")
    public String mymeth1(ModelMap model) {
        model.addAttribute("richestUser", ms.showRichest());
        return "index";
    }

    @GetMapping(value = "/findAll")
    public String findAll(ModelMap model) {
        model.addAttribute("allUsers", ms.displayAll());
        return "index";
    }

    @GetMapping(value = "/bankSumm")
    public String bankSumm(ModelMap model) {
        model.addAttribute("bankSumm", ms.bankSumm());
        return "index";
    }

    @PostMapping(value = "/findById")
    public String findById(@RequestParam String id, ModelMap model) {
        model.addAttribute("userById", ms.findById(id));
        return "index";
    }

}
