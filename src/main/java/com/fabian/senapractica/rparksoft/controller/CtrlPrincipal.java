/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.controller;

import com.fabian.senapractica.rparksoft.model.EntityPrincipal;
import com.fabian.senapractica.rparksoft.model.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */
public class CtrlPrincipal {
    
    private String tipo, placa, accion, numeroFactura, placaSalida;
    private EntityPrincipal vehiculo;
    private EntityManager em;
    private String fechaHora;
    private List<EntityPrincipal> registros;
    



    public CtrlPrincipal() {
        this.registros = new ArrayList();
        //instancia de la entidad principal, es decir, la tabla de la base de datos y del entitymanager para manejar la unidad de persistencia
        this.vehiculo = new EntityPrincipal();
        this.em = JpaUtil.getEntityManager();
    }
    public CtrlPrincipal(String tipo, String placa, String accion, String numeroFactura, String placaSalida) {
        this();
        this.tipo = tipo;
        this.placa = placa;
        this.accion=accion;
        this.numeroFactura=numeroFactura;
        this.placaSalida=placaSalida;
    }
    
    public void accion(){
        
        //obtener la fecha actual
        LocalDateTime actual = LocalDateTime.now();
        //dar formato de fecha actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //guardamos la fecha en la variable string segun el formato definido
        fechaHora = actual.format(formatter);

        if(accion.equals("ingreso")){
            this.ingreso();
        }else if( accion.equals("salida")){
            this.validarSalida();
        }
    }
    public void ingreso(){
        
       try{
           
        em.getTransaction().begin();
        vehiculo.setTipoVehiculo(tipo);
        vehiculo.setPlaca(placa);
        vehiculo.setFechaHora(fechaHora);
        em.persist(vehiculo);
        em.getTransaction().commit();
        
       } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            
       } finally {
            em.close();
        }
       
    }
    private void validarSalida(){
        System.out.println("placa "+placaSalida);
        System.out.println("factura "+numeroFactura);
        try{
            em.getTransaction().begin();

            if(placaSalida.isEmpty()){
                System.out.println("entro aca");
                vehiculo = em.find(EntityPrincipal.class, numeroFactura);
            }
            else if (numeroFactura.isEmpty()){
                
                // TypedQuery<EntityPrincipal> se usa para indicar al compilador que la consulta retornara un objeto del tipo EntityPrincipal
                TypedQuery<EntityPrincipal> consulta = em.createQuery("Select v from EntityPrincipal v where v.placa =:placa",EntityPrincipal.class).setParameter("placa", placaSalida);
                vehiculo = consulta.getSingleResult();
            }
            this.salida();
            
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    private void salida(){
        em.remove(vehiculo);
        em.getTransaction().commit();
        em.close();
    }
    public void consulta(){
        Query query = em.createQuery("select p from EntityPrincipal p",EntityPrincipal.class);
        registros = query.getResultList();
    }

    public List<EntityPrincipal> getRegistros(){
        return registros;
    }
    private Long contarPorTipoVehiculo(String tipoVehiculo) {
        String consulta = "SELECT COUNT(e) FROM EntityPrincipal e WHERE e.tipoVehiculo = :tipoVehiculo";
        return em.createQuery(consulta, Long.class)
                 .setParameter("tipoVehiculo", tipoVehiculo)
                 .getSingleResult();
    }

    public Long cantidadBicicletas() {
        return contarPorTipoVehiculo("bicicleta");
    }

    public Long cantidadMotos() {
        return contarPorTipoVehiculo("moto");
    }

    public Long cantidadCarros() {
        return contarPorTipoVehiculo("carro");
    } 

}
