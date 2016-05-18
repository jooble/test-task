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
import ru.jooble.domain.Equipment;
import ru.jooble.domain.TypeEquipmentEnum;
import ru.jooble.service.CupboardService;
import ru.jooble.service.EquipmentService;
import ru.jooble.validator.EquipmentFromValidator;

import javax.validation.Valid;

@Controller
public class EquipmentController {
    private static final String SAVE_EQUIPMENT_PAGE = "saveEquipment";
    private static final String ALL_EQUIPMENT_PAGE = "allEquipmentCupboard";

    @Autowired
    EquipmentFromValidator equipmentFromValidator;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    CupboardService cupboardService;

    @InitBinder("equipment")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(equipmentFromValidator);
    }

    @RequestMapping(value = "/view/cupboard/{id}", method = RequestMethod.GET)
    public String showPageAllEquipmentCupboard(@PathVariable(value = "id") int id, ModelMap model) {
        Cupboard cupboard = cupboardService.getById(id);
        cupboard.setEquipments(equipmentService.getAllInCupboardId(id));
        model.addAttribute("cupboard", cupboard);
        return ALL_EQUIPMENT_PAGE;
    }

    @RequestMapping(value = "/cupboard/{id}/save/equipment", method = RequestMethod.GET)
    public String showPageSaveEquipment(@PathVariable(value = "id") int id, ModelMap model) {
        Equipment equipment = new Equipment();
        equipment.setCupboard(cupboardService.getById(id));
        model.addAttribute("types", TypeEquipmentEnum.values());
        model.addAttribute("equipment", equipment);
        return SAVE_EQUIPMENT_PAGE;
    }

    @RequestMapping(value = "/save/equipment/{id}", method = RequestMethod.GET)
    public String showPageUpdateEquipment(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("types", TypeEquipmentEnum.values());
        model.addAttribute("equipment", equipmentService.getById(id));
        return SAVE_EQUIPMENT_PAGE;
    }

    @RequestMapping(value = "/save/equipment", method = RequestMethod.POST)
    public String updateCupboard(Equipment equipment, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", TypeEquipmentEnum.values());
            return SAVE_EQUIPMENT_PAGE;
        }
        if (equipment.getId() == 0) {
            equipmentService.save(equipment);
        } else {
            equipmentService.update(equipment);
        }
        return "redirect:/view/cupboard/" + equipment.getCupboard().getId();
    }

    @RequestMapping(value = "/delete/equipment/{id}", method = RequestMethod.POST)
    public String deleteEquipment(@PathVariable(value = "id") int id) {
        Equipment equipment = equipmentService.getById(id);
        equipmentService.deleteById(id);
        return "redirect:/view/cupboard/" + equipment.getCupboard().getId();
    }
}