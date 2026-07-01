package com.soeu.services.interfaces;

import java.util.List;

public interface Service<T> {
    public void create(T obj);
    public List<T> read();
    public void update(T obj);
    public void delete(T obj);
}
