/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.Factura;
import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Servicio;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class FacturaDAO{
    
    private Factura factura;

    
    public FacturaDAO() {
        factura = new Factura();

    }
    
    public void insertarFactura(Servicio servicio, String fechaHoraSalida, int valorPagar){
        
        EntityManager em = JpaUtil.getEntityManager();
                
        try {
            em.getTransaction().begin();
            factura.setId(servicio.getId());
            factura.setVehiculo(servicio.getVehiculo());
            factura.setTarifa(servicio.getTarifa());
            factura.setFechaHoraIgreso(servicio.getFechaHoraIngreso());
            factura.setFechaHoraSalida(fechaHoraSalida);
            factura.setValorPagar(valorPagar);
            em.persist(factura);
            em.getTransaction().commit();
           
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        } 
    }
    
}
