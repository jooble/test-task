package ru.jooble.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jooble.domain.Cupboard;
import ru.jooble.service.CupboardService;

@Controller
@RequestMapping("/")
public class Hello {
    @Autowired
    CupboardService cupboardService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        Cupboard cupboard = new Cupboard();
        cupboard.setName("Cupboard");
        cupboardService.save(cupboard);
        model.addAttribute("hello", cupboardService.getById(0));
        return "hello";
    }
}