package com.example.api_barberia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_barberia.model.Cita;

/**
 * igual que el BarberoRepository pero para la tabla de citas,
 * no tiene nada mas porque jpa ya nos da todo listo
 */
@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

}
