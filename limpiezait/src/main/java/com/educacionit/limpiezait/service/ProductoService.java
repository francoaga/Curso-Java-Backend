package com.educacionit.limpiezait.service;

import com.educacionit.limpiezait.dto.ProductoDTO;
import com.educacionit.limpiezait.mapper.interfaces.IProductoMapper;
import com.educacionit.limpiezait.model.Producto;
import com.educacionit.limpiezait.repository.interfaces.IProductoRepository;
import com.educacionit.limpiezait.service.interfaces.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductoService implements IProductoService {
    private final IProductoRepository productoRepository;
    private final IProductoMapper productoMapper;

    @Override
    public ProductoDTO getBy(Long id) {
        return this.productoRepository.findBy(id)
                .map(productoMapper::toDTO)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<ProductoDTO> getAll() {
        return this.productoRepository.findAll().stream()
                .map(productoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) {
        Producto producto = productoMapper.toEntity(productoDTO);
        Producto productoGuardado = this.productoRepository.save(producto);
        return productoMapper.toDTO(productoGuardado);
    }

    @Override
    public void delete(Long id) {
        this.productoRepository.delete(id);
    }

    @Override
    public ProductoDTO edit(Long id, ProductoDTO productoDTO) {
        //Obtengo el producto existente
        Producto productoExistente  = this.productoRepository.findBy(id)
                                        .orElseThrow(NoSuchElementException::new);

        // Actualizo los campos del Producto existente con los valores del DTO
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setDescripcion(productoDTO.getDescripcion());
        productoExistente.setPrecio(productoDTO.getPrecio());
        productoExistente.setUrlFoto(productoDTO.getUrlFoto());

        // Convierto el Producto editado a ProductoDTO
        return productoMapper.toDTO(productoExistente);
    }
}
