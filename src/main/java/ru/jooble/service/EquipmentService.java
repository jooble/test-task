package ru.jooble.service;

import ru.jooble.domain.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment getById(int id);

    List<Equipment> getAll();

    List getAllInCupboardId(int id);

    void save(Equipment equipment);

    void update(Equipment equipment);

    void deleteById(int id);
}
