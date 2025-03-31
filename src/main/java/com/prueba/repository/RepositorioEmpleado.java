package com.prueba.repository;

import com.prueba.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleados, Integer> {
}
