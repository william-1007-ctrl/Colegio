package com.example.demo.Controller;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import com.example.demo.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EstudianteController {
    @Autowired
    public EstudianteService estudianteService;



    @GetMapping("/listar")
    public List<Estudiante> listar(){
        return estudianteService.listar();
    }

    @PostMapping("/guardar")
    public Estudiante guardar(@RequestBody Estudiante estudiante){
        return estudianteService.guardar(estudiante);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable long id){
        estudianteService.eliminar(id);
    }

    @GetMapping("/buscar/{id}")
    public Optional<Estudiante> listarPorId(@PathVariable long id){
        return estudianteService.listarPorId(id);
    }

    @PutMapping("/actualizar/{id}")
    public Estudiante actualizar(@PathVariable long id, @RequestBody Estudiante estudiante) {
        return estudianteService.actualizar(id, estudiante);
    }



}
