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
        
        //creamos una lista para pasarla al JSP a traves del atributo de sesion
        List<EntityPrincipal> registros = p.getRegistros();
        
        
        int cantidadCarros = p.cantidadCarros().intValue();
        int cantidadMotos = p.cantidadMotos().intValue();
        int cantidadBicicletas = p.cantidadBicicletas().intValue();
        
        //creando un atributo de sesion para pasar los parametros al JSP
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
        
        String  tipo = request.getParameter("tipoVehiculo");
        String  placa = request.getParameter("placa");
        String  accion = request.getParameter("accion");
        String  numeroFactura = request.getParameter("numeroSalida");
        String  placaSalida = request.getParameter("placaSalida");
                
        CtrlPrincipal p = new CtrlPrincipal(tipo,placa,accion,numeroFactura,placaSalida);
        p.accion();
        
        //ademas de session, otra manera de pasar atributos al JSP es mediante request, se hace asi:
        request.setAttribute("valorPagar", p.getValorPagar());
        request.setAttribute("mensajeSalida", p.getMensajeSalida());
        request.getRequestDispatcher("principal.jsp").forward(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
