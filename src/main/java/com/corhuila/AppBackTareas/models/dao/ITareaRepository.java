package com.corhuila.AppBackTareas.models.dao;

import com.corhuila.AppBackTareas.models.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITareaRepository extends JpaRepository<Tarea, Long> {

    // Métodos adicionales personalizados
    @Query("SELECT t FROM Tarea t WHERE t.favorita = true")
    List<Tarea> obtenerTareasFavoritas();

    @Query("SELECT t FROM Tarea t WHERE t.realizada = true")
    List<Tarea> obtenerTareasRealizadas();
    List<Tarea> findByFavoritaTrue();
    List<Tarea> findByRealizadaTrue();
    List<Tarea> findByRealizadaFalse();

}
