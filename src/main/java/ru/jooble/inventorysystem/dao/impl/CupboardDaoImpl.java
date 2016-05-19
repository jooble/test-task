package ru.jooble.inventorysystem.dao.impl;

import org.springframework.stereotype.Repository;
import ru.jooble.inventorysystem.dao.CupboardDao;
import ru.jooble.inventorysystem.domain.Cupboard;

import javax.annotation.PostConstruct;

@Repository
public class CupboardDaoImpl extends AbstractDaoImpl<Cupboard> implements CupboardDao {
    @PostConstruct
    public void init() {
        super.setType(Cupboard.class);
    }
}