package com.educacionit.limpiezait.repository.interfaces;

import com.educacionit.limpiezait.model.Producto;

import java.util.List;

public interface IProductoRepository extends IRepository<Producto, Long> {
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
