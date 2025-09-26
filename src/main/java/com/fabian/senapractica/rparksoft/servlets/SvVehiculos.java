/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.service.VehiculoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @author COMERCIAL
 */
@WebServlet(name = "SvVehiculos", urlPatterns = {"/SvVehiculos"})
public class SvVehiculos extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var placa = request.getParameter("placa");
        var tipo = request.getParameter("tipo");
        var color = request.getParameter("color");
        var marca = request.getParameter("marca");
        var idUsuario = request.getParameter("idUsuario");
        var accion = request.getParameter("accion");
        
        VehiculoService vehiculo = new VehiculoService(placa,tipo,color,marca,idUsuario);
        vehiculo.validarAccion(accion);
        
        request.setAttribute("datosVehiculo", vehiculo.getDatosVehiculo());
        request.setAttribute("ingresoExitoso", vehiculo.getAccionExitosa());
        request.setAttribute("ingresoFallido", vehiculo.getAccionFallida());
        request.setAttribute("mensajeFallido", vehiculo.getMensajeFallido());
        request.setAttribute("botonEliminar", vehiculo.getBotonEliminar());
        //se usa request dispatcher para cargar el jsp sin eliminar los seteos de atributos de arriba
        request.getRequestDispatcher("vehiculos.jsp").forward(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
