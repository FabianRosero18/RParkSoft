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
import java.time.Duration;
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
    private int valorPagar;
    private Boolean mensajeSalida = Boolean.FALSE;
    private LocalDateTime actual;
    private DateTimeFormatter formatter;

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
        actual = LocalDateTime.now();
        //dar formato de fecha actual
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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

        try{
            em.getTransaction().begin();

            if(placaSalida.isEmpty()){
               
                vehiculo = consultaPorId();
            }
            else if (numeroFactura.isEmpty()){

                vehiculo = consultaPorPlaca();
            }
            this.salida();
            
        } catch(Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    private void salida(){
        
        mensajeSalida = Boolean.TRUE;
        
        //obtenemos la fecha de ingreso al parking de la base de datos, pero como esta en String debemos convertirla a LocalDateTime con la funcion parse, pasando la fecha y el formato
        LocalDateTime fechaIngresoParking = LocalDateTime.parse(vehiculo.getFechaHora(),formatter);
        
        //con la clase Duration podemos obtener el tiempo transcurrido entre la entrada y salida del vehiculo
        Duration duracion = Duration.between(fechaIngresoParking, actual);
        
        //obtenemos con las respectivas funciones las horas y los minutos transcurridos (minutos sobrantes de las horas, modulo de 60)
        long horas = duracion.toHours();
        long minutos= duracion.toMinutes()%60;
        
        //ya que en el parking los minutos pasados se cobran como hora, entonces se adiciona 1 hora mas si se ha pasado
        if(minutos > 0){
            horas += 1;
        }
        
        System.out.println("horas a cobrar: "+horas);
        this.calcularTarifa(horas);
        
        em.remove(vehiculo);
        em.getTransaction().commit();
        em.close();
    }
    
    public void calcularTarifa(long horas){
        
        switch (vehiculo.getTipoVehiculo()) {
            case "Automovil":
                valorPagar = (int) (horas * 3200);
                break;
            case "Motocicleta":
                valorPagar = (int) (horas * 1500);
                break;
            case "Bicicleta":
                valorPagar = (int) (horas * 800);
                break;
        }
    }
    
    public void consulta(){
        
        Query query = em.createQuery("select p from EntityPrincipal p",EntityPrincipal.class);
        registros = query.getResultList();
    }
    
    public EntityPrincipal consultaPorId(){
        
        return em.find(EntityPrincipal.class, numeroFactura);
    }
    
    public EntityPrincipal consultaPorPlaca(){
        
        // TypedQuery<EntityPrincipal> se usa para indicar al compilador que la consulta retornara un objeto del tipo EntityPrincipal
        TypedQuery<EntityPrincipal> consulta = em.createQuery("Select v from EntityPrincipal v where v.placa =:placa",EntityPrincipal.class).setParameter("placa", placaSalida);
        return consulta.getSingleResult();
    }
    
    public List<EntityPrincipal> getRegistros(){
        return registros;
    }

    public int getValorPagar() {
        return valorPagar;
    }

    public Boolean getMensajeSalida() {
        return mensajeSalida;
    }

    private Long contarPorTipoVehiculo(String tipoVehiculo) {
        String consulta = "SELECT COUNT(e) FROM EntityPrincipal e WHERE e.tipoVehiculo = :tipoVehiculo";
        return em.createQuery(consulta, Long.class)
                 .setParameter("tipoVehiculo", tipoVehiculo)
                 .getSingleResult();
    }

    public Long cantidadBicicletas() {
        return contarPorTipoVehiculo("Bicicleta");
    }

    public Long cantidadMotos() {
        return contarPorTipoVehiculo("Motocicleta");
    }

    public Long cantidadCarros() {
        return contarPorTipoVehiculo("Automovil");
    } 

}
