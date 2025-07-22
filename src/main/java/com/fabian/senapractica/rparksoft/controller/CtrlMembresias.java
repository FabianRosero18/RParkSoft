/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.controller;

import com.fabian.senapractica.rparksoft.model.EntityMembresias;
import com.fabian.senapractica.rparksoft.model.JpaUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author COMERCIAL
 */
public class CtrlMembresias {
    
    private Long id;
    private String nombre;
    private String apellido;
    private String tipoVehiculo;
    private String placa;
    private String telefono;
    private String direccion;
    private String fechaRegistro;
    private EntityManager em;
    private EntityMembresias membresia;

    public CtrlMembresias(String id, String nombre, String apellido, String tipoVehiculo, String placa, String telefono, String direccion) {
        this.id = Long.valueOf(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.telefono = telefono;
        this.direccion = direccion;
        this.em = JpaUtil.getEntityManager();
        this.membresia = new EntityMembresias();
    }
    
    public void insertarMembresia(){
        
        //obtener la fecha actual
        LocalDateTime actual = LocalDateTime.now();
        //dar formato de fecha actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //guardamos la fecha en la variable string segun el formato definido
        fechaRegistro = actual.format(formatter);
        
        try {
            em.getTransaction().begin();
            membresia.setIdCliente(id);
            membresia.setNombre(nombre);
            membresia.setApellido(apellido);
            membresia.setTipoVehiculo(tipoVehiculo);
            membresia.setPlaca(placa);
            membresia.setTelefono(telefono);
            membresia.setDireccion(direccion);
            membresia.setFechaRegistro(fechaRegistro);
            em.persist(membresia);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            em.getTransaction().rollback();
            e.printStackTrace();    
            
        } finally {
            em.close();
        }
  
    }
    
}
