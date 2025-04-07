package com.prueba.controller;

import com.prueba.model.Departamento;
import com.prueba.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

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
        return "homepage";
    }
}
