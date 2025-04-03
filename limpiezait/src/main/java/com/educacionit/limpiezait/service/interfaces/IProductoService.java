package com.educacionit.limpiezait.service.interfaces;

import com.educacionit.limpiezait.dto.ProductoDTO;

import java.util.List;

public interface IProductoService extends IService <ProductoDTO, Long>{
    List<ProductoDTO> getByNombreContaining(String nombre);
}
