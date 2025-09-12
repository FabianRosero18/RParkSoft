/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Servicio;
import com.fabian.senapractica.rparksoft.model.Vehiculo;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class ServicioDAO {
    
    private Servicio servicio;
    private EntityManager em;
    private VehiculoDAO vehiculoDAO;
    private TarifaDAO tarifaDAO;
    private boolean validacionId = false;

    public ServicioDAO() {
        this.em = JpaUtil.getEntityManager();
    }
    
    public void insertarServicio(String idVehiculo, String fechaHora, String tipoTarifa){
        
        vehiculoDAO = new VehiculoDAO();
        tarifaDAO = new TarifaDAO();
        
        try {
           em.getTransaction().begin();
           Vehiculo vehiculo = vehiculoDAO.consultarPorId(idVehiculo);
           servicio.setVehiculo(vehiculo);
           servicio.setTarifa(tarifaDAO.consultarPorVehiculoTipo(vehiculo.getTipo(),tipoTarifa));
           servicio.setFechaHoraIgreso(fechaHora);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    public void consultarPorId(int idSalida){
        
        try {
            em.getTransaction().begin();
            servicio = em.find(Servicio.class, idSalida);
        } catch (Exception e) {
            em.getTransaction().rollback();
        } 
        //esta condicional valida si se encontro el servicio por el ID, luego es obtenido por PrincipalService para la continuacion de la logica
        if(servicio != null){
            validacionId = true;
        }
    }
    
    public void consultarPorVehiculo(String idSalida){
        
        vehiculoDAO = new VehiculoDAO();
        Vehiculo vehiculo = vehiculoDAO.consultarPorId(idSalida);   
        
        
        try {
            //Typedquery<Servicio> le dice al sistema que el query obtenido sera del tipo Servicio, no del tipo Objeto generico
            //en este caso no usamos typedquery sino que lo asignamos directamente al atributo de tipo Servicio
            servicio = em.createQuery("select s from Servicio s where s.vehiculo= :vehiculo",Servicio.class)
                    .setParameter("vehiculo", vehiculo).getSingleResult();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    public void eliminarServicio(){
        em.remove(servicio);
        em.getTransaction().commit();
        em.close();
    }
    
    public String fechaHoraIngresoVehiculo(){
        return servicio.getFechaHoraIgreso();
    }
    
    public boolean isValidacionId() {
        return validacionId;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    
    
}
