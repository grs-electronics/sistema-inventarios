package com.grselectronics.inventario.bean;
// Generated 23-jun-2016 15:07:51 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Tipo generated by hbm2java
 */
public class Tipo  implements java.io.Serializable {


     private Integer idTipo;
     private String nombre;
     private String imagen;
     private String descripcion;
     private Set caracteristicaEquipos = new HashSet(0);

    public Tipo() {
    }

    public Tipo(String nombre, String imagen, String descripcion, Set caracteristicaEquipos) {
       this.nombre = nombre;
       this.imagen = imagen;
       this.descripcion = descripcion;
       this.caracteristicaEquipos = caracteristicaEquipos;
    }
   
    public Integer getIdTipo() {
        return this.idTipo;
    }
    
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getImagen() {
        return this.imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getCaracteristicaEquipos() {
        return this.caracteristicaEquipos;
    }
    
    public void setCaracteristicaEquipos(Set caracteristicaEquipos) {
        this.caracteristicaEquipos = caracteristicaEquipos;
    }




}

