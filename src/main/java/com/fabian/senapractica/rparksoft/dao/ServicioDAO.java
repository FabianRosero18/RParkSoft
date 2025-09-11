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

    public ServicioDAO() {
        this.em = JpaUtil.getEntityManager();
    }
    
    public void insertarServicio(String idVehiculo, String fechaHora){
        
        vehiculo = new VehiculoDAO();
        
        try {
           em.getTransaction().begin();
           servicio.setVehiculo(vehiculo.consultarPorId(idVehiculo));
           servicio.setFechaHoraIgreso(fechaHora);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    public Boolean consultarPorId(int idSalida){
        
        try {
            em.getTransaction().begin();
            servicio = em.find(Servicio.class, idSalida);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        //retorna true o false dependiendo si encontro algo o no
        return servicio != null;
    }
}
