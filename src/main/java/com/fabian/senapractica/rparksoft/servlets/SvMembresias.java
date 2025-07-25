/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.controller.CtrlMembresias;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author COMERCIAL
 */
@WebServlet(name = "SvMembresias", urlPatterns = {"/SvMembresias"})
public class SvMembresias extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var id = request.getParameter("id");
        var accion = request.getParameter("accion");
                
        CtrlMembresias membresias = new CtrlMembresias();
        membresias.validarAccion(id, accion);
        
        int diasRestantes = membresias.getDiasRestantes().intValue();
        Boolean vigenciaActiva = membresias.getVigenciaActiva();
        Boolean vigenciaVencida = membresias.getVigenciaVencida();
        Boolean renovacionExitosa = membresias.getRenovacionExitosa();
        
        HttpSession session = request.getSession();
        session.setAttribute("diasRestantes", diasRestantes);
        session.setAttribute("vigenciaActiva", vigenciaActiva);
        session.setAttribute("vigenciaVencida",vigenciaVencida);
        session.setAttribute("renovacionExitosa", renovacionExitosa);
        session.setAttribute("id", id);
        
        response.sendRedirect("membresias.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var id = request.getParameter("id");
        var nombre = request.getParameter("nombre");
        var apellido = request.getParameter("apellido");
        var tipoVehiculo = request.getParameter("tipoVehiculo");
        var placa = request.getParameter("placa");
        var telefono = request.getParameter("telefono");
        var direccion = request.getParameter("direccion");
        
        CtrlMembresias membresias = new CtrlMembresias(id,
                                                        nombre,
                                                        apellido,
                                                        tipoVehiculo,
                                                        placa,
                                                        telefono,
                                                        direccion);
        
        membresias.insertarMembresia();
        
        response.sendRedirect("membresias.jsp");
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
