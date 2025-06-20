/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.controller.CtrlLoggin;
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
@WebServlet(name = "SvLoggin", urlPatterns = {"/SvLoggin"})
public class SvLoggin extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        var usuario = request.getParameter("usuario");
        var contrasena = request.getParameter("contrasena");
        
        CtrlLoggin loggin = new CtrlLoggin(usuario,contrasena);
        loggin.validacion();
        String validacion = loggin.GetValidacion();
        String direccionamiento = loggin.getDireccionamiento();
        
        response.sendRedirect(direccionamiento+"?validacion="+validacion);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
