package com.prueba.controller;

import com.prueba.model.Empleado;
import com.prueba.repository.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController implements ErrorController {
    private static final String PATH = "/error";

    @Autowired
    private RepositorioEmpleado userRepository;

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling...";
    }

    @RequestMapping(path = "/")
    public String mainPage (){
        
    }

    @PostMapping(path = "/create")
    public Boolean crearEmpleado (String name, String ape, int idDepartamento) {
        Empleado e = new Empleado();
        e.setNombre(name);
        e.setApellido(ape);
        e.setIdDepartamento(idDepartamento);
        userRepository.save(e);
        return true;
    }

    @GetMapping(path="/getEmpleados")
    public @ResponseBody Iterable<Empleado> getEmpleados() {
        return userRepository.findAll();
    }
}
