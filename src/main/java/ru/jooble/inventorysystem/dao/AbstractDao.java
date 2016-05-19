package ru.jooble.inventorysystem.dao;

import java.util.List;

public interface AbstractDao<T> {
    T getById(int id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);
}

