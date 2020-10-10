package com.online.cinema.dao;

import java.util.List;

public interface GenericDao<T> {
    T add(T t);

    List<T> getAll();

    T get(Long id);

    void update(T entity);
}
