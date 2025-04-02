package com.prueba.repository;

import com.prueba.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDepartamento extends JpaRepository<Departamento, Integer> {
}