package java.ru.jooble.inventorysystem.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.jooble.inventorysystem.domain.Cupboard;
import ru.jooble.inventorysystem.service.CupboardService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvc-config.xml", "classpath:application-context.xml"})
public class CupboardServiceTest {

    @Autowired
    private CupboardService cupboardService;

    @Test
    @Rollback
    public void saveCupboardTest() {
        Cupboard cupboard = new Cupboard();
        cupboard.setName("Шкаф");
        Assert.assertTrue(cupboardService.save(cupboard));
    }

    //JDBC TEMPLATE SELECT TEST EXAMPLE
    @Test
    @Rollback
    public void getAllCupboardTest() {
        List<Cupboard> cupboardList = cupboardService.getAll();
        Assert.assertNotNull(cupboardList);
        for (Cupboard cupboard : cupboardService.getAll()) {
            System.out.println("Cupboard id: "+ cupboard.getId() + " Cupboard name : "+ cupboard.getName());
        }

    }

    //JDBC TEMPLATE DELETE TEST EXAMPLE
    @Test
    @Rollback
    public void deleteByIdCupboardTest() {
        Assert.assertTrue(cupboardService.deleteById(5));
    }
}