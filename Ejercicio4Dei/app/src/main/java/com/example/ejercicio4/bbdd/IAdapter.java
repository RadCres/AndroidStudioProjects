package com.example.ejercicio4.bbdd;

import java.util.List;

public interface IAdapter<T, K> {

    public T find(K key);
    public List<T> findAll();
    public void insert(T obj);
    public void delete(K key);
    public void update(T obj);


}
