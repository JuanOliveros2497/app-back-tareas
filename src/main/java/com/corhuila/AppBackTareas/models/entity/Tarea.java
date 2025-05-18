package com.corhuila.AppBackTareas.models.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "hora")
    private LocalTime hora;
    @Column(name = "favorita")
    private boolean favorita = false;
    @Column(name = "realizada")
    private boolean realizada = false;  // Cambié el nombre de 'estaRealizada' a 'realizado'

    // Constructor vacío (obligatorio para JPA)
    public Tarea() {
    }

    // Constructor con todos los campos
    public Tarea(Long id, String nombre, String descripcion, LocalDate fecha, LocalTime hora, boolean favorita, boolean realizada) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.favorita = favorita;
        this.realizada = realizada;
    }

    // Getters y Setters
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isEsFavorita() {
        return favorita;
    }

    public void setEsFavorita(boolean esFavorita) {
        this.favorita = esFavorita;
    }

    public boolean isRealizada() {  // Actualicé el getter
        return realizada;
    }

    public void setRealizada(boolean realizado) {  // Actualicé el setter
        this.realizada = realizado;
    }
}
