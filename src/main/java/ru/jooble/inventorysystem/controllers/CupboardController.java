package ru.jooble.inventorysystem.controllers;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jooble.inventorysystem.domain.Cupboard;
import ru.jooble.inventorysystem.service.CupboardService;
import ru.jooble.inventorysystem.service.EquipmentService;
import ru.jooble.inventorysystem.validator.CupboardFromValidator;

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

    private static final Logger LOGGER = Logger.getLogger(CupboardController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String showPageAllCupboard(ModelMap model) {
        List<Cupboard> cupboards = cupboardService.getAll();
        model.addAttribute("cupboards", cupboards);

        LOGGER.info("Show page all cupboard");
        return ALL_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard", method = RequestMethod.GET)
    public String showPageSaveCupboard(ModelMap model) {
        model.addAttribute("cupboard", new Cupboard());

        LOGGER.info("Show page save cupboard");
        return SAVE_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard/{id}", method = RequestMethod.GET)
    public String showPageUpdateCupboard(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("cupboard", cupboardService.getById(id));
        LOGGER.info("Show update save cupboard");
        return SAVE_CUPBOARD_PAGE;
    }

    @RequestMapping(value = "/save/cupboard", method = RequestMethod.POST)
    public String saveCupboard(@Valid Cupboard cupboard, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return SAVE_CUPBOARD_PAGE;
        }
        if (cupboard.getId() == 0) {
            cupboardService.save(cupboard);

            LOGGER.info("Save cupboard by request POST : /save/cupboard/");
        } else {
            cupboardService.update(cupboard);

            LOGGER.info("Save cupboard(ID" + +cupboard.getId() + ") by request POST : /save/cupboard/");
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/cupboard/{id}", method = RequestMethod.POST)
    public String deleteCupboard(@PathVariable(value = "id") int id) {
        cupboardService.deleteById(id);

        LOGGER.info("Delete cupboard by id - " + id);
        return "redirect:/";
    }
}