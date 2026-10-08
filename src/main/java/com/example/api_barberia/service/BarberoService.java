package com.example.api_barberia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api_barberia.model.Barbero;
import com.example.api_barberia.repository.BarberoRepository;

/**
 * aqui va la parte del service de los barberos, aqui esta la logica:
 * revisa que los datos esten bien y le pide al repository que guarde,
 * busque o elimine
 */
@Service
public class BarberoService {

    private final BarberoRepository barberoRepository;

    // aca spring nos pasa el repository ya listo para usar, creo que esto
    // se llama inyeccion por constructor
    public BarberoService(BarberoRepository barberoRepository) {
        this.barberoRepository = barberoRepository;
    }

    public List<Barbero> listar() {
        return barberoRepository.findAll();
    }

    // esto busca el barbero y si no esta pues devuelve null
    public Barbero buscarPorId(Long id) {
        return barberoRepository.findById(id).orElse(null);
    }

    // aqui revisa que los datos esten bien, si algo falta devuelve un mensaje
    // de error, y si todo esta ok devuelve null (se que null raro pero es asi)
    public String validar(Barbero barbero) {
        if (barbero.getNombre() == null || barbero.getNombre().isBlank()) {
            return "El nombre es obligatorio";
        }
        if (barbero.getTelefono() == null || barbero.getTelefono().isBlank()) {
            return "El telefono es obligatorio";
        }
        if (barbero.getTelefono().length() < 8) {
            return "El telefono debe tener al menos 8 caracteres";
        }
        return null;
    }

    public Barbero crear(Barbero barbero) {
        barbero.setId(null); // el id lo pone la base de datos sola, por eso lo dejamos vacio
        return barberoRepository.save(barbero);
    }

    // devuelve el barbero ya actualizado, o null si no existia
    public Barbero actualizar(Long id, Barbero datosNuevos) {
        Barbero existente = buscarPorId(id);
        if (existente == null) {
            return null;
        }
        existente.setNombre(datosNuevos.getNombre());
        existente.setEspecialidad(datosNuevos.getEspecialidad());
        existente.setTelefono(datosNuevos.getTelefono());
        return barberoRepository.save(existente);
    }

    // devuelve true si se pudo borrar, false es porque no existia ese id
    public boolean eliminar(Long id) {
        if (!barberoRepository.existsById(id)) {
            return false;
        }
        barberoRepository.deleteById(id);
        return true;
    }
}
