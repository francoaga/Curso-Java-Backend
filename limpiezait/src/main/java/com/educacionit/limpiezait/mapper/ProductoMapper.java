package com.educacionit.limpiezait.mapper;

import com.educacionit.limpiezait.dto.ProductoDTO;
import com.educacionit.limpiezait.mapper.interfaces.IProductoMapper;
import com.educacionit.limpiezait.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper implements IProductoMapper {

    @Override
    public Producto toEntity(ProductoDTO dto) {
        return Producto.builder()
                .nombre(dto.getNombre())
                .precio(dto.getPrecio())
                .descripcion(dto.getDescripcion())
                .urlFoto(dto.getUrlFoto())
                .build();
    }

    @Override
    public ProductoDTO toDTO(Producto producto) {
        return new ProductoDTO(producto);
    }
}
