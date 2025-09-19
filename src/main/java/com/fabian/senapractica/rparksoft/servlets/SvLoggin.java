/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.service.LoginService;
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
        
        LoginService login = new LoginService(usuario,contrasena);
        login.validacion();
        
        HttpSession session = request.getSession();
        session.setAttribute("usuario", login.getUsuario());
        
        String validacion = login.getValidacion();
        String direccionamiento = login.getDireccionamiento();
        
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
