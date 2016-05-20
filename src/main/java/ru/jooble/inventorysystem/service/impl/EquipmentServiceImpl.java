package ru.jooble.inventorysystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.inventorysystem.dao.EquipmentDao;
import ru.jooble.inventorysystem.domain.Equipment;
import ru.jooble.inventorysystem.service.EquipmentService;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentDao equipmentDao;

    @Override
    @Transactional(readOnly = true)
    public Equipment getById(int id) {
        return equipmentDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Equipment> getAll() {
        return equipmentDao.getAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List getAllCriteriaCupboardId(int id) {
        return equipmentDao.getAllInCupboardId(id);
    }

    @Override
    @Transactional
    public void save(Equipment equipment) {
        equipmentDao.save(equipment);
    }

    @Override
    @Transactional
    public void update(Equipment equipment) {
        equipmentDao.update(equipment);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Equipment equipment = equipmentDao.getById(id);
        equipmentDao.delete(equipment);
    }
}
