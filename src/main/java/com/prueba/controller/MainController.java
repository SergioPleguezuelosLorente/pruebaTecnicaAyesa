package com.prueba.controller;

import com.prueba.model.Empleado;
import com.prueba.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController implements ErrorController {
    private static final String PATH = "/error";

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling...";
    }

    @GetMapping("/")
    public String mainPage(){
        return "homepage";
    }

    @GetMapping("/empleado")
    public String empleado(Model model){
        model.addAttribute("empleados", new Empleado());
        return "empleado";
    }

    @PostMapping(path = "/createEmpleado")
    public String crearEmpleado (@ModelAttribute Empleado empleado, Model model) {
        System.out.println(empleado.toString());
        model.addAttribute("empleados", new Empleado());
        empleadoService.save(empleado);
        model.addAttribute("message", "Has creado un empleado correctamente");
        return "empleado"; // this makes a GET to "service" endpoint
    }

    @GetMapping("/departamento")
    public String departamento(){
        return "departamento";
    }



    @GetMapping(path="/getEmpleados")
    public @ResponseBody Iterable<Empleado> getEmpleados() {
        List<Empleado> empleados = empleadoService.list();
        //userRepository.findAll()
        return empleados;
    }
}
