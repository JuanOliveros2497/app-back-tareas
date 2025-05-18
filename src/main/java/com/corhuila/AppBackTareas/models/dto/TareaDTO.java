package com.corhuila.AppBackTareas.models.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TareaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private boolean esFavorita;
    private boolean estaRealizada;

    // Constructor vacío
    public TareaDTO() {
    }

    // Constructor con todos los campos
    public TareaDTO(Long id, String nombre, String descripcion, LocalDate fecha, LocalTime hora, boolean esFavorita, boolean estaRealizada) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.esFavorita = esFavorita;
        this.estaRealizada = estaRealizada;
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
        return esFavorita;
    }

    public void setEsFavorita(boolean esFavorita) {
        this.esFavorita = esFavorita;
    }

    public boolean isEstaRealizada() {
        return estaRealizada;
    }

    public void setEstaRealizada(boolean estaRealizada) {
        this.estaRealizada = estaRealizada;
    }
}