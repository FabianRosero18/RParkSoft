/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.dao;


import com.fabian.senapractica.rparksoft.model.JpaUtil;
import com.fabian.senapractica.rparksoft.model.Usuario;
import jakarta.persistence.EntityManager;

/**
 *
 * @author COMERCIAL
 */
public class UsuarioDAO {
    
    private EntityManager em;
    //entidad/modelo
    private Usuario usuario;

    public UsuarioDAO() {
        this.em = JpaUtil.getEntityManager();
        usuario = new Usuario();
    }
    public void insertarUsuario(Long id, String nombre, String telefono, String correo, Boolean membresia, String fechaHoraMembresia){
        
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
        } finally {
            em.close();
        }
    }
    public Usuario consultarUsuarioPorId(Long idUsuario){
        try {
            em.getTransaction().begin();
            usuario = em.find(Usuario.class, idUsuario);
                    
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            
        } finally {
            em.close();
        }
        return usuario;
    }
}
