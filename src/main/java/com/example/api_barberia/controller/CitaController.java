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

import com.example.api_barberia.model.Cita;
import com.example.api_barberia.service.CitaService;

/**
 * este es el controller de las citas, recibe las peticiones HTTP
 * (las que mando desde Postman), le pasa todo al service y devuelve
 * la respuesta con el codigo que corresponda
 *
 * todas las rutas empiezan con /api/citas
 */
@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    // GET /api/citas -> lista todas (devuelve 200 OK)
    @GetMapping
    public ResponseEntity<?> listar() {
        List<Cita> lista = citaService.listar();
        return ResponseEntity.ok(lista);
    }

    // GET /api/citas/1 -> busca una por id (200 si existe, 404 si no)
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Cita cita = citaService.buscarPorId(id);
        if (cita == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una cita con id " + id);
        }
        return ResponseEntity.ok(cita);
    }

    // POST /api/citas -> crea una nueva (201 si salio bien, 400 si hay error)
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Cita cita) {
        String error = citaService.validar(cita);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        Cita creado = citaService.crear(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/citas/1 -> actualiza, puede devolver 200, 404 o 400
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Cita cita) {
        if (citaService.buscarPorId(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una cita con id " + id);
        }
        String error = citaService.validar(cita);
        if (error != null) {
            return ResponseEntity.badRequest().body(error);
        }
        Cita actualizado = citaService.actualizar(id, cita);
        return ResponseEntity.ok(actualizado);
    }

    // DELETE /api/citas/1 -> elimina (204 si se borro, 404 si no existia)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = citaService.eliminar(id);
        if (!eliminado) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe una cita con id " + id);
        }
        return ResponseEntity.noContent().build();
    }
}
