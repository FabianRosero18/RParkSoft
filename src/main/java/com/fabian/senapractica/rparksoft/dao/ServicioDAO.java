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
    //private EntityManager em;
    private VehiculoDAO vehiculoDAO;
    private TarifaDAO tarifaDAO;

    public ServicioDAO() {
        servicio = new Servicio();
    }

    public void consultarServicios(){
        EntityManager em = JpaUtil.getEntityManager();
        servicios = new ArrayList<>();
        servicios = em.createQuery("select s from Servicio s",Servicio.class).getResultList();

    }
    
    public void insertarServicio(Vehiculo vehiculo, Tarifa tarifa, String fechaHora){
            EntityManager em = JpaUtil.getEntityManager();

        try {
           em.getTransaction().begin();
           servicio.setVehiculo(vehiculo);
           servicio.setTarifa(tarifa);
           servicio.setFechaHoraIngreso(fechaHora);
           em.persist(servicio);
           em.getTransaction().commit();
           
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    public void consultarSalidaPorId(int idSalida){
       EntityManager em = JpaUtil.getEntityManager();

        try {
            em.getTransaction().begin();
            servicio = em.find(Servicio.class, idSalida);
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
        //esta condicional valida si se encontro el servicio por el ID, luego es obtenido por PrincipalService para la continuacion de la logica

    }
    
    public void consultarSalidaPorVehiculo(Vehiculo vehiculo){
        EntityManager em = JpaUtil.getEntityManager();

        try {
            //en este caso no usamos typedquery sino que lo asignamos directamente al atributo de tipo Servicio
            servicio = em.createQuery("select s from Servicio s where s.vehiculo= :vehiculo",Servicio.class)
                    .setParameter("vehiculo", vehiculo).getSingleResult();
            
        } catch (Exception e) {
            throw new RuntimeException("Error consultando la salida por vehículo", e);        
        }
        finally{
            em.close();
        }
    }

    public void eliminarServicio(){
        EntityManager em = JpaUtil.getEntityManager();
        
        System.out.println("desde eliminar servicio "+servicio.getId()+" - "+servicio.getVehiculo().getPlaca());

        try {
            em.getTransaction().begin();
            servicio =em.find(Servicio.class, servicio.getId());
            em.remove(servicio);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }
    }
    
    public List<Vehiculo> consultarVehiculosEnServicio(){
        EntityManager em = JpaUtil.getEntityManager();

        List<Vehiculo> vehiculosEnServicio = new ArrayList<>();
        
        try {
             vehiculosEnServicio = em.createQuery("SELECT s.vehiculo FROM Servicio s", Vehiculo.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Error consultando los vehiculos en servicio", e);        
        }
        return vehiculosEnServicio;
    }
    
    public String fechaHoraIngresoVehiculo(){
        return servicio.getFechaHoraIngreso();
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public Servicio getServicio() {
        return servicio;
    }

    
}
