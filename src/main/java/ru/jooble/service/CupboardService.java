package ru.jooble.service;

import ru.jooble.domain.Cupboard;

import java.util.List;

public interface CupboardService {
    Cupboard getById(int id);

    List<Cupboard> getAll();

    void save(Cupboard cupboard);

    void update(Cupboard cupboard);

    void deleteById(int id);
}
