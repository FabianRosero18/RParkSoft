/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Tarifa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


public class TarifaDAO {
    
    
    private List<Tarifa> tarifas;
    private Tarifa tarifa = new Tarifa();
    private List<Integer> precios = new ArrayList<>();

    public void consultarTarifas(){
        
        EntityManager em = JpaUtil.getEntityManager();
       
        try {
            TypedQuery<Tarifa> query = em.createQuery("select t from Tarifa t",Tarifa.class);
            tarifas = query.getResultList(); 
        } finally {
            em.close();
        }
        
       precios.clear();
        for(Tarifa t : tarifas){
            precios.add(t.getPrecio());
        }
    }
    public Tarifa consultarPorVehiculoYTipoTarifa(String tipoVehiculo, String tipoTarifa){
               
        EntityManager em = JpaUtil.getEntityManager();
        try {
            tarifa = em.createQuery("select t from Tarifa t where t.descripcion =:tipoVehiculo and t.tipo =:tipoTarifa",Tarifa.class)
                    .setParameter("tipoVehiculo", tipoVehiculo)
                    .setParameter("tipoTarifa", tipoTarifa)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return tarifa;
    }
    
    public void modificarTarifa(int id,int precio){
        
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            tarifa = em.find(Tarifa.class, id);
            tarifa.setPrecio(precio);
            em.merge(tarifa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Integer> getPrecios(){
        return precios;
    }

}
