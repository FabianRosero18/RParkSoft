/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.Tarifa;
import com.fabian.senapractica.rparksoft.modelAnterior.EntityTarifas;
import com.fabian.senapractica.rparksoft.modelAnterior.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class TarifaDAO {
    
    
    private List<Tarifa> tarifas;
    private ArrayList<Integer> precios = new ArrayList<>();

    public void consultarTarifas(){
        
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t from EntityTarifas t",EntityTarifas.class);
        tarifas = query.getResultList();        
        em.close();
        
        for(Tarifa tarifa : tarifas){
            precios.add(tarifa.getPrecio());
        }
        
    }

    public ArrayList<Integer> getPrecios() {
        return precios;
    }
    
    

}
