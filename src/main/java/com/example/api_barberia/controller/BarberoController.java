package com.example.api_barberia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_barberia.model.Barbero;
import com.example.api_barberia.service.BarberoService;

/**
 * este controller recibe las peticiones HTTP (las que mando desde Postman),
 * le pasa todo al service y devuelve la respuesta con el codigo que corresponda
 *
 * todas las rutas empiezan con /api/barberos
 */
@RestController
@RequestMapping("/api/barberos")
public class BarberoController {

    private final BarberoService barberoService;

    public BarberoController(BarberoService barberoService) {
        this.barberoService = barberoService;
    }

    // GET /api/barberos -> lista todos (devuelve 200 OK)
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Barbero> lista = barberoService.listar();
        return ResponseEntity.ok(lista);
    }

    // GET /api/barberos/1 -> busca uno por id (200 si existe, 404 si no)
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Barbero barbero = barberoService.buscarPorId(id);
        if (barbero == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un barbero con id " + id);
        }
        return ResponseEntity.ok(barbero);
    }

    // POST /api/barberos -> crea uno nuevo (201 si salio bien, 400 si hay error)
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Barbero barbero) {
        String error = barberoService.validar(barbero);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        Barbero creado = barberoService.crear(barbero);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/barberos/1 -> actualiza, puede devolver 200, 404 o 400
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Barbero barbero) {
        if (barberoService.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un barbero con id " + id);
        }
        String error = barberoService.validar(barbero);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        Barbero actualizado = barberoService.actualizar(id, barbero);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE /api/barberos/1 -> elimina (204 si se borro, 404 si no existia)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = barberoService.eliminar(id);
        if (!eliminado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un barbero con id " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
