package com.grselectronics.inventario.bean;
// Generated 23-jun-2016 15:07:51 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Equipo generated by hbm2java
 */
public class Equipo  implements java.io.Serializable {


     private Integer idEquipo;
     private Marca marca;
     private String numeroSerie;
     private String modelo;
     private String activo;
     private String fechaCompra;
     private String finGarantia;
     private String ubicacion;
     private BigDecimal precioCompra;
     private BigDecimal valorEstimado;
     private Set asignacionEquipos = new HashSet(0);
     private Set caracteristicaEquipos = new HashSet(0);
     private Set reporteEquipos = new HashSet(0);

    public Equipo() {
    }

    public Equipo(Marca marca, String numeroSerie, String modelo, String activo, String fechaCompra, String finGarantia, String ubicacion, BigDecimal precioCompra, BigDecimal valorEstimado, Set asignacionEquipos, Set caracteristicaEquipos, Set reporteEquipos) {
       this.marca = marca;
       this.numeroSerie = numeroSerie;
       this.modelo = modelo;
       this.activo = activo;
       this.fechaCompra = fechaCompra;
       this.finGarantia = finGarantia;
       this.ubicacion = ubicacion;
       this.precioCompra = precioCompra;
       this.valorEstimado = valorEstimado;
       this.asignacionEquipos = asignacionEquipos;
       this.caracteristicaEquipos = caracteristicaEquipos;
       this.reporteEquipos = reporteEquipos;
    }
   
    public Integer getIdEquipo() {
        return this.idEquipo;
    }
    
    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }
    public Marca getMarca() {
        return this.marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public String getNumeroSerie() {
        return this.numeroSerie;
    }
    
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }
    public String getModelo() {
        return this.modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getActivo() {
        return this.activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
    }
    public String getFechaCompra() {
        return this.fechaCompra;
    }
    
    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
    public String getFinGarantia() {
        return this.finGarantia;
    }
    
    public void setFinGarantia(String finGarantia) {
        this.finGarantia = finGarantia;
    }
    public String getUbicacion() {
        return this.ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public BigDecimal getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }
    public BigDecimal getValorEstimado() {
        return this.valorEstimado;
    }
    
    public void setValorEstimado(BigDecimal valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
    public Set getAsignacionEquipos() {
        return this.asignacionEquipos;
    }
    
    public void setAsignacionEquipos(Set asignacionEquipos) {
        this.asignacionEquipos = asignacionEquipos;
    }
    public Set getCaracteristicaEquipos() {
        return this.caracteristicaEquipos;
    }
    
    public void setCaracteristicaEquipos(Set caracteristicaEquipos) {
        this.caracteristicaEquipos = caracteristicaEquipos;
    }
    public Set getReporteEquipos() {
        return this.reporteEquipos;
    }
    
    public void setReporteEquipos(Set reporteEquipos) {
        this.reporteEquipos = reporteEquipos;
    }




}


