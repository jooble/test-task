package ru.jooble.inventorysystem.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.jooble.inventorysystem.dao.AbstractDao;

import java.util.List;

public class AbstractDaoImpl<T> implements AbstractDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    @Override
    public T getById(int id) {
        return (T) sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void save(Object emp) {
        sessionFactory.getCurrentSession().save(emp);
    }

    @Override
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(type).list();
    }

    @Override
    public void update(Object emp) {
        sessionFactory.getCurrentSession().update(emp);
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

}
