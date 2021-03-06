package com.grselectronics.inventario.bean;
// Generated 23-jun-2016 15:07:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cargo generated by hbm2java
 */
public class Cargo  implements java.io.Serializable {


     private Integer idCargo;
     private String nombre;
     private String descripcion;
     private Set empleados = new HashSet(0);

    public Cargo() {
    }

    public Cargo(String nombre, String descripcion, Set empleados) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.empleados = empleados;
    }
   
    public Integer getIdCargo() {
        return this.idCargo;
    }
    
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }




}


