/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author COMERCIAL
 */
public class PrincipalService {
    
    private String idVehiculo,idSalida,accion;

    public PrincipalService(String idVehiculo, String idSalida, String accion) {
        this.idVehiculo = idVehiculo;
        this.idSalida = idSalida;
        this.accion = accion;
    }
    
    public void validarAccion(){
        
        if(accion.equals("ingreso")){
            this.ingreso();
        }else if( accion.equals("salida")){
            //this.validarSalida();
        }
    }
    
    private void ingreso(){
        
    }
    
    
    private String fechaHora(){
        
        LocalDateTime actual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return actual.format(formatter);
    }
    
}
