package com.example.eventosfuturos.service;

public interface TaskCompleted<T> {
    public void onTaskCompleted(T t);
}
