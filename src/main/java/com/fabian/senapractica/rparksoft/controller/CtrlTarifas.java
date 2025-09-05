/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.controller;

import com.fabian.senapractica.rparksoft.modelAnterior.EntityTarifas;
import com.fabian.senapractica.rparksoft.modelAnterior.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;


public class CtrlTarifas {
    
    private int tarifaMotocicleta,tarifaAutomovil,tarifaBicicleta;
    private List<EntityTarifas> tarifas;
    private EntityTarifas tarifaPorVehiculo;
    private ArrayList<Integer> valor = new ArrayList<>();

    
    public void consultarTarifas(){
        
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("select t from EntityTarifas t",EntityTarifas.class);
        tarifas = query.getResultList();
        em.close();
        
        for(EntityTarifas tarifa : tarifas){
            valor.add(tarifa.getValor());
        }
    }
    
   public void validarTarifaActualizar() {
       
        System.out.println(" Tarifa moto: "+tarifaMotocicleta);
        System.out.println(" Tarifa carro: "+tarifaAutomovil);
        System.out.println(" Tarifa bici: "+tarifaBicicleta);   
       
        if(tarifaMotocicleta > 0)this.actualizarTarifas("Motocicleta",tarifaMotocicleta);
        
        if(tarifaAutomovil > 0)this.actualizarTarifas("Automovil",tarifaAutomovil);
            
        if(tarifaBicicleta > 0)this.actualizarTarifas("Bicicleta",tarifaBicicleta);
            
        
   }
    public void actualizarTarifas(String tipo, int valor){
        
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        this.consultarPorVehiculo(tipo,em);
        tarifaPorVehiculo.setValor(valor);
        em.merge(tarifaPorVehiculo);
        em.getTransaction().commit();
        em.close();
        
    }
    public void consultarPorVehiculo(String tipo , EntityManager em){
        
        tarifaPorVehiculo = em.find(EntityTarifas.class, tipo);
        
    }
    
    /*  los siguientes set reciben un String, pero deben convertirlos a int, ya que el servlet desde el que se envian
        capturo los valores de un input de JSP, y se valida si esta vacio, en dicho caso se asigna un 0 
    */
    
    public void setTarifaMotocicleta(String tarifaMotocicleta) {
        if(tarifaMotocicleta.isEmpty())
            this.tarifaMotocicleta = 0;
        else
            this.tarifaMotocicleta = Integer.parseInt(tarifaMotocicleta);
    }

    public void setTarifaAutomovil(String tarifaAutomovil) {
        if(tarifaAutomovil.isEmpty())
            this.tarifaAutomovil = 0;
        else
            this.tarifaAutomovil = Integer.parseInt(tarifaAutomovil);
    }

    public void setTarifaBicicleta(String tarifaBicicleta) {
        if(tarifaBicicleta.isEmpty())
            this.tarifaBicicleta = 0;
        else{
            this.tarifaBicicleta = Integer.parseInt(tarifaBicicleta);
        }
    }
    
    public ArrayList<Integer> getValor() {
        return valor;
    }

    public int getTarifaPorVehiculo() {
        return tarifaPorVehiculo.getValor();
    }
    
    

}
