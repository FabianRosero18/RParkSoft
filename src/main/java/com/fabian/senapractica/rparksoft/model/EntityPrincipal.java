/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author COMERCIAL
 */
@Entity
@Table(name = "principal")
public class EntityPrincipal {
    
    @Id
    //esta anotacion indica que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    //IMPORTANTE, si es autoincremental, se debe inicializar, y es preferible que sea tipo Long
    private Long idFactura = 1L;
    private String tipoVehiculo;
    private String placa;
    private String fechaHora;

    public EntityPrincipal() {
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}
