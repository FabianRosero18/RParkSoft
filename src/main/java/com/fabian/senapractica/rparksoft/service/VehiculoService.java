/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.VehiculoDAO;

/**
 *
 * @author COMERCIAL
 */
public class VehiculoService {
    
    private String placa,tipo,color,marca;
    private Long idUsuario;

    public VehiculoService(String placa, String tipo, String color, String marca, String idUsuario) {
        this.placa = placa;
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.idUsuario = Long.valueOf(idUsuario);
    }
    public void crearVehiculo(){
        
        VehiculoDAO dao = new VehiculoDAO();
        dao.insertarVehiculo(placa,tipo,color,marca,idUsuario);
        
    }
    
}
