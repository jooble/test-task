package ru.jooble.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.jooble.dao.EquipmentDao;
import ru.jooble.domain.Equipment;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class EquipmentDaoImpl extends AbstractDaoImpl<Equipment> implements EquipmentDao {
    @PostConstruct
    public void init() {
        super.setType(Equipment.class);
    }


    @Override
    public List<Equipment> getAllInCupboardId(int id) {
        return getSessionFactory().getCurrentSession().createCriteria(Equipment.class)
                .add(Restrictions.eq("cupboard.id", id)).list();

    }
}