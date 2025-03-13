package com.educacionit.limpiezait.config;

import com.educacionit.limpiezait.model.Producto;
import com.educacionit.limpiezait.repository.ProductoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Configuration
public class DataLoader {

    @Value("${app.load-test-data:false}")
    private boolean loadTestData;

    private final ResourceLoader resourceLoader;

    public DataLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public CommandLineRunner loadData(ProductoRepository productoRepository) {
        return args -> {
            if(loadTestData) {
                try {
                    // Cargar datos desde un archivo JSON
                    List<Producto> productosDePrueba = cargarProductos();

                    // Guardar los productos en el repositorio
                    agregarProductosDePrueba(productoRepository, productosDePrueba);
                    log.info("✅ Datos de prueba cargados correctamente.");
                } catch (IOException e) {
                    log.error("❌ Error al cargar datos de prueba desde JSON: {}", e.getMessage());
                }
            } else {
                log.info("❌ Carga de datos de prueba deshabilitada.");
            }
        };
    }

    private List<Producto> cargarProductos() throws IOException{
        // Cargamos el archivo JSON desde el classpath
        Resource resource = resourceLoader.getResource("classpath:data/productos.json");

        try(InputStream inputStream = resource.getInputStream()) {
            // Parseamos el JSON a una lista de Producto
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, new TypeReference<List<Producto>>() {});
        }
    }

    private void agregarProductosDePrueba(ProductoRepository productoRepository, List<Producto> productosDePrueba) {
        productosDePrueba.forEach(productoRepository::save);
    }
}
