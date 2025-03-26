package com.example.demo.Service;

import com.example.demo.Model.Estudiante;
import com.example.demo.Repository.EstudianteRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    public EstudianteRepository estudianteRepository;

    //listar estudiantes
    public List<Estudiante> listar(){
        return estudianteRepository.findAll();
    }

    //guardar estudiante
    public Estudiante guardar(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
    //eliminar

    public void eliminar(long id){
        estudianteRepository.deleteById(id);
    }

    //listar por id
    public Optional<Estudiante> listarPorId(long id){
        return estudianteRepository.findById(id);
    }

    //editar
    public Estudiante actualizar(long id, Estudiante estudiante) {
        if (estudianteRepository.existsById(id)) {
            estudiante.setId(id);
            return estudianteRepository.save(estudiante);
        } else {
            throw new RuntimeException("Id no asignada");
        }
    }
}
