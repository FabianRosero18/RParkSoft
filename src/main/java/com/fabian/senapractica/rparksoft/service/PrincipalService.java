/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.FacturaDAO;
import com.fabian.senapractica.rparksoft.dao.ServicioDAO;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author COMERCIAL
 */
public class PrincipalService {
    
    private String idVehiculo,tipoTarifa,idSalida,accion;
    private FacturaDAO factura;
    private ServicioDAO servicio;
    private DateTimeFormatter formatter;

    public PrincipalService(String idVehiculo, String tipoTarifa, String idSalida, String accion) {
        this.idVehiculo = idVehiculo;
        this.tipoTarifa = tipoTarifa;
        this.idSalida = idSalida;
        this.accion = accion;
        servicio = new ServicioDAO();
    }
    
    public void validarAccion(){
        
        if(accion.equals("ingreso")){
            this.realizarIngreso();
        }else if( accion.equals("salida")){
            this.RealizarSalida();
            this.ingresarFactura();
        }
    }
    
    private void realizarIngreso(){
        
        servicio.insertarServicio(idVehiculo,fechaHora(),tipoTarifa);
    }
    
    private void RealizarSalida(){
        
        servicio.consultarPorId(Integer.parseInt(idSalida));
        
        //esta condicional es obtenida desde el DAO, indica que si no se encontro un servicio por el ID se procede a buscar por el vehiculo ingresado (Id del vehiculo)
        if(servicio.isValidacionId() == false){
            servicio.consultarPorVehiculo(idSalida);
        }
        
        this.ingresarFactura();
        servicio.eliminarServicio();
        
    }
    
    private void ingresarFactura(){
        
        factura = new FacturaDAO();
        factura.insertarFactura(this.fechaHora());
        
    }
    
    private void calcularTiempoTranscurrido(){
        
        //obtenemos la fecha de ingreso al parking de la base de datos, pero como esta en String debemos convertirla a LocalDateTime con la funcion parse, pasando la fecha y el formato
        LocalDateTime fechaIngresoParking = LocalDateTime.parse(servicio.fechaHoraIngresoVehiculo(),formatter);
        //con la clase Duration podemos obtener el tiempo transcurrido entre la entrada y salida del vehiculo
        Duration duracion = Duration.between(fechaIngresoParking,LocalDateTime.now());
        
        long horas = duracion.toHours();
        long minutos= duracion.toMinutes()%60;
    }
    
    private String fechaHora(){
        
        LocalDateTime actual = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return actual.format(formatter);
    }
    
}
