package com.prueba.controller;

import com.prueba.model.Empleados;
import com.prueba.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController implements ErrorController {
    private static final String PATH = "/error";

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling...";
    }

    @RequestMapping(path = "/")
    public String mainPage (){
        return "To create a new user go to /create";
    }

    @PostMapping(path = "/create")
    public Boolean crearEmpleado (String name, String ape, int idDepartamento) {
        Empleados e = new Empleados();
        e.setNombre(name);
        e.setApellido(ape);
        e.setIdDepartamento(idDepartamento);
//        userRepository.save(e);
        return true;
    }

    @GetMapping(path="/getEmpleados")
    public @ResponseBody Iterable<Empleados> getEmpleados() {
        List<Empleados> empleados = empleadoService.list();
        //userRepository.findAll()
        return empleados;
    }
}
