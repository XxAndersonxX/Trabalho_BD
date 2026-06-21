package com.soeu.dao.interfaces;

import java.util.List;

public interface EntityDAO<T> {
    void insert(T obj);
    void update(T obj);
    void deleteById(Integer id);
    T findById(Integer id);
    List<T> findAll();
}
