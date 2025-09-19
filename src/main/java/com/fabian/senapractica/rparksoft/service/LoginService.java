/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.LoginDAO;
import com.fabian.senapractica.rparksoft.model.Login;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */
public class LoginService {
    
    private String  usuario,
                    contrasena,
                    direccionamiento,
                    validacion;
    private LoginDAO dao;

    public LoginService(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    
    public void validacion(){
        
        dao = new LoginDAO();
        dao.consultarUsuarios();
        
        for(Login l : dao.getLogin()){
            if(l.getUsuario().equals(usuario)){
                
                System.out.println("valido usuario");

                if(l.getContrasena().equals(contrasena)){
                    direccionamiento="principal.jsp";
                    System.out.println("valido usuario y contraseña");
                    break;
                }
                else{
                    validacion="visible";
                    direccionamiento="index.jsp";
                    System.out.println("valido usuario pero no contraseña");
                }
            }
            else{
                validacion="visible";
                direccionamiento="index.jsp"; 
                System.out.println("NO valido usuario");
            }
        }
    }
    
    public String getValidacion() {
        return validacion;
    }

    public String getDireccionamiento() {
        return direccionamiento;
    }

    public String getUsuario() {
        return usuario;
    }

}
