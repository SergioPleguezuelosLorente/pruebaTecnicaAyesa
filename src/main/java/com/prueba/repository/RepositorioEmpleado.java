package com.prueba.repository;

import com.prueba.model.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioEmpleado extends CrudRepository<Empleado, Integer> {
}
