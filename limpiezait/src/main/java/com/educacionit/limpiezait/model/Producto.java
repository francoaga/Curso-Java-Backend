package com.educacionit.limpiezait.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Producto {
    private static long idContador = 1;
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String urlFoto;

    private Producto(Long id, String nombre, Double precio, String descripcion, String urlFoto) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }

    // Método estático para obtener un Builder personalizado
    public static ProductoBuilder builder() {
        return new ProductoBuilder().id(idContador++);
    }
}
