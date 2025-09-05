/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.UsuarioDAO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author COMERCIAL
 */
public class UsuarioService {
    
    private Long id;
    private String nombre,telefono,correo,fechaHoraMembresia;
    private Boolean membresia;
    private DateTimeFormatter formatter; 

    public UsuarioService(String id, String nombre, String telefono, String correo, String membresia) {
        this.id = Long.valueOf(id);
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.membresia = Boolean.valueOf(membresia);
    }
    public void crearUsuario(){
        
        this.establecerFechaHoraMembresia();
        UsuarioDAO dao = new UsuarioDAO();
        dao.insertarUsuario(id,nombre,telefono,correo,membresia,fechaHoraMembresia);
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
