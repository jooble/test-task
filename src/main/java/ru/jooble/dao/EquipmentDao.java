package ru.jooble.dao;

import ru.jooble.domain.Equipment;

import java.util.List;

public interface EquipmentDao extends AbstractDao<Equipment> {

    List getAllInCupboardId(int id);
}
