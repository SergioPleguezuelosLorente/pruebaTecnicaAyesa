package com.prueba.service;

import com.prueba.model.Empleados;
import com.prueba.repository.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private RepositorioEmpleado repositorioEmpleado;

    public Empleados saveEmpleado(Empleados empleado){
        return empleado;
    }

    public List<Empleados> list(){
        return repositorioEmpleado.findAll();
//        List<Empleado> lista = new ArrayList();
//        return lista;
    }

    void deleteEmpleados(int idEmpleado){

    }
}
