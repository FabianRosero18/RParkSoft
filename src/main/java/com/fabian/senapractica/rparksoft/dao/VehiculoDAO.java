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
        vehiculo = new Vehiculo();
    }
    
    public void insertarVehiculo(String placa, String tipo, String color, String marca, Long idUsuario){
        
        UsuarioDAO daoUsuario = new UsuarioDAO();
        Usuario usuario = daoUsuario.consultarUsuarioPorId(idUsuario);
        
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
}
