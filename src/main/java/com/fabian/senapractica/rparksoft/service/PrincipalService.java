/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;

import com.fabian.senapractica.rparksoft.dao.FacturaDAO;
import com.fabian.senapractica.rparksoft.dao.ServicioDAO;
import com.fabian.senapractica.rparksoft.dao.TarifaDAO;
import com.fabian.senapractica.rparksoft.dao.VehiculoDAO;
import com.fabian.senapractica.rparksoft.model.Servicio;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */
public class PrincipalService {
    
    private String idVehiculo,tipoTarifa,idSalida,accion;
    private int valorPagar;
    private long horas;
    private Boolean mensajeSalidaExitoso = false;
    private FacturaDAO factura;
    private ServicioDAO servicio;
    private VehiculoDAO vehiculo;
    private TarifaDAO tarifa;
    private DateTimeFormatter formatter;

     public PrincipalService(){
        servicio = new ServicioDAO();
    }
    
    public PrincipalService(String idVehiculo, String tipoTarifa, String idSalida, String accion) {
        this();
        this.idVehiculo = idVehiculo;
        this.tipoTarifa = tipoTarifa;
        this.idSalida = idSalida;
        this.accion = accion;        
    }
    
    public List<Servicio> listarServicios(){
        
        servicio.consultarServicios();
        List<Servicio> servicios = servicio.getServicios();
        return servicios;
    }

    public void validarAccion(){
        
        if(accion.equals("ingreso")){
            this.realizarIngreso();
        }else if( accion.equals("salida")){
            this.realizarSalida();
        }
    }
    
    private void realizarIngreso(){
        
        vehiculo = new VehiculoDAO();
        tarifa = new TarifaDAO();
        //vehiculoServicio = vehiculo.consultarPorId(idVehiculo)
        
        servicio.insertarServicio(
                vehiculo.consultarPorId(idVehiculo),
                tarifa.consultarPorVehiculoTipo(vehiculo.consultarPorId(idVehiculo).getTipo(),tipoTarifa),
                fechaHora()
        );
    }
    
    private void realizarSalida(){
        
        servicio.consultarPorId(Integer.parseInt(idSalida));
        /*esta condicional es obtenida desde el DAO, indica que si no se encontro un servicio por el ID se procede a buscar por el vehiculo, asumiento que la ID
        ingresada es entonces el del vehiculo*/
        if(servicio.isValidacionId() == false){
            
            vehiculo = new VehiculoDAO();
            servicio.consultarPorVehiculo(vehiculo.consultarPorId(idSalida));
        }
        
        this.ingresarFactura();
        servicio.eliminarServicio();
        
        if(servicio.getServicio() == null){
            mensajeSalidaExitoso = Boolean.TRUE;
        }
    }
    
    private void ingresarFactura(){
       
        this.calcularTiempoTranscurrido();
        factura = new FacturaDAO();
        
        factura.insertarFactura(servicio.getServicio(),this.fechaHora(),valorPagar);
        
    }
    
    private void calcularTiempoTranscurrido(){
        
        //obtenemos la fecha de ingreso al parking de la base de datos, pero como esta en String debemos convertirla a LocalDateTime con la funcion parse, pasando la fecha y el formato
        LocalDateTime fechaIngresoParking = LocalDateTime.parse(servicio.fechaHoraIngresoVehiculo(),formatter);
        //con la clase Duration podemos obtener el tiempo transcurrido entre la entrada y salida del vehiculo
        Duration duracion = Duration.between(fechaIngresoParking,LocalDateTime.now());
        
        //obtenemos con las respectivas funciones las horas y los minutos transcurridos (minutos sobrantes de las horas, modulo de 60)
        horas = duracion.toHours();
        long minutos= duracion.toMinutes()%60;
        
        if(minutos > 0){
            horas += 1;
        }
        this.calcularTarifa();
    }
    private void calcularTarifa(){
                
        valorPagar = (int) (servicio.getServicio().getTarifa().getPrecio() * horas);
        
    }
    private String fechaHora(){
        
        LocalDateTime actual = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return actual.format(formatter);
    }

    public Boolean getMensajeSalidaExitoso() {
        return mensajeSalidaExitoso;
    }
    
    public int getValorPagar() {
        return valorPagar;
    }
    
}
