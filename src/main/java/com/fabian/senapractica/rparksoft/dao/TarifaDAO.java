/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Tarifa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class TarifaDAO {
    
    
    private List<Tarifa> tarifas;
    private Tarifa tarifa = new Tarifa();
    private ArrayList<Integer> precios = new ArrayList<>();

    public void consultarTarifas(){
        
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t from EntityTarifas t",Tarifa.class);
        tarifas = query.getResultList();        
        em.close();
        
        for(Tarifa tarifa : tarifas){
            precios.add(tarifa.getPrecio());
        }
    }

    
    public void modificarTarifa(int i,int precio){
        
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            tarifa = em.find(Tarifa.class, i);
            tarifa.setPrecio(precio);
            em.merge(tarifa);
            em.getTransaction().commit();
        } catch (Exception e) {
            
        } finally {
            em.close();
        }

    }

    public ArrayList<Integer> getPrecios() {
        return precios;
    }
    
    

}
