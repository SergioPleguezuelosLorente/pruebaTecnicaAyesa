package com.prueba.service;

import com.prueba.model.Departamento;
import com.prueba.repository.RepositorioDepartamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartamentoService {
    @Autowired
    private RepositorioDepartamento repositorioDepartamento;

    public Departamento save(Departamento departamento){
        return repositorioDepartamento.save(departamento);
    }

    public List<Departamento> list(){
        return repositorioDepartamento.findAll();
    }

    public Departamento getDepartamentoById(int idDepartamento) {
        return repositorioDepartamento.findById(idDepartamento).orElse(new Departamento());
    }

    public void addDepartamento(Departamento departamento) {
        repositorioDepartamento.save(departamento);
    }

    public void updateDepartamento(Departamento departamento) {
        repositorioDepartamento.save(departamento);
    }

    void deleteDepartamento(int idDepartamento){
        repositorioDepartamento.deleteById(idDepartamento);
    }

}
