package com.prueba.service;

import com.prueba.model.Empleado;
import com.prueba.repository.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private RepositorioEmpleado repositorioEmpleado;

    public Empleado save(Empleado empleado){
        return repositorioEmpleado.save(empleado);
    }

    public List<Empleado> list(){
        return repositorioEmpleado.findAll();
    }

    public Empleado getEmpleadoById(int idEmpleado) {
        return repositorioEmpleado.findById(idEmpleado).orElse(new Empleado());
    }

    public void addEmpleado(Empleado empleado) {
        repositorioEmpleado.save(empleado);
    }

    public void updateEmpleado(Empleado empleado) {
        repositorioEmpleado.save(empleado);
    }

    void deleteEmpleados(int idEmpleado){
        repositorioEmpleado.deleteById(idEmpleado);
    }
}
