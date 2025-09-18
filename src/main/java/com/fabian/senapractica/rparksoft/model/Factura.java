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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author COMERCIAL
 */
@Entity
@Table(name = "facturas")
public class Factura {
    
    @Id
    private Long id;
    //esta anotacion indica una relacion de muchos a uno, y que su llave foranea sera el id del usuario    
    @ManyToOne
    //se debe unir al nombre de la columna de la tabla 
    @JoinColumn(name="id_vehiculo")
    private Vehiculo vehiculo;
    @ManyToOne
    @JoinColumn(name="id_tarifa")
    private Tarifa tarifa;
    @Column(name = "fecha_hora_ingreso")
    private String fechaHoraIgreso;
    @Column(name = "fecha_hora_salida")
    private String fechaHoraSalida;
    @Column(name = "valor_pagar")
    private Integer ValorPagar;

    public Factura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public String getFechaHoraIgreso() {
        return fechaHoraIgreso;
    }

    public void setFechaHoraIgreso(String fechaHoraIgreso) {
        this.fechaHoraIgreso = fechaHoraIgreso;
    }

    public String getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(String fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Integer getValorPagar() {
        return ValorPagar;
    }

    public void setValorPagar(Integer ValorPagar) {
        this.ValorPagar = ValorPagar;
    }
    
    
    
}
