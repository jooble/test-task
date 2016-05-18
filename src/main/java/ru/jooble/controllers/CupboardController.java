package ru.jooble.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jooble.domain.Cupboard;
import ru.jooble.service.CupboardService;
import ru.jooble.service.EquipmentService;
import ru.jooble.validator.CupboardFromValidator;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CupboardController {
    private static final String ALL_CUPBOARD_PAGE = "allCupboard";
    private static final String SAVE_CUPBOARD_PAGE = "saveCupboard";

    @Autowired
    CupboardFromValidator cupboardFromValidator;

    @Autowired
    CupboardService cupboardService;

    @Autowired
    EquipmentService equipmentService;

    @InitBinder("cupboard")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(cupboardFromValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showPageAllCupboard(ModelMap model) {
        List<Cupboard> cupboards = cupboardService.getAll();
        model.addAttribute("cupboards", cupboards);
        return ALL_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard", method = RequestMethod.GET)
    public String showPageSaveCupboard(ModelMap model) {
        model.addAttribute("cupboard", new Cupboard());
        return SAVE_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard/{id}", method = RequestMethod.GET)
    public String showPageUpdateCupboard(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("cupboard", cupboardService.getById(id));
        return SAVE_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard", method = RequestMethod.POST)
    public String saveCupboard( Cupboard cupboard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_CUPBOARD_PAGE;
        }
        if (cupboard.getId() == 0) {
            cupboardService.save(cupboard);
        } else {
            cupboardService.update(cupboard);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/cupboard/{id}", method = RequestMethod.POST)
    public String deleteCupboard(@PathVariable(value = "id") int id) {
        cupboardService.deleteById(id);
        return "redirect:/";
    }
}