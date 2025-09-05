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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


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
        
        VehiculoService vehiculo = new VehiculoService(placa,tipo,color,marca,idUsuario);
        vehiculo.crearVehiculo();
        response.sendRedirect("vehiculos.jsp");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
