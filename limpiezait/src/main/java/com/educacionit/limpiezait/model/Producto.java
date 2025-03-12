package com.educacionit.limpiezait.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Producto {
    private static long idContador = 1;
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
    private String urlFoto;

    public Producto() {
        this.id = idContador++;
    }

    public Producto(String nombre, Double precio, String descripcion, String urlFoto) {
        this();
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlFoto = urlFoto;
    }
}
