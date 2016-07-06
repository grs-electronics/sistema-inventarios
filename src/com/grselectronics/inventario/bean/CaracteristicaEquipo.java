package com.grselectronics.inventario.bean;
// Generated 23-jun-2016 15:07:51 by Hibernate Tools 4.3.1



/**
 * CaracteristicaEquipo generated by hbm2java
 */
public class CaracteristicaEquipo  implements java.io.Serializable {


     private Integer idCaracteristicaEquipo;
     private Equipo equipo;
     private Tipo tipo;
     private String nombre;
     private String descripcion;

    public CaracteristicaEquipo() {
    }

    public CaracteristicaEquipo(Equipo equipo, Tipo tipo, String nombre, String descripcion) {
       this.equipo = equipo;
       this.tipo = tipo;
       this.nombre = nombre;
       this.descripcion = descripcion;
    }
   
    public Integer getIdCaracteristicaEquipo() {
        return this.idCaracteristicaEquipo;
    }
    
    public void setIdCaracteristicaEquipo(Integer idCaracteristicaEquipo) {
        this.idCaracteristicaEquipo = idCaracteristicaEquipo;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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




}

