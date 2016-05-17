package ru.jooble.dao.impl;

import org.springframework.stereotype.Repository;
import ru.jooble.dao.EquipmentDao;
import ru.jooble.domain.Equipment;

import javax.annotation.PostConstruct;

@Repository
public class EquipmentDaoImpl extends AbstractDaoImpl<Equipment> implements EquipmentDao {
    @PostConstruct
    public void init() {
        super.setType(Equipment.class);
    }
}