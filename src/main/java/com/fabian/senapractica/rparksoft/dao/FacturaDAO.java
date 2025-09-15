/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.Factura;
import com.fabian.senapractica.rparksoft.model.Servicio;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class FacturaDAO{
    
    private Factura factura;
    private EntityManager em;
    
    public FacturaDAO() {
    }
    
    public void insertarFactura(Servicio servicio, String fechaHoraSalida, int valodPagar){

        try {
            em.getTransaction().begin();
            factura.setId(servicio.getId());
            factura.setVehiculo(servicio.getVehiculo());
            factura.setTarifa(servicio.getTarifa());
            factura.setFechaHoraIgreso(servicio.getFechaHoraIgreso());
            factura.setFechaHoraSalida(fechaHoraSalida);
            factura.setValorPagar(valodPagar);
            em.persist(factura);
            em.getTransaction().commit();
           
        } catch (Exception e) {
            em.getTransaction().rollback();
        } 
    }
    
}
