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

@Entity
@Table(name = "servicios")
public class Servicio {
    
    @Id
    //esta anotacion indica que es autoincremental
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //IMPORTANTE, si es autoincremental, se debe inicializar, y es preferible que sea tipo Long
    private Long id = 1L;
    //esta anotacion indica una relacion de muchos a uno, y que su llave foranea sera el id del usuario    
    @ManyToOne
    //se debe unir al nombre de la columna de la tabla 
    @JoinColumn(name="id_vehiculo")
    private Vehiculo vehiculo;
    @Column(name = "fecha_hora_ingreso")
    private String fechaHoraIgreso;

    public Servicio() {
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

    public String getFechaHoraIgreso() {
        return fechaHoraIgreso;
    }

    public void setFechaHoraIgreso(String fechaHoraIgreso) {
        this.fechaHoraIgreso = fechaHoraIgreso;
    }
    
    
    
    
}
