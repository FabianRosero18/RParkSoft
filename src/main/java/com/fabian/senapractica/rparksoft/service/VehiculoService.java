/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.VehiculoDAO;
import com.fabian.senapractica.rparksoft.model.Usuario;
import jakarta.validation.ConstraintViolationException;

/**
 *
 * @author COMERCIAL
 */
public class VehiculoService {
    
    private String  placa,
                    tipo,
                    color,
                    marca,
                    idUsuario,
                    mensajeFallido;
    private Boolean ingresoExitoso = Boolean.FALSE;
    private Boolean ingresoFallido = Boolean.FALSE;

    public VehiculoService(String placa, String tipo, String color, String marca, String idUsuario) {
        this.placa = placa;
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.idUsuario = idUsuario;
    }
    public void crearVehiculo(){
        UsuarioService usuarioService = new UsuarioService(idUsuario);
        
        Usuario usuario = usuarioService.buscarUsuario();
        
        if(usuario!= null){
            VehiculoDAO vehiculoDAO = new VehiculoDAO();
            vehiculoDAO.insertarVehiculo(placa,tipo,color,marca,usuario);
            ingresoExitoso = Boolean.TRUE;
        }
        else{
            mensajeFallido = "Usuario no existente, debe crearse primero el usuario";
            ingresoFallido = Boolean.TRUE;
        }
    }

    public String getMensajeFallido() {
        return mensajeFallido;
    }

    public Boolean getIngresoExitoso() {
        return ingresoExitoso;
    }

    public Boolean getIngresoFallido() {
        return ingresoFallido;
    }
    
}
