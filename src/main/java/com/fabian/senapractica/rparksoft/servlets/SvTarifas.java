/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.controller.CtrlTarifas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author COMERCIAL
 */
@WebServlet(name = "SvTarifas", urlPatterns = {"/SvTarifas"})
public class SvTarifas extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        CtrlTarifas tarifas = new CtrlTarifas();
        tarifas.consultarTarifas();
        ArrayList<Integer> valores = tarifas.getValor();
        
        HttpSession session = request.getSession();
        session.setAttribute("valores", valores);
        
        response.sendRedirect("tarifas.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var tarifaMotocicleta = request.getParameter("motoNueva");
        var tarifaAutomovil = request.getParameter("autoNueva");
        var tarifaBicicleta = request.getParameter("biciNueva");
        
        CtrlTarifas tarifas = new CtrlTarifas();
        tarifas.setTarifaMotocicleta(tarifaMotocicleta);
        tarifas.setTarifaAutomovil(tarifaAutomovil);
        tarifas.setTarifaBicicleta(tarifaBicicleta);
        tarifas.validarTarifaActualizar();
        
        response.sendRedirect("tarifas.jsp");

        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
