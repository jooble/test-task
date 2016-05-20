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
    public void testInject() {
        Assert.assertNotNull(equipmentService);
        Assert.assertNotNull(cupboardService);
    }

    @Test
    public void testGetAllCriteriaCupboardId1() {
        List<Equipment> equipments = equipmentService.getAllCriteriaCupboardId(3);
        Assert.assertEquals(equipments.size(), 10);

        for (Equipment equipment : equipments) {
            Assert.assertEquals(3, equipment.getCupboard().getId());
        }
    }
}