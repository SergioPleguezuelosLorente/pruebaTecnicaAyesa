package com.prueba.controller;

import com.prueba.model.Departamento;
import com.prueba.model.Empleado;
import com.prueba.service.DepartamentoService;
import com.prueba.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpleadoController implements ErrorController {
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
        return "homepage";
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
        Departamento departamento = departamentoService.getDepartamentoById(idDepartamento);
        model.addAttribute("lista", empleados);
        System.out.println(departamento.getNombre());
        model.addAttribute("departamento", departamento);
        model.addAttribute("empleado", new Empleado());
        return "listaEmpleados";
    }



    @PostMapping(value="/vistaEmpleado", params="eliminar")
    public String borrarEmpleado(@RequestParam int idEmpleado, @RequestParam String nombre, Model model){
        model.addAttribute(nombre);
        empleadoService.deleteEmpleados(idEmpleado);
        model.addAttribute("message", "Has eliminado un empleado correctamente");
        return "homepage";
    }

    @PostMapping(value="/vistaEmpleado", params="detalle")
    public String detalleEmpleado(@RequestParam int idEmpleado, Model model){
        Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
        Departamento departamento = departamentoService.getDepartamentoById(empleado.getIdDepartamento());
        model.addAttribute(empleado);
        model.addAttribute(departamento);
        return "detalleEmpleado";
    }

    @GetMapping("/empleado")
    public String empleadosMain(){
        return "empleado";
    }
}
