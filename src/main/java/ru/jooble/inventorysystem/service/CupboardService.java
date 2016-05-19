package ru.jooble.inventorysystem.service;

import ru.jooble.inventorysystem.domain.Cupboard;

import java.util.List;

public interface CupboardService {
    Cupboard getById(int id);

    List<Cupboard> getAll();

    void save(Cupboard cupboard);

    void update(Cupboard cupboard);

    void deleteById(int id);
}
