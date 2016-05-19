package ru.jooble.inventorysystem.dao;

import ru.jooble.inventorysystem.domain.Equipment;

import java.util.List;

public interface EquipmentDao extends AbstractDao<Equipment> {

    List getAllInCupboardId(int id);
}
