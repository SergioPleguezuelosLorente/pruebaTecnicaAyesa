package com.prueba.model;

import jakarta.persistence.*;

@Entity
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEmpleado;
    @Column(name="name")
    private String nombre;
    @Column(name="last_name")
    private String apellido;
    @Column(name="id_department")
    private int idDepartamento;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
}
