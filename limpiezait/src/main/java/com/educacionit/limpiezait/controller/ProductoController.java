package com.educacionit.limpiezait.controller;

import com.educacionit.limpiezait.dto.ProductoDTO;
import com.educacionit.limpiezait.service.interfaces.IProductoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/productos")
public class ProductoController {
    private final IProductoService productoService;

    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoBy(@PathVariable Long id) {
        return new ResponseEntity<>(this.productoService.getBy(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crearProducto(@RequestBody ProductoDTO dto) {
        return new ResponseEntity<>(this.productoService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long id, @RequestBody ProductoDTO dto) {
        return new ResponseEntity<>(this.productoService.edit(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
        this.productoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
