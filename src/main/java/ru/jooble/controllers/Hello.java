package ru.jooble.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.jooble.domain.Cupboard;
import ru.jooble.domain.Equipment;
import ru.jooble.domain.TypeEquipmentEnum;
import ru.jooble.service.CupboardService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class Hello {
    @Autowired
    CupboardService cupboardService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<Cupboard> equipments = cupboardService.getAll();
        model.addAttribute("cupboards", equipments);
        return "hello";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveCupboard(ModelMap model) {
        Cupboard cupboard = new Cupboard();
        List<Equipment> equipments = new ArrayList<>();
        Equipment equipment = new Equipment();
        equipment.setType(TypeEquipmentEnum.Server);
        equipment.setCupboard(cupboard);
        equipments.add(equipment);
        cupboard.setName("Шкаф");
        cupboard.setEquipments(equipments);
        cupboardService.save(cupboard);
        return "hello";
    }
}