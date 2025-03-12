package com.educacionit.limpiezait.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository <T, K>{
    List<T> findAll();
    Optional<T> findBy(K id);
    T save(T entity);
    void delete(K id);
}
