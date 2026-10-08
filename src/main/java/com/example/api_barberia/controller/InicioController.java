package com.example.api_barberia.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * esta es la pagina que sale al abrir http://localhost:8080, ahi muestra
 * las rutas que tiene la api, lo hice porque sino salia la pagina de
 * error esa de "Whitelabel Error Page" y se veia feo
 */
@RestController
public class InicioController {

    @GetMapping("/")
    public ResponseEntity<?> inicio() {
        // LinkedHashMap es como un mapa pero mantiene el orden en que vas agregando
        Map<String, String> rutas = new LinkedHashMap<>();
        rutas.put("Listar barberos", "GET    /api/barberos");
        rutas.put("Buscar barbero", "GET    /api/barberos/{id}");
        rutas.put("Crear barbero", "POST   /api/barberos");
        rutas.put("Modificar barbero", "PUT    /api/barberos/{id}");
        rutas.put("Eliminar barbero", "DELETE /api/barberos/{id}");
        rutas.put("Listar citas", "GET    /api/citas");
        rutas.put("Buscar cita", "GET    /api/citas/{id}");
        rutas.put("Crear cita", "POST   /api/citas");
        rutas.put("Modificar cita", "PUT    /api/citas/{id}");
        rutas.put("Eliminar cita", "DELETE /api/citas/{id}");
        rutas.put("Ver base de datos", "http://localhost:8080/h2-console");

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("mensaje", "API Barberia funcionando");
        respuesta.put("rutas", rutas);
        return ResponseEntity.ok(respuesta);
    }
}
