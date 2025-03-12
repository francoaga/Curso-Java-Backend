package com.educacionit.limpiezait.repository;

import com.educacionit.limpiezait.model.Producto;
import com.educacionit.limpiezait.repository.interfaces.IProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductoRepository implements IProductoRepository {
    private final List<Producto> productos = new ArrayList<>();

    @Override
    public List<Producto> findAll() {
        return List.of();
    }

    @Override
    public Optional<Producto> findBy(Long id) {
        return Optional.empty();
    }

    @Override
    public Producto save(Producto entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
