/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.VehiculoDAO;
import com.fabian.senapractica.rparksoft.model.Usuario;
import com.fabian.senapractica.rparksoft.model.Vehiculo;
import java.util.HashMap;
import java.util.Map;

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
    private Boolean accionExitosa,
                    accionFallida,
                    botonEliminar = Boolean.FALSE;
    private Map <String,String> datosVehiculo;
    private VehiculoDAO vehiculoDAO;


    public VehiculoService(String placa, String tipo, String color, String marca, String idUsuario) {
        this.placa = placa;
        this.tipo = tipo;
        this.color = color;
        this.marca = marca;
        this.idUsuario = idUsuario;
        this.vehiculoDAO = new VehiculoDAO();
    }
    
    public void validarAccion(String accion) {
        switch (accion) {
            case "consultar":
                this.consultarVeiculo();
                break;
                
            case "guardar":
            /*  debido a que el boton guardar se usara tanto para crear como para editar, debemos validar si el vehiculo que se ingresa existe, ya que solo asi podremos
                determinar si se trata de crear un vehiculo nuevo o si se esta editando un vehiculo existente */
                if(this.consultarVeiculo()==null)
                    this.crearVehiculo();
                else
                    this.editarVeiculo();
                break;
                
            case "eliminar":
                this.eliminarVehiculo();
                break;   
                
            default:
                throw new AssertionError();
        }
    }
    
    private Vehiculo consultarVeiculo(){
        
        //validamos si el campo ID esta vacio (con el metodo correspondiente) entonces retornamos  y no continuamos la operacion de consulta
        if(this.validarIdNoVacio() == false) return null;
        
        Vehiculo vehiculo = new Vehiculo();
        
        try {
            vehiculo = vehiculoDAO.consultarPorId(placa);
            datosVehiculo = new HashMap<>();

            if(vehiculo==null){
                mensajeFallido = "el vehiculo a consultar no existe";
                accionFallida = Boolean.TRUE;
            }
            else{
                datosVehiculo.put("placa", vehiculo.getPlaca());
                datosVehiculo.put("tipo", vehiculo.getTipo());
                datosVehiculo.put("color", vehiculo.getColor());
                datosVehiculo.put("marca", vehiculo.getMarca());
                datosVehiculo.put("idUsuario", vehiculo.getUsuario().getId());
                accionExitosa = Boolean.TRUE;
                //este atributo permitira que el boton de eliminar sea visible solo si la consulta fue exitosa
                botonEliminar = Boolean.TRUE;
            }
        } catch (NullPointerException e) {
            System.out.println("vehiculo nulo");
        }

        return vehiculo;
    }
    
    private void eliminarVehiculo(){
        
        if(this.validarIdNoVacio() == false) return;
         
        vehiculoDAO.borrar(placa);
        accionExitosa = Boolean.TRUE;
    }
        
    private void editarVeiculo() {
        
        System.out.println("entro a editar");
        Usuario usuario = this.validarUsuarioExistente();
        
        if(usuario!= null){
            if(this.validarIdNoVacio() == false) return;
            vehiculoDAO.editar(placa,tipo,color,marca,usuario);

            datosVehiculo = new HashMap<>();
            datosVehiculo.put("placa", placa);
        }
        else{
            mensajeFallido = "Usuario no existente, debe crearse primero el usuario";
            accionFallida = Boolean.TRUE;
        }
    }
    
    private void crearVehiculo(){
        
        System.out.println("entro a crear");
        
        Usuario usuario = this.validarUsuarioExistente();
        //validamos si el campo ID esta vacio (con el metodo correspondiente) entonces retornamos  y no continuamos la operacion de insercion
        if(this.validarIdNoVacio() == false) return;

        if(usuario!= null){
            vehiculoDAO.insertar(placa,tipo,color,marca,usuario);
            accionExitosa = Boolean.TRUE;
            //debido a que el metodo consultarVehiculo coloca este atributo en TRUE, nosotros debemos ponerlo en FALSE en este lugar para que no muestre mensaje de error.
            accionFallida = Boolean.FALSE;
        }
        else{
            mensajeFallido = "Usuario no existente, debe crearse primero el usuario";
            accionFallida = Boolean.TRUE;
        }
    }
    
    //metodo para validad que no hayan dejado el campo de Placa vacio, ya que al ser la llave primaria debe tener un valor
    private Boolean validarIdNoVacio(){
        
        if(placa.isEmpty()){
            accionFallida = Boolean.TRUE;
            mensajeFallido = "El campo Placa no debe quedar vacio";
            return false;
        }
        else{
            return true;
        }
    }
    
    private Usuario validarUsuarioExistente(){
        
        UsuarioService usuarioService = new UsuarioService(idUsuario);
        return usuarioService.buscarUsuario();
    }
    public Map<String, String> getDatosVehiculo() {
        return datosVehiculo;
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
