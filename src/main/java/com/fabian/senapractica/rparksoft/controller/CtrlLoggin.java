/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.controller;

/**
 *
 * @author COMERCIAL
 */
public class CtrlLoggin {
    
    private String usuario,contrasena,direccionamiento,validacion;

    public CtrlLoggin(String usuario, String contrasena) {
        this.usuario=usuario;
        this.contrasena=contrasena;
    }
    
    public void validacion(){
        if(usuario.equals("usuario")){
            if(contrasena.equals("123")){
                validacion="hidden";
                direccionamiento="principal.jsp";
            }
            else{
                validacion="visible";
                direccionamiento="index.jsp";
            }
        }else{
            validacion="visible";
            direccionamiento="index.jsp";
        }
    }

    public String GetValidacion() {
        return validacion;
    }

    public String getDireccionamiento() {
        return direccionamiento;
    }
    
}
