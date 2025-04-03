package com.prueba.controller;

import com.prueba.model.Departamento;
import com.prueba.model.Empleado;
import com.prueba.service.DepartamentoService;
import com.prueba.service.EmpleadoService;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController implements ErrorController {
    private static final String PATH = "/error";

    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private DepartamentoService departamentoService;


    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling...";
    }

    @GetMapping("/")
    public String mainPage(){
        return "homepage";
    }

    @GetMapping("/crearEmpleado")
    public String empleado(Model model){
        model.addAttribute("empleado", new Empleado());
        List<Departamento> lista = departamentoService.list();
        model.addAttribute("lista", lista);
        return "crearEmpleado";
    }

    @PostMapping(path = "/createEmpleado")
    public String crearEmpleado (@ModelAttribute Empleado empleado, Model model) {
        model.addAttribute("empleados", new Empleado());
        empleadoService.addEmpleado(empleado);
        model.addAttribute("message", "Has creado un empleado correctamente");
        return "crearEmpleado";
    }

    @GetMapping("/departamento")
    public String departamento(Model model){
        model.addAttribute("departamento", new Departamento());
        return "departamento";
    }

    @PostMapping(path = "/createDepartamento")
    public String crearDepartamento (@ModelAttribute Departamento departamento, Model model) {
        model.addAttribute("departamentos", new Departamento());
        departamentoService.addDepartamento(departamento);
        model.addAttribute("message", "Has creado un departamento correctamente");
        return "departamento";
    }

    @GetMapping(path="/getEmpleados")
    public @ResponseBody Iterable<Empleado> getEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.list();
        return empleados;
    }

    @GetMapping(path="/buscarEmpleado")
    public String buscarEmpleado() {
        return "buscarEmpleado";
    }

    @GetMapping("/listarEmpleados")
    public String listarEmpleados(Model model){
        model.addAttribute("empleado", new Empleado());
        List<Departamento> lista = departamentoService.list();
        model.addAttribute("lista", lista);
        return "listarEmpleados";
    }

    @PostMapping(path="/listadoEmpleados")
//    @ResponseBody Iterable<Empleado>
    public String listadoEmpleados(Model model, int idDepartamento) {
        List<Empleado> empleados = empleadoService.listEmpleadoByDepartamento(idDepartamento);
        model.addAttribute("lista", empleados);
        return "listaEmpleados";
    }



    @GetMapping("/borrarEmpleado")
    public String borrarEmpleado(){
        return "borrarEmpleado";
    }

    @GetMapping("/empleado")
    public String empleadosMain(){
        return "empleado";
    }
}
