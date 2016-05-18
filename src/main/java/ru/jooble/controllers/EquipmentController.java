package ru.jooble.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jooble.domain.Cupboard;
import ru.jooble.domain.Equipment;
import ru.jooble.domain.TypeEquipmentEnum;
import ru.jooble.form.EquipmentForm;
import ru.jooble.service.CupboardService;
import ru.jooble.service.EquipmentService;
import ru.jooble.validator.EquipmentFromValidator;

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
    public String showPageSaveEquipment(@PathVariable(value = "id") String id, ModelMap model) {
        EquipmentForm equipmentForm = new EquipmentForm();
        equipmentForm.setCupboardId(id);
        model.addAttribute("types", TypeEquipmentEnum.values());
        model.addAttribute("equipmentForm", equipmentForm);
        return SAVE_EQUIPMENT_PAGE;
    }

    @RequestMapping(value = "/save/equipment/{id}", method = RequestMethod.GET)
    public String showPageUpdateEquipment(@PathVariable(value = "id") int id, ModelMap model) {
        model.addAttribute("types", TypeEquipmentEnum.values());
        model.addAttribute("equipmentForm", new EquipmentForm(equipmentService.getById(id)));
        return SAVE_EQUIPMENT_PAGE;
    }

    @RequestMapping(value = "/save/equipment", method = RequestMethod.POST)
    public String updateCupboard(@Validated EquipmentForm equipmentForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("types", TypeEquipmentEnum.values());
            return SAVE_EQUIPMENT_PAGE;
        }
        if ("".equals(equipmentForm.getId())) {
            Equipment equipment = getEquipment(equipmentForm);
            equipmentService.save(equipment);
        } else {
            Equipment equipment = getEquipment(equipmentForm);
            equipment.setId(Integer.parseInt(equipmentForm.getId()));
            equipmentService.update(equipment);
        }
        return "redirect:/view/cupboard/" + equipmentForm.getCupboardId();
    }

    private Equipment getEquipment(@Validated EquipmentForm equipmentForm) {
        Equipment equipment = new Equipment();
        equipment.setCupboard(cupboardService.getById(Integer.parseInt(equipmentForm.getCupboardId())));
        equipment.setType(TypeEquipmentEnum.valueOf(equipmentForm.getType()));
        equipment.setModel(equipmentForm.getModel());
        equipment.setInventoryNumber(Integer.parseInt(equipmentForm.getInventoryNumber()));
        return equipment;
    }

    @RequestMapping(value = "/delete/equipment/{id}", method = RequestMethod.POST)
    public String deleteEquipment(@PathVariable(value = "id") int id) {
        Equipment equipment = equipmentService.getById(id);
        equipmentService.deleteById(id);
        return "redirect:/view/cupboard/" + equipment.getCupboard().getId();
    }
}