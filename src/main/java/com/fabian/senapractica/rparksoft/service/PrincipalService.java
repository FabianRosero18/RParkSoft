/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabian.senapractica.rparksoft.service;


import com.fabian.senapractica.rparksoft.dao.FacturaDAO;
import com.fabian.senapractica.rparksoft.dao.ServicioDAO;
import com.fabian.senapractica.rparksoft.dao.TarifaDAO;
import com.fabian.senapractica.rparksoft.dao.UsuarioDAO;
import com.fabian.senapractica.rparksoft.dao.VehiculoDAO;
import com.fabian.senapractica.rparksoft.model.Servicio;
import com.fabian.senapractica.rparksoft.model.Tarifa;
import com.fabian.senapractica.rparksoft.model.Vehiculo;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author COMERCIAL
 */
public class PrincipalService {
    
    private String  idVehiculo,
                    tipoTarifa,
                    idSalida,
                    accion;
    private int     cantidadAutos=0,
                    cantidadMotos=0,
                    cantidadBicis=0,
                    valorPagar;
    private long    horas;
    private Boolean ingresoExitoso = Boolean.FALSE,
                    salidaExitoso = Boolean.FALSE, 
                    membresiaVencida= Boolean.TRUE,
                    renovacionExitosa= Boolean.FALSE;
    private FacturaDAO  facturaDAO;
    private ServicioDAO servicioDAO;
    private VehiculoDAO vehiculoDAO;
    private TarifaDAO   tarifaDAO;
    private DateTimeFormatter formatter;

     public PrincipalService(){
        servicioDAO = new ServicioDAO();
    }
    
    public PrincipalService(String idVehiculo, String tipoTarifa, String idSalida, String accion) {
        this();
        this.idVehiculo = idVehiculo;
        this.tipoTarifa = tipoTarifa;
        this.idSalida = idSalida;
        this.accion = accion;        
    }
    
    public List<Servicio> listarServicios(){
        
        List<Servicio> servicios = new ArrayList<>();
        servicioDAO.consultarServicios();
        servicios = servicioDAO.getServicios();
        return servicios;
    }
    
    public void contarVehiculosPorTipo(){
        
        List<Servicio> vehiculosEnServicio = new ArrayList<>();
        vehiculosEnServicio = servicioDAO.consultarVehiculosEnServicio();
        
        for(Servicio s : vehiculosEnServicio){
            switch (s.getVehiculo().getTipo()) {
                case "Automovil":
                    cantidadAutos++;
                    break;
                case "Motocicleta":
                    cantidadMotos++;
                    break;
                case "Bicicleta":
                    cantidadBicis++;
                    break;                    
                default:
                    
            }
        }
    }

    public void validarAccion(){
        
        switch (accion) {
            case "ingreso":
                this.realizarIngreso();
                break;
            case "salida":
                this.realizarSalida();
                break;
            case "renovacion":
                this.renovarMembresia();
                break;                  
            default:
        }
        
    }
    
    private void realizarIngreso(){
        
        vehiculoDAO = new VehiculoDAO();
        tarifaDAO = new TarifaDAO();
        
        Vehiculo vehiculo = vehiculoDAO.consultarPorId(idVehiculo);
        Tarifa tarifa = tarifaDAO.consultarPorVehiculoTipo(vehiculo.getTipo(),tipoTarifa);
        //en caso de que sea cliente con membresia debemos validarlo al ingreso, para evitar hacerlo si no la renueva
        //este metodo retorna true si, el cliente NO es de membresia mensual o en caso de serlo y contar con su membresia vigente
        if(this.validarMembresiaVigenciaIngreso(tarifa,vehiculo)){
            servicioDAO.insertarServicio(vehiculo,tarifa,fechaHoraActual());
            ingresoExitoso = Boolean.TRUE;
        }
        else{
            membresiaVencida = Boolean.TRUE;
        }
    }
    
