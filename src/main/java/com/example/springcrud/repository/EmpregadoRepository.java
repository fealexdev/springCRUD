package com.example.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springcrud.model.Empregado;


@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{

}