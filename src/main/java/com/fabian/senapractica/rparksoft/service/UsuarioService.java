/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.UsuarioDAO;
import com.fabian.senapractica.rparksoft.model.Usuario;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author COMERCIAL
 */
public class UsuarioService {
    
    private String  id,
                    nombre,
                    telefono,
                    correo,
                    fechaHoraMembresia,
                    mensajeFallido;
    private Boolean membresia;
    private Boolean accionExitosa,
                    accionFallida,
                    botonEliminar= Boolean.FALSE;
    private DateTimeFormatter formatter;
    private Map <String,String> datosUsuario;
    private UsuarioDAO usuarioDAO;

    public UsuarioService(String id) {
        this.id = id;
        usuarioDAO = new UsuarioDAO();
    }

    public UsuarioService(String id, String nombre, String telefono, String correo, String membresia) {
        usuarioDAO = new UsuarioDAO();
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.membresia = Boolean.valueOf(membresia);
    }
    
        public void validarAccion(String accion) {
        switch (accion) {
            case "consultar":
                this.listarUsuario();
                break;
                
            case "guardar":
            /*  debido a que el boton guardar se usara tanto para crear como para editar, debemos validar si el vehiculo que se ingresa existe, ya que solo asi podremos
                determinar si se trata de crear un vehiculo nuevo o si se esta editando un vehiculo existente */
                if(this.buscarUsuario()==null)
                    this.crearUsuario();
                else
                    this.editarUsuario();
                break;
                
            case "eliminar":
                this.eliminarUsuario();
                break;   
                
            default:
                throw new AssertionError();
        }
    }
    
    private void crearUsuario(){
                
        if(this.validarIdNoVacio() == false) return;

            this.establecerFechaHoraMembresia();
            usuarioDAO.insertar(id,nombre,telefono,correo,membresia,fechaHoraMembresia);
            accionExitosa = Boolean.TRUE;

    }
    public Usuario buscarUsuario(){
                
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultarPorId(id);
        
    }
    
    //la razon de la existencia de este metodo (existiendo en buscarUsuario) es por que este se ejecuta desde esta clase, el otro 
    //desde la clase VehiculoService, y generaria un NullPointerExcepcion al validarIdNoVacio.
    private void listarUsuario(){
        
        if(this.validarIdNoVacio() == false) return;
        
        Usuario usuario = new Usuario();
        
        try {
            usuario = usuarioDAO.consultarPorId(id);
            datosUsuario = new HashMap<>();
            
            if(usuario == null){
                mensajeFallido = "el usuario a consultar no existe";
                accionFallida = Boolean.TRUE;
            }
            else{
                datosUsuario.put("id", usuario.getId());
                datosUsuario.put("nombre", usuario.getNombre());
                datosUsuario.put("telefono", usuario.getTelefono());
                datosUsuario.put("correo", usuario.getCorreo());
                datosUsuario.put("membresia", String.valueOf(usuario.getMembresia()));
                accionExitosa = Boolean.TRUE;
                //este atributo permitira que el boton de eliminar sea visible solo si la consulta fue exitosa
                botonEliminar = Boolean.TRUE;                
            }
            
        } catch (NullPointerException e) {
            System.out.println("usuario nulo");
        }
    }
    
    private void editarUsuario() {
        
        if(this.validarIdNoVacio() == false) return;
        usuarioDAO.editar(id,nombre,telefono,correo,membresia);
        
        datosUsuario = new HashMap<>();
        datosUsuario.put("id", id);
        accionExitosa = Boolean.TRUE;
        
    }

    private void eliminarUsuario() {
        
        if(this.validarIdNoVacio() == false) return;
        
        usuarioDAO.borrar(id);
        accionExitosa = Boolean.TRUE;

    }
    
    private Boolean validarIdNoVacio(){
        
        if(id.isEmpty()){
            accionFallida = Boolean.TRUE;
            mensajeFallido = "El campo Numero de identificacion no debe quedar vacio";
            return false;
        }
        else{
            return true;
        }
    }
    
    private void establecerFechaHoraMembresia(){
        //obtener la fecha actual
        LocalDateTime actual = LocalDateTime.now();
        //dar formato de fecha actual
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //guardamos la fecha en la variable string segun el formato definido
        fechaHoraMembresia = actual.format(formatter);
    }

    public Map<String, String> getDatosUsuario() {
        return datosUsuario;
    }
    
    public String getMensajeFallido() {
        return mensajeFallido;
    }

    public Boolean getAccionExitosa() {
        return accionExitosa;
    }

    public Boolean getAccionFallida() {
        return accionFallida;
    }

    public Boolean getBotonEliminar() {
        return botonEliminar;
    }
    
    

}
