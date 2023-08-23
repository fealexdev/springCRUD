package com.example.springcrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcrud.exception.ResourceNotFoundException;
import com.example.springcrud.model.Empregado;
import com.example.springcrud.repository.EmpregadoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmpregadoController {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @GetMapping("/empregados")
    public List<Empregado> getAllEmployees(){
        return empregadoRepository.findAll();
    }

    @PostMapping("/empregados")
    public Empregado criarEmpregado(@RequestBody Empregado empregado) {
        return empregadoRepository.save(empregado);
    }

    @GetMapping("/empregados/{id}")
    public ResponseEntity<Empregado> getEmpregadoById(@PathVariable Long id) {
        Empregado empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado com o id " + id + "não existe"));
        return ResponseEntity.ok(empregado);
    }

    @PutMapping("/empregados/{id}")
    public ResponseEntity<Empregado> updateEmpregado(@PathVariable Long id, @RequestBody Empregado detalhesEmpregado){
        Empregado empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        empregado.setNome(detalhesEmpregado.getNome());
        empregado.setCargo(detalhesEmpregado.getCargo());
        empregado.setEmailId(detalhesEmpregado.getEmailId());

        Empregado empregadoAtualizado = empregadoRepository.save(empregado);
        return ResponseEntity.ok(empregadoAtualizado);
    }

    @DeleteMapping("/empregados/{id}")
    public ResponseEntity<Map<String, Boolean>> deletarEmpregado(@PathVariable Long id){
        Empregado empregado = empregadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empregado com o id :" + id + "não existe"));

        empregadoRepository.delete(empregado);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

