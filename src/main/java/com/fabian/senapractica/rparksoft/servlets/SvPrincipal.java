/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.controller.CtrlPrincipal;
import com.fabian.senapractica.rparksoft.model.EntityPrincipal;
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
@WebServlet(name = "SvPrincipal", urlPatterns = {"/SvPrincipal"})
public class SvPrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        CtrlPrincipal p = new CtrlPrincipal();
        p.consulta();
        
        List<EntityPrincipal> registros = p.getRegistros();
        
        registros.forEach(item ->{
            System.out.println("tipo = "+item.getTipoVehiculo());
            System.out.println("placa = "+item.getPlaca());
            System.out.println("fecha y hora = "+item.getFechaHora());
            System.out.println("id factura = "+item.getIdFactura());
        });
        
        int cantidadCarros = p.cantidadCarros().intValue();
        int cantidadMotos = p.cantidadMotos().intValue();
        int cantidadBicicletas = p.cantidadBicicletas().intValue();
        
        HttpSession session = request.getSession();
        session.setAttribute("registros", registros);
        session.setAttribute("cantidadCarros", cantidadCarros);
        session.setAttribute("cantidadMotos", cantidadMotos);
        session.setAttribute("cantidadBicicletas", cantidadBicicletas);
        
        response.sendRedirect("principal.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var tipo = request.getParameter("tipoVehiculo");
        var placa = request.getParameter("placa");
        var accion = request.getParameter("accion");
        var numeroFactura = request.getParameter("numeroSalida");
        var placaSalida = request.getParameter("placaSalida");
        
        CtrlPrincipal p = new CtrlPrincipal(tipo,placa,accion,numeroFactura,placaSalida);
        p.accion();

        response.sendRedirect("principal.jsp");

    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
