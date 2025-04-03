package com.prueba.repository;

import com.prueba.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer> {

    @NativeQuery("SELECT * FROM EMPLEADOS WHERE id_department = ?1")
    List<Empleado> listEmpleadosByDepartamento(int idDepartamento);
}
