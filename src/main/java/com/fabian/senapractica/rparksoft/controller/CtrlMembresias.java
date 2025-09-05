/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.controller;

import com.fabian.senapractica.rparksoft.modelAnterior.EntityMembresias;
import com.fabian.senapractica.rparksoft.modelAnterior.EntityPrincipal;
import com.fabian.senapractica.rparksoft.modelAnterior.JpaUtil;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

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
    private String fechaHoraActual;
    private DateTimeFormatter formatter; 
    private EntityPrincipal ingreso;
    private EntityManager em;
    private EntityMembresias membresia;
    private Long diasRestantes = 30L;
    private Boolean vigenciaActiva = Boolean.FALSE;
    private Boolean vigenciaVencida = Boolean.FALSE;
    private Boolean renovacionExitosa = Boolean.FALSE;
    
    public CtrlMembresias() {
        this.em = JpaUtil.getEntityManager();
        this.membresia = new EntityMembresias();
    }
    
    public CtrlMembresias(String id, String nombre, String apellido, String tipoVehiculo, String placa, String telefono, String direccion) {
        this();
        this.id = Long.valueOf(id);
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoVehiculo = tipoVehiculo;
        this.placa = placa;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public void fechaRegistro(){
        //obtener la fecha actual
        LocalDateTime actual = LocalDateTime.now();
        //dar formato de fecha actual
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //guardamos la fecha en la variable string segun el formato definido
        fechaHoraActual = actual.format(formatter);
        
    }
    public void insertarMembresia(){
        
        this.fechaRegistro();
        
        try {
            em.getTransaction().begin();
            membresia.setIdCliente(id);
            membresia.setNombre(nombre);
            membresia.setApellido(apellido);
            membresia.setTipoVehiculo(tipoVehiculo);
            membresia.setPlaca(placa);
            membresia.setTelefono(telefono);
            membresia.setDireccion(direccion);
            membresia.setFechaRegistro(fechaHoraActual);
            em.persist(membresia);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            
            em.getTransaction().rollback();
            e.printStackTrace();    
            
        } finally {
            em.close();
        }
  
    }
    public void validarAccion(String id, String accion){
        
        switch (accion) {
            
            case "ingreso":
                this.ingresoParking(id);
                break;
                
            case "renovacion":
                this.renovacion(id);
                break;
                
            default:
                throw new AssertionError();
        }
        
    }
    
    public void ingresoParking(String id){
        
        ingreso = new EntityPrincipal();
        
        this.fechaRegistro();
        
        LocalDateTime actual = LocalDateTime.now();
        //dar formato de fecha actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //guardamos la fecha en la variable string segun el formato definido
        String fechaHoraIngreso = actual.format(formatter);
                
        try {
            em.getTransaction().begin();
            membresia = em.find(EntityMembresias.class, id);
            LocalDateTime fechaRegistroConvertida = LocalDateTime.parse(membresia.getFechaRegistro(),formatter);
            
            long diasTranscurridos = ChronoUnit.DAYS.between(fechaRegistroConvertida, actual);
            diasRestantes -= diasTranscurridos;
                    
            //System.out.println("dias restantes: " + diasRestantes);
            
            if(diasRestantes > 0){
                vigenciaActiva = Boolean.TRUE;
                ingreso.setTipoVehiculo(membresia.getTipoVehiculo());
                ingreso.setPlaca(membresia.getPlaca());
                ingreso.setFechaHora(fechaHoraIngreso);
                em.persist(ingreso);
                em.getTransaction().commit();
            }
            else{
                vigenciaVencida = Boolean.TRUE;
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {
            em.close();            
        }
 
    }
    public void renovacion(String id){
        
        this.fechaRegistro();
                
        try {
            em.getTransaction().begin();
            membresia = em.find(EntityMembresias.class, id);
            membresia.setFechaRegistro(fechaHoraActual);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
        } finally {
            em.close();
        }
        
        vigenciaVencida = Boolean.FALSE;
        renovacionExitosa = Boolean.TRUE;
        
        /*Query query = em.createQuery("UPDATE EntityMembresias m SET m.fechaRegistro = :fechaRegistro WHERE m.idCliente = :id")
                .setParameter("fechaRegistro", fechaHoraActual)
                .setParameter("id", Long.valueOf(id));*/
        
    }

    public Long getDiasRestantes() {
        return diasRestantes;
    }

    public Boolean getVigenciaActiva() {
        return vigenciaActiva;
    }

    public Boolean getVigenciaVencida() {
        return vigenciaVencida;
    }

    public Boolean getRenovacionExitosa() {
        return renovacionExitosa;
    }

}
