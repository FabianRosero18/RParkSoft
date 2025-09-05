/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;

import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Vehiculo;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class VehiculoDAO {
    
    private EntityManager em;
    private Vehiculo vehiculo;

    public VehiculoDAO() {
        vehiculo = new Vehiculo();
        this.em = JpaUtil.getEntityManager();
    }
    
    public void insertarVehiculo(String placa, String tipo, String color, String marca, Long idUsuario){
        
        UsuarioDAO daoUsuario = new UsuarioDAO();

        try {
            em.getTransaction().begin();
            vehiculo.setPlaca(placa);
            vehiculo.setTipo(tipo);
            vehiculo.setColor(color);
            vehiculo.setMarca(marca);
            vehiculo.setUsuario(daoUsuario.consultarUsuarioPorId(idUsuario));
            em.persist(vehiculo);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
        } finally {
            em.close();
        }
    }
    
    
}
