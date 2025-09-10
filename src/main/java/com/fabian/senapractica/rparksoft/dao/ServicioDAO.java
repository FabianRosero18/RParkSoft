/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Servicio;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class ServicioDAO {
    
    private Servicio servicio;
    private EntityManager em;
    private VehiculoDAO vehiculo;
    private TarifaDAO tarifa;
    
    public void insertarServicio(String idVehiculo){
        
        em = JpaUtil.getEntityManager();
        vehiculo = new VehiculoDAO();
        
        try {
           em.getTransaction().begin();
           servicio.setVehiculo(vehiculo.consultarPorId(idVehiculo));
           
        } catch (Exception e) {
        } finally {
        }
        //servicio.set
        
    }
    
    
}
