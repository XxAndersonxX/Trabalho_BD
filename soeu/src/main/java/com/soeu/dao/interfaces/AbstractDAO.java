package com.soeu.dao.interfaces;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractDAO<T> implements EntityDAO<T>{

    protected Connection conn;

    public AbstractDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(T obj){
        throw new UnsupportedOperationException(
            "Insert não implementado"
        );
    }

    @Override
    public void update(T obj){
        throw new UnsupportedOperationException(
            "Update não implementado"
        );
    }

    @Override
    public void deleteById(Integer id){
        throw new UnsupportedOperationException(
            "Delete não implementado"
        );
    }

    @Override
    public T findById(Integer id){
        throw new UnsupportedOperationException(
            "FindById não implementado"
        );
    }

    @Override
    public List<T> findAllById(Integer id){
        throw new UnsupportedOperationException(
            "FindAllById não implementado"
        );
    }
}