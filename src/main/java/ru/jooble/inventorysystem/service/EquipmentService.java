package ru.jooble.inventorysystem.service;

import ru.jooble.inventorysystem.domain.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment getById(int id);

    List<Equipment> getAll();

    List getAllCriteriaCupboardId(int id);

    void save(Equipment equipment);

    void update(Equipment equipment);

    void deleteById(int id);
}
