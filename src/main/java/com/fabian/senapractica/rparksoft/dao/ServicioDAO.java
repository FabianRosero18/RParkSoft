/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Servicio;
import com.fabian.senapractica.rparksoft.model.Tarifa;
import com.fabian.senapractica.rparksoft.model.Vehiculo;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */
public class ServicioDAO {
    
    private Servicio servicio;
    private List<Servicio> servicios;
    private EntityManager em;
    private VehiculoDAO vehiculoDAO;
    private TarifaDAO tarifaDAO;
    private boolean validacionId = false;

    public ServicioDAO() {
        this.em = JpaUtil.getEntityManager();
    }
    
    public void consultarServicios(){
        
        servicios = new ArrayList<>();
        servicios = em.createQuery("select s from Servicio s",Servicio.class)
               .    getResultList();
        
       
    }
    
    public void insertarServicio(Vehiculo vehiculo, Tarifa tarifa, String fechaHora){

        try {
           em.getTransaction().begin();
           servicio.setVehiculo(vehiculo);
           servicio.setTarifa(tarifa);
           servicio.setFechaHoraIgreso(fechaHora);
           em.persist(servicio);
           em.getTransaction().commit();
           
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
    
    public void consultarPorVehiculo(Vehiculo vehiculo){
        
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
    
        try {
            em.remove(servicio);
            em.getTransaction().commit();
  
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }
    
    public String fechaHoraIngresoVehiculo(){
        return servicio.getFechaHoraIgreso();
    }
    
    public boolean isValidacionId() {
        return validacionId;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public Servicio getServicio() {
        return servicio;
    }
    //un getter de entitymanager para poder usarlo en FacturaDAO y aprovechar que estamos usando la misma peticion
    public EntityManager getEm() {
        return em;
    }
    
    
    
}
