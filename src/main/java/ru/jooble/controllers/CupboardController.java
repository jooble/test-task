package ru.jooble.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jooble.controllers.form.CupboardForm;
import ru.jooble.domain.Cupboard;
import ru.jooble.domain.Equipment;
import ru.jooble.service.CupboardService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class CupboardController {
    public static final String ALL_CUPBOARD_PAGE = "allCupboard";
    public static final String SAVE_CUPBOARD_PAGE = "saveCupboard";
    @Autowired
    CupboardService cupboardService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<Cupboard> cupboards = cupboardService.getAll();
        model.addAttribute("cupboards", cupboards);
        return ALL_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard", method = RequestMethod.GET)
    public String showPageSaveCupboard(ModelMap model) {
        model.addAttribute("cupboardForm", new CupboardForm());
        return SAVE_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard/{id}", method = RequestMethod.GET)
    public String showPageUpdateCupboard(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("cupboardForm", new CupboardForm(cupboardService.getById(id)));
        return SAVE_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard", method = RequestMethod.POST)
    public String saveCupboard(CupboardForm cupboardForm) {
        if ("".equals(cupboardForm.getId())) {
            Cupboard cupboard = new Cupboard();
            cupboard.setName(cupboardForm.getName());
            cupboardService.save(cupboard);
        } else {
            Cupboard cupboard = new Cupboard();
            cupboard.setId(Integer.parseInt(cupboardForm.getId()));
            cupboard.setName(cupboardForm.getName());
            cupboardService.update(cupboard);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/cupboard/{id}", method = RequestMethod.POST)
    public String deleteCupboard(@PathVariable(value = "id") int id) {
        cupboardService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveCupboard(ModelMap model) {
        List<Equipment> equipments = new ArrayList<>();
        Cupboard cupboard = new Cupboard();
        cupboard.setName("Шкаф");
        cupboard.setEquipments(equipments);
        for (int i = 0; i < 5; i++) {
            cupboardService.save(cupboard);
        }
        return ALL_CUPBOARD_PAGE;
    }
}