    private void realizarSalida(){
        
        servicioDAO.consultarSalidaPorId(Integer.parseInt(idSalida));
        /*esta condicional es obtenida desde el DAO, indica que si no se encontro un servicio por el ID se procede a buscar por el vehiculo, asumiento que la ID
        ingresada es entonces el del vehiculo*/
        if(servicioDAO.isValidacionId() == false){
            
            vehiculoDAO = new VehiculoDAO();
            servicioDAO.consultarSalidaPorVehiculo(vehiculoDAO.consultarPorId(idSalida));
        }
        
        this.ingresarFactura();
        servicioDAO.eliminarServicio();
        
        if(servicioDAO.getServicio() == null){
            salidaExitoso = Boolean.TRUE;
        }
    }
    //este metodo valida si el cliente es de membresia mensual, y en caso de serlo, valida si esta vigente
    private Boolean validarMembresiaVigenciaIngreso(Tarifa tarifa, Vehiculo vehiculo){
        
        Boolean vigencia = Boolean.TRUE;
        
        //validamos si el cliente tiene una tarifa del tipo membresia mensual
        if(tarifa.getTipo().equals("Membresia mensual")){
            
            //reutilizamos el metodo de calcular el tiempo establecido que se usa en la salida, para la validacion de la membresia, la cual da valor al
            //atributo global horas
            this.calcularTiempoTranscurrido(vehiculo.getUsuario().getFechaHoraMembresia());
            //dividimos entre la cantidad de horas que tiene el dia, asi obtenemos los dias transcurridos
            int dias = (int) (horas/24);
            int diasRestantes = 30 - dias;
            
            if(diasRestantes <= 0){
                vigencia = Boolean.FALSE;
            }
        }
        
        return vigencia;
    }
    
    private boolean renovarMembresia() {
        
        vehiculoDAO = new VehiculoDAO();
        renovacionExitosa = UsuarioDAO.actualizarFechaHoraMembresia(vehiculoDAO.consultarPorId(idVehiculo),this.fechaHoraActual());
        
        return renovacionExitosa;
    }
    
    private void ingresarFactura(){
       
        this.calcularTiempoTranscurrido(servicioDAO.fechaHoraIngresoVehiculo());
        this.calcularTarifa();
        facturaDAO = new FacturaDAO();
        
        facturaDAO.insertarFactura(servicioDAO.getServicio(),this.fechaHoraActual(),valorPagar);
        
    }
    
    private void calcularTiempoTranscurrido(String fechaInicial){
        
        //obtenemos la fecha de ingreso al parking de la base de datos, pero como esta en String debemos convertirla a LocalDateTime con la funcion parse, pasando la fecha y el formato
        LocalDateTime fechaIngresoParking = LocalDateTime.parse(fechaInicial,formatter);
        //con la clase Duration podemos obtener el tiempo transcurrido entre la entrada y salida del vehiculo
        Duration duracion = Duration.between(fechaIngresoParking,LocalDateTime.now());
        
        //obtenemos con las respectivas funciones las horas y los minutos transcurridos (minutos sobrantes de las horas, modulo de 60)
        horas = duracion.toHours();
        long minutos= duracion.toMinutes()%60;
        
        if(minutos > 0){
            horas += 1;
        }
        
    }
    
    private void calcularTarifa(){
                
        valorPagar = (int) (servicioDAO.getServicio().getTarifa().getPrecio() * horas);
        
    }
    private String fechaHoraActual(){
        
        LocalDateTime actual = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return actual.format(formatter);
    }

    public Boolean getIngresoExitoso() {
        return ingresoExitoso;
    }
    
    public Boolean getSalidaExitoso() {
        return salidaExitoso;
    }
    
    public int getValorPagar() {
        return valorPagar;
    }

    public Boolean getMembresiaVencida() {
        return membresiaVencida;
    }

    public Boolean getRenovacionExitosa() {
        return renovacionExitosa;
    }

    public int getCantidadAutos() {
        return cantidadAutos;
    }

    public int getCantidadMotos() {
        return cantidadMotos;
    }

    public int getCantidadBicis() {
        return cantidadBicis;
    }
    
    
    
}
