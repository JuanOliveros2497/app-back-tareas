package com.corhuila.AppBackTareas.controllers;

import com.corhuila.AppBackTareas.models.entity.Tarea;
import com.corhuila.AppBackTareas.models.services.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")  // Puedes restringir el origen si es necesario
public class TareaController {

    private final ITareaService tareaService;

    @Autowired
    public TareaController(ITareaService tareaService) {
        this.tareaService = tareaService;
    }

    // Obtener todas las tareas
    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTodasTareas() {
        List<Tarea> tareas = tareaService.obtenerTodasTareas();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    // Obtener tareas realizadas
    @GetMapping("/realizadas")
    public ResponseEntity<List<Tarea>> obtenerTareasRealizadas() {
        List<Tarea> tareasRealizadas = tareaService.obtenerTareasRealizadas();
        return new ResponseEntity<>(tareasRealizadas, HttpStatus.OK);
    }

    // Obtener tareas NO realizadas
    @GetMapping("/no-realizadas")
    public ResponseEntity<List<Tarea>> obtenerTareasNoRealizadas() {
        List<Tarea> tareasNoRealizadas = tareaService.obtenerTareasNoRealizadas();
        return new ResponseEntity<>(tareasNoRealizadas, HttpStatus.OK);
    }

    // Obtener tareas favoritas
    @GetMapping("/favoritas")
    public ResponseEntity<List<Tarea>> obtenerTareasFavoritas() {
        List<Tarea> tareasFavoritas = tareaService.obtenerTareasFavoritas();
        return new ResponseEntity<>(tareasFavoritas, HttpStatus.OK);
    }

    // Obtener una tarea por ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        Optional<Tarea> tarea = tareaService.obtenerTareaPorId(id);
        return tarea.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Crear una nueva tarea
    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    // Actualizar una tarea
    @PutMapping("/{id}")
    public ResponseEntity<Tarea> updateTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        try {
            Tarea tareaActualizada = tareaService.actualizarTarea(id, tarea);
            return new ResponseEntity<>(tareaActualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una tarea
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
