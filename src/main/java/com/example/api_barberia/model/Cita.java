package com.example.api_barberia.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * esta clase es la de las citas, representa la tabla "citas"
 * de la base de datos
 *
 * relacion: muchas citas le pertenecen a un barbero (N a 1)
 */
@Entity
@Table(name = "citas")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;

    @Column(name = "nombre_cliente", nullable = false)
    private String nombreCliente;

    // aca va el tipo de corte, ej: "Corte fade", "Perfilado de barba"
    @Column(nullable = false)
    private String servicio;

    // la fecha y la hora de la cita, en el json se escribe asi: "2026-12-20T15:30:00"
    // (tuve que buscar como se ponia la T esa pero asi funciona)
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    // el precio, va en pesos chilenos
    @Column(nullable = false)
    private Integer precio;

    // el lado N de la relacion, esto crea la columna id_barbero que es la
    // clave foranea en la tabla citas (la verdad no entiendo bien como pero asi se hace)
    @ManyToOne
    @JoinColumn(name = "id_barbero", nullable = false)
    private Barbero barbero;

    // ---------- getters y setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Barbero getBarbero() {
        return barbero;
    }

    public void setBarbero(Barbero barbero) {
        this.barbero = barbero;
    }
}
