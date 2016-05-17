package ru.jooble.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.dao.CupboardDao;
import ru.jooble.domain.Cupboard;
import ru.jooble.domain.Equipment;
import ru.jooble.domain.TypeEquipmentEnum;
import ru.jooble.service.CupboardService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CupboardServiceImpl implements CupboardService {
    @Autowired
    CupboardDao cupboardDao;

    @Override
    @Transactional(readOnly = true)
    public Cupboard getById(int id) {
        return cupboardDao.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cupboard> getAll() {
        List<Cupboard> cupboards = cupboardDao.getAll();

        for (Cupboard cupboard : cupboards) {
            Map<TypeEquipmentEnum, List<Equipment>> equipmentMap = new HashMap<>();
            List<Equipment> typeDiskArray = new ArrayList<>();
            List<Equipment> typeServer = new ArrayList<>();
            List<Equipment> typeUninterruptiblePowerSupply = new ArrayList<>();

            for (Equipment equipment : cupboard.getEquipments()) {
                if (equipment.getType().equals(TypeEquipmentEnum.DiskArray)) {
                    typeDiskArray.add(equipment);
                }
                if (equipment.getType().equals(TypeEquipmentEnum.Server)) {
                    typeServer.add(equipment);
                }
                if (equipment.getType().equals(TypeEquipmentEnum.UninterruptiblePowerSupply)) {
                    typeUninterruptiblePowerSupply.add(equipment);
                }
            }
            equipmentMap.put(TypeEquipmentEnum.DiskArray, typeDiskArray);
            equipmentMap.put(TypeEquipmentEnum.Server, typeServer);
            equipmentMap.put(TypeEquipmentEnum.UninterruptiblePowerSupply, typeUninterruptiblePowerSupply);
            cupboard.setEquipmentMap(equipmentMap);
        }
        return cupboards;
    }

    @Override
    @Transactional
    public void save(Cupboard cupboard) {
        cupboardDao.save(cupboard);
    }

    @Override
    @Transactional
    public void update(Cupboard cupboard) {
        cupboardDao.update(cupboard);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Cupboard cupboard = cupboardDao.getById(id);
        cupboardDao.delete(cupboard);
    }
}
