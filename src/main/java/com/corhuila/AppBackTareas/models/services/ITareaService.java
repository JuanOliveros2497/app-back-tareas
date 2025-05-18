package com.corhuila.AppBackTareas.models.services;

import com.corhuila.AppBackTareas.models.entity.Tarea;
import java.util.List;
import java.util.Optional;

public interface ITareaService {

    List<Tarea> obtenerTodasTareas();
    Optional<Tarea> obtenerTareaPorId(Long id);
    Tarea crearTarea(Tarea tarea);
    Tarea actualizarTarea(Long id, Tarea tarea);
    void eliminarTarea(Long id);

    List<Tarea> obtenerTareasFavoritas();
    List<Tarea> obtenerTareasRealizadas();
    List<Tarea> obtenerTareasNoRealizadas();


}
