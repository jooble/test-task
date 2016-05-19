package ru.jooble.inventorysystem.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.inventorysystem.domain.Cupboard;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CupboardServiceTest {

    @Autowired
    SessionFactory sessionFactory;

    private Session session;

    @Test
    @Transactional
    @Rollback
    public void saveCupboardTest() {
        session = sessionFactory.getCurrentSession();
        Cupboard cupboard = new Cupboard();
        cupboard.setName("Шкаф");
        session.save(cupboard);
        Assert.assertTrue(cupboard.getId() == 1);
    }

    //JDBC TEMPLATE SELECT TEST EXAMPLE
  /*  @Test
    @Rollback
    public void getAllCupboardTest() {
        List<Cupboard> cupboardList = sessionFactory.getAll();
        Assert.assertNotNull(cupboardList);
        for (Cupboard cupboard : sessionFactory.getAll()) {
            System.out.println("Cupboard id: " + cupboard.getId() + " Cupboard name : " + cupboard.getName());
        }

    }*/

    //JDBC TEMPLATE DELETE TEST EXAMPLE
   /* @Test
    @Rollback
    public void deleteByIdCupboardTest() {
        Assert.assertTrue(sessionFactory.deleteById(5));
    }*/
}