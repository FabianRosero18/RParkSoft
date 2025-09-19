/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

import com.fabian.senapractica.rparksoft.service.TarifaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        
        TarifaService tarifas = new TarifaService();
        tarifas.listarTarifas();
        
        HttpSession session = request.getSession();
        session.setAttribute("precios", tarifas.precios());
        response.sendRedirect("tarifas.jsp");
        
        
        /*System.out.println("usuario conectado: "+session.getAttribute("usuario"));
        session.invalidate();*/
        
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //esta lista es de string porque necesitamos validar primero si viene vacia o con otro formato, antes de convertirla a int
        List<String> precios = new ArrayList<>();
        
        precios.add(request.getParameter("motoHora"));
        precios.add(request.getParameter("autoHora"));
        precios.add(request.getParameter("biciHora"));
        precios.add(request.getParameter("motoDia"));
        precios.add(request.getParameter("autoDia"));
        precios.add(request.getParameter("biciDia"));
        precios.add(request.getParameter("motoMensual"));
        precios.add(request.getParameter("autoMensual"));
        precios.add(request.getParameter("biciMensual"));
        
        TarifaService tarifas = new TarifaService();
        tarifas.setPreciosModificar(precios);
        tarifas.validarTarifasActualizar();
        
        response.sendRedirect("tarifas.jsp");

        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
                                                                                    
}
