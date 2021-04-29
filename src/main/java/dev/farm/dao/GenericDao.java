package dev.farm.dao;

import java.util.ArrayList;

public interface GenericDao <T> {
    ArrayList<T> getAll();
    T getById(int id);
    void insert(T t);
    void update(T t);
    void delete(T t);
}
