package com.corhuila.AppBackTareas.models.services.impl;

import com.corhuila.AppBackTareas.models.dao.ITareaRepository;
import com.corhuila.AppBackTareas.models.entity.Tarea;
import com.corhuila.AppBackTareas.models.services.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaServiceImpl implements ITareaService {

    private final ITareaRepository tareaRepository;

    @Autowired
    public TareaServiceImpl(ITareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public List<Tarea> obtenerTodasTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id);
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizarTarea(Long id, Tarea tarea) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("Tarea no encontrada");
        }
        tarea.setId(id);
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        if (!tareaRepository.existsById(id)) {
            throw new RuntimeException("Tarea no encontrada");
        }
        tareaRepository.deleteById(id);
    }

    @Override
    public List<Tarea> obtenerTareasFavoritas() {
        return tareaRepository.obtenerTareasFavoritas();
    }

    @Override
    public List<Tarea> obtenerTareasRealizadas() {
        return tareaRepository.obtenerTareasRealizadas();
    }

    @Override
    public List<Tarea> obtenerTareasNoRealizadas() {
        return tareaRepository.findByRealizadaFalse();
    }

}
