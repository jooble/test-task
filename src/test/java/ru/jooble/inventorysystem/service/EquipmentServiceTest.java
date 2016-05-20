/*
package ru.jooble.inventorysystem.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.jooble.inventorysystem.domain.Cupboard;
import ru.jooble.inventorysystem.domain.Equipment;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resource/applicationContext.xml"})
public class EquipmentServiceTest {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    CupboardService cupboardService;

    @Before
    public void fillData() {
        Cupboard cupboard1 = new Cupboard();
        cupboard1.setName("Test1");
        cupboardService.save(cupboard1);

        for (int i = 1; i <= 10; i++) {
            Equipment equipment = new Equipment();
            equipment.setCupboard(cupboard1);
            equipment.setModel("Test1Equipment" + i);
            equipment.setInventoryNumber("Test1Equipment" + i);
            equipmentService.save(equipment);
        }

        Cupboard cupboard2 = new Cupboard();
        cupboard1.setName("Test2");
        cupboardService.save(cupboard2);

        for (int i = 1; i <= 10; i++) {
            Equipment equipment = new Equipment();
            equipment.setCupboard(cupboard2);
            equipment.setModel("Cubpoard2Equipment" + i);
            equipment.setInventoryNumber("Cubpoard2Equipment" + i);
            equipmentService.save(equipment);
        }
    }

    @After
    public void cleanData() {
        List<Equipment> equipments = equipmentService.getAll();
        for (Equipment equipment : equipments) {
            equipmentService.deleteById(equipment.getId());
        }
    }

    @Test
    public void testGetById() {
        Equipment equipment = equipmentService.getById(5);
        Assert.assertEquals(equipment.getId(), 5);
        Assert.assertEquals(equipment.get(), 5);

    }

    @Test*/
/**//*

    public void testSaveCupboard() {
        Cupboard cupboard = new Cupboard();
        cupboard.setName("Test11");
        equipmentService.save(cupboard);
        Assert.assertEquals(equipmentService.getById(11).getId(), 11);
        Assert.assertEquals(equipmentService.getById(11).getName(), "Test11");
    }

    @Test
    public void testUpdateCupboard() {
        Cupboard cupboard = new Cupboard();
        cupboard.setId(4);
        cupboard.setName("Update4");
        equipmentService.update(cupboard);
        Assert.assertEquals(equipmentService.getById(4).getName(), "Update4");
    }

    @Test
    public void testGetAllCupboard() {
        List<Cupboard> cupboards = equipmentService.getAll();
        Assert.assertEquals(cupboards.size(), 10);
        Assert.assertEquals(cupboards.get(4).getName(), "Test4");
    }

    @Test
    public void testDeleteById() {
        equipmentService.deleteById(2);
        Assert.assertEquals(equipmentService.getAll().size(), 9);
    }
}*/
