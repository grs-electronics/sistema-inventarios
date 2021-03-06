package com.grselectronics.inventario.bean;
// Generated 23-jun-2016 15:07:51 by Hibernate Tools 4.3.1



/**
 * ReporteEquipo generated by hbm2java
 */
public class ReporteEquipo  implements java.io.Serializable {


     private Integer idReporteEquipo;
     private Equipo equipo;
     private String nombre;
     private String descripcion;
     private String fecha;

    public ReporteEquipo() {
    }

    public ReporteEquipo(Equipo equipo, String nombre, String descripcion, String fecha) {
       this.equipo = equipo;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.fecha = fecha;
    }
   
    public Integer getIdReporteEquipo() {
        return this.idReporteEquipo;
    }
    
    public void setIdReporteEquipo(Integer idReporteEquipo) {
        this.idReporteEquipo = idReporteEquipo;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }




}


