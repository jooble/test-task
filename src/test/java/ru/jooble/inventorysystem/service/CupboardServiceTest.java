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

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/test/resource/applicationContext.xml"})
public class CupboardServiceTest {

    @Autowired
    CupboardService cupboardService;

    @Before
    public void fillData() {
        for (int i = 1; i <= 10; i++) {
            Cupboard cupboard = new Cupboard();
            cupboard.setName("Test" + i);
            cupboardService.save(cupboard);
        }
    }

    @After
    public void cleanData() {
        List<Cupboard> cupboards = cupboardService.getAll();
        for (Cupboard cupboard : cupboards) {
            cupboardService.deleteById(cupboard.getId());
        }
    }

    @Test
    public void testGetById() {
        Cupboard cupboard = cupboardService.getById(5);
        Assert.assertEquals(cupboard.getId(), 5);
        Assert.assertEquals(cupboard.getName(), "Test5");
    }

    @Test
    public void testSaveCupboard() {
        Cupboard cupboard = new Cupboard();
        cupboard.setName("Test11");
        cupboardService.save(cupboard);
        Assert.assertEquals(cupboardService.getById(11).getId(), 11);
        Assert.assertEquals(cupboardService.getById(11).getName(), "Test11");
    }

    @Test
    public void testUpdateCupboard() {
        Cupboard cupboard = new Cupboard();
        cupboard.setId(4);
        cupboard.setName("Update4");
        cupboardService.update(cupboard);
        Assert.assertEquals(cupboardService.getById(4).getName(), "Update4");
    }

    @Test
    public void testGetAllCupboard() {
        List<Cupboard> cupboards = cupboardService.getAll();
        Assert.assertEquals(cupboards.size(), 10);
        Assert.assertEquals(cupboards.get(4).getName(), "Test4");
    }

    @Test
    public void testDeleteById() {
        cupboardService.deleteById(2);
        Assert.assertEquals(cupboardService.getAll().size(), 9);
    }
}