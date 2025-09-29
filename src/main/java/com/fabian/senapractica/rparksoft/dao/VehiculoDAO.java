/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Usuario;
import com.fabian.senapractica.rparksoft.model.Vehiculo;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class VehiculoDAO {
    
    private Vehiculo vehiculo;

    public VehiculoDAO() {
        //vehiculo = new Vehiculo();
    }
    
    public void insertar(String placa, String tipo, String color, String marca, Usuario usuario){
        //debido a que el metodo consultarVehiculo del service ha creado una instancia de vehiculo anteriormente (y esta quedo nula) es necesario volver a crear la instancia
        vehiculo = new Vehiculo();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            vehiculo.setPlaca(placa);
            vehiculo.setTipo(tipo);
            vehiculo.setColor(color);
            vehiculo.setMarca(marca);
            vehiculo.setUsuario(usuario);
            em.persist(vehiculo);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
        } finally {
            em.close();
        }
    }
    
    public Vehiculo consultarPorId(String id){
        
        vehiculo = new Vehiculo();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            vehiculo = em.find(Vehiculo.class, id);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return vehiculo;
    }
    
    public void editar(String placa, String tipo, String color, String marca, Usuario usuario){
        
        EntityManager em = JpaUtil.getEntityManager();
        vehiculo = em.find(Vehiculo.class, placa);
        try {
            em.getTransaction().begin();
            vehiculo.setPlaca(placa);
            vehiculo.setTipo(tipo);
            vehiculo.setColor(color);
            vehiculo.setMarca(marca);
            vehiculo.setUsuario(usuario);
            em.merge(vehiculo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
    }
    
    public void borrar(String placa){
        EntityManager em = JpaUtil.getEntityManager();
        
        vehiculo = em.find(Vehiculo.class, placa);
        try {
            em.getTransaction().begin();
            em.remove(vehiculo);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
   
}
