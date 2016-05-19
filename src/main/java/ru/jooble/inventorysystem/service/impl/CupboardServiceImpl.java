package ru.jooble.inventorysystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jooble.inventorysystem.dao.CupboardDao;
import ru.jooble.inventorysystem.domain.Cupboard;
import ru.jooble.inventorysystem.service.CupboardService;

import java.util.List;

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
        return cupboardDao.getAll();
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
