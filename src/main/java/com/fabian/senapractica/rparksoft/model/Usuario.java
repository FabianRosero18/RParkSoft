/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Usuario {
    
    @Id
    @Column(name = "documento")
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private Boolean membresia;
    @Column(name = "fecha_hora_membresia")
    private String fechaHoraMembresia;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getMembresia() {
        return membresia;
    }

    public void setMembresia(Boolean membresia) {
        this.membresia = membresia;
    }

    public String getFechaHoraMembresia() {
        return fechaHoraMembresia;
    }

    public void setFechaHoraMembresia(String fechaHoraMembresia) {
        this.fechaHoraMembresia = fechaHoraMembresia;
    }
    
    

}
