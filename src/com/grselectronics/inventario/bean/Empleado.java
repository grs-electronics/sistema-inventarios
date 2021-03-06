package com.grselectronics.inventario.bean;
// Generated 23-jun-2016 15:07:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {


     private Integer idEmpleado;
     private Cargo cargo;
     private Empresa empresa;
     private String nombre;
     private Set asignacionEquipos = new HashSet(0);

    public Empleado() {
    }

    public Empleado(Cargo cargo, Empresa empresa, String nombre, Set asignacionEquipos) {
       this.cargo = cargo;
       this.empresa = empresa;
       this.nombre = nombre;
       this.asignacionEquipos = asignacionEquipos;
    }
   
    public Integer getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getAsignacionEquipos() {
        return this.asignacionEquipos;
    }
    
    public void setAsignacionEquipos(Set asignacionEquipos) {
        this.asignacionEquipos = asignacionEquipos;
    }




}


