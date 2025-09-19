/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.fabian.senapractica.rparksoft.servlets;

//import com.fabian.senapractica.rparksoft.controller.CtrlPrincipal;
import com.fabian.senapractica.rparksoft.model.Servicio;
import com.fabian.senapractica.rparksoft.service.PrincipalService;
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
        
        PrincipalService principal = new PrincipalService();
        //creamos una lista para pasarla al JSP a traves del atributo de sesion
        List<Servicio> servicios = principal.listarServicios();
        
        principal.contarVehiculosPorTipo();
        
        HttpSession session = request.getSession();
        session.setAttribute("registros", servicios);
        session.setAttribute("cantidadCarros", principal.getCantidadAutos());
        session.setAttribute("cantidadMotos", principal.getCantidadMotos());
        session.setAttribute("cantidadBicicletas", principal.getCantidadBicis());
        response.sendRedirect("principal.jsp");
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String idVehiculo = request.getParameter("idVehiculo");
        String tipoTarifa = request.getParameter("tipoTarifa");
        String idSalida = request.getParameter("idSalida");
        String accion = request.getParameter("accion");
        
        PrincipalService principal = new PrincipalService(idVehiculo, tipoTarifa, idSalida, accion);
        principal.validarAccion();
        
        //ademas de session, otra manera de pasar atributos al JSP es mediante request, se hace asi:
        request.setAttribute("valorPagar", principal.getValorPagar());
        request.setAttribute("ingresoExitoso", principal.getIngresoExitoso());
        request.setAttribute("membresiaVencida", principal.getMembresiaVencida());
        request.setAttribute("valorPagar", principal.getValorPagar());
        request.setAttribute("renovacionExitosa", principal.getRenovacionExitosa());
        request.setAttribute("salidaExitosa", principal.getSalidaExitoso());
        request.setAttribute("idVehiculo", idVehiculo);
        request.getRequestDispatcher("principal.jsp").forward(request, response);
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
