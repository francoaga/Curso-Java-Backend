package com.educacionit.limpiezait.dto;

import com.educacionit.limpiezait.model.Producto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String urlFoto;

    public ProductoDTO(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.precio = producto.getPrecio();
        this.descripcion = producto.getDescripcion();
        this.urlFoto = producto.getUrlFoto();
    }
}
