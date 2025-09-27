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
public class UsuarioDAO {
    
    //private EntityManager em;
    //entidad/modelo
    private Usuario usuario;


    public void insertar(String id, String nombre, String telefono, String correo, Boolean membresia, String fechaHoraMembresia){
        usuario = new Usuario();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setTelefono(telefono);
            usuario.setCorreo(correo);
            usuario.setMembresia(membresia);
            usuario.setFechaHoraMembresia(fechaHoraMembresia);
            em.persist(usuario);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();    
        } 
    }
    public Usuario consultarPorId(String idUsuario){
        
        usuario = new Usuario();
        EntityManager em = JpaUtil.getEntityManager();
        try {
            usuario = em.find(Usuario.class, idUsuario);
                    
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
            em.close();
        }
        return usuario;
    }
    
    public static boolean actualizarFechaHoraMembresia(Vehiculo vehiculo, String fechaHoraActual){
       
        Boolean renovacion = Boolean.FALSE;
        EntityManager em = JpaUtil.getEntityManager();        

        try {
            em.getTransaction().begin();
            Usuario usuario = em.find(Usuario.class, vehiculo.getUsuario().getId());
            usuario.setFechaHoraMembresia(fechaHoraActual);
            em.merge(usuario);
            em.getTransaction().commit();
            renovacion = Boolean.TRUE;
            
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        
        return renovacion;
    }

    public void editar(String id, String nombre, String telefono, String correo, Boolean membresia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
