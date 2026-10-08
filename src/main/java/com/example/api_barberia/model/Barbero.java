package com.example.api_barberia.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * esta clase es la de los barberos, representa la tabla "barberos"
 * de la base de datos, cada atributo es una columna
 *
 * relacion: un barbero puede tener muchas citas (1 a N)
 */
@Entity
@Table(name = "barberos")
public class Barbero {

    // esta es como la clave principal, el numero lo pone sola la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_barbero")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String especialidad;

    @Column(nullable = false)
    private String telefono;

    // esto es el lado 1 de la relacion, el mappedBy es porque la clave foranea
    // esta en la tabla de citas, cascade all es por si borras el barbero se borran
    // sus citas tambien, y lo del jsonignore es para que no se repitan las citas
    // dentro del barbero porque me pasaba que el json se rompia (algo de ciclo infinito)
    @JsonIgnore
    @OneToMany(mappedBy = "barbero", cascade = CascadeType.ALL)
    private List<Cita> citas = new ArrayList<>();

    // ---------- getters y setters ----------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
