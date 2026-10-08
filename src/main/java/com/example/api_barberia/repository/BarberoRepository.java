package com.example.api_barberia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_barberia.model.Barbero;

/**
 * esto es el repository de los barberos, como extiende de JpaRepository
 * ya tenemos todos los metodos sin escribir sql a mano:
 * findAll(), findById(id), save(objeto), deleteById(id), existsById(id)...
 * (al principio no entendia de donde salian esos metodos ja ja)
 */
@Repository
public interface BarberoRepository extends JpaRepository<Barbero, Long> {

}
