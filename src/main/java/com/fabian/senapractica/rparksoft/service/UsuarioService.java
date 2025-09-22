/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.UsuarioDAO;
import com.fabian.senapractica.rparksoft.model.Usuario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author COMERCIAL
 */
public class UsuarioService {
    
    private String id,nombre,telefono,correo,fechaHoraMembresia;
    private Boolean membresia;
    private DateTimeFormatter formatter; 

    public UsuarioService(String id) {
        this.id = id;
    }

    public UsuarioService(String id, String nombre, String telefono, String correo, String membresia) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.membresia = Boolean.valueOf(membresia);
    }
    public void crearUsuario(){
        
        this.establecerFechaHoraMembresia();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.insertarUsuario(id,nombre,telefono,correo,membresia,fechaHoraMembresia);
    }
    public Usuario buscarUsuario(){
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultarUsuarioPorId(id);
        
    }
    private void establecerFechaHoraMembresia(){
        //obtener la fecha actual
        LocalDateTime actual = LocalDateTime.now();
        //dar formato de fecha actual
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //guardamos la fecha en la variable string segun el formato definido
        fechaHoraMembresia = actual.format(formatter);
    }
}
