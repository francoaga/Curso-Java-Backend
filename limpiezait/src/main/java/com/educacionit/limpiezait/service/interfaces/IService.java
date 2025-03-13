package com.educacionit.limpiezait.service.interfaces;

import java.util.List;

public interface IService <T, K>{
    T getBy(Long id);
    List<T> getAll();
    T save(T entity);
    void delete(K id);
    T edit(K id, T entity);
}
