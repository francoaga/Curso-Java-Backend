package com.educacionit.limpiezait.repository;

import com.educacionit.limpiezait.model.Producto;
import com.educacionit.limpiezait.repository.interfaces.IProductoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class ProductoRepository implements IProductoRepository {
    private final List<Producto> productos = new ArrayList<>();

    @Override
    public List<Producto> findAll() {
        return this.productos;
    }

    @Override
    public Optional<Producto> findBy(Long id) {
        return this.productos.stream()
                .filter(producto -> Objects.equals(producto.getId(), id))
                .findFirst();
    }

    @Override
    public Producto save(Producto producto) {
        Optional<Producto> productoOptional = findBy(producto.getId());

        if (productoOptional.isPresent()) {
            // Si el producto existe, lo editamos
            edit(productoOptional.get(), producto);
        } else {
            // Si el producto no existe, lo agregamos a la lista
            this.productos.add(producto);
        }

        return producto;
    }

    private void edit(Producto productoActual, Producto productoModificado) {
        productoActual.setNombre(productoModificado.getNombre());
        productoActual.setDescripcion(productoModificado.getDescripcion());
        productoActual.setPrecio(productoModificado.getPrecio());
        productoActual.setUrlFoto(productoModificado.getUrlFoto());
    }

    @Override
    public void delete(Long id) {
        this.productos.removeIf(producto -> Objects.equals(producto.getId(), id));
    }
}
