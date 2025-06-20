<%-- 
    Document   : ingreso
    Created on : 12/06/2025, 1:51:59 p. m.
    Author     : COMERCIAL
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>               
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">                 
        <title>Ingreso de vehiculo</title>
    </head>
    <body class="bg-primary bg-opacity-75">
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>        
        <div class="row">
            <div class="col">
              <img class="img-fluid m-3" src="images/logo.png" style="max-width:350px"/><br>
            </div>
        </div>
        <script>
            function ingreso(){
                document.getElementById("seleccion").value="ingreso";
                document.getElementById("formIngresoRetiro").submit();
            }
            function salida(){
                document.getElementById("seleccion").value="salida";
                document.getElementById("formIngresoRetiro").submit();
            }            
        </script>
        <form id="formIngresoRetiro" action="SvPrincipal" method="POST">
            
            <div class="row m-2">                
                <div class="col-md-3 text-rignt ms-5">
                <label class="fs-1 fw-bold fst-italic">Tipo de vehiculo</label>
                </div>
                
                <div class="col-md-5">
                    <select class="form-select" id="floatingSelect" aria-label="Elija uno" name="tipoVehiculo">
                    <option value="moto">Motocicleta</option>
                    <option value="carro">Carro</option>
                    <option value="bicicleta">Bicicleta</option>
                    </select>
                </div>
                <div class="col-md-3 d-flex justify-content-center">
                     <button type="button" onclick="ingreso()" class="btn btn-secondary btn-lg">Ingreso</button>
                </div>
            </div>
            
            <div class="row m-2">
                <div class="col-md-3 text-start ms-5">
                    <label class="fs-1 fw-bold fst-italic">Placa</label>
                </div>    
                <div class="col-md-5">
                    <input class="form-control" type="text" name="placa">
                </div>
               
            </div>
            
            <div class="row">
                <div class="col">
                    <hr class="border border-secondary border-3 opacity-75">
                </div>
            </div>

            <div class="row m-5">
                <div class="col-md-2 text-start ms-5">
                    <label class="fs-3 fw-bold fst-italic">Numero de factura</label>                    
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="type" name="numeroSalida">                
                </div>
                <div class="col-md-2 text-start ms-5 text-end">
                    <label class="fs-3 fw-bold fst-italic">Placa</label>                    
                </div>
                <div class="col-md-2">
                    <input class="form-control justify-content-start" type="type" name="placaSalida">                
                </div>
                <div class="col-md-2 d-flex justify-content-end">
                    <button type="button" onclick="salida()" class="btn btn-secondary btn-lg">Salida</button>
                </div>
            </div>
            
            <input type="hidden" name="accion" id="seleccion" value="">

        </form>
        
        <div class="row">
            <div class="col">
                <hr class="border border-secondary border-3 opacity-75">
            </div>
        </div>
            
        <div class="row m-3">
        </div>
        
        <form action="SvPrincipal" method="GET">
            
            <div class="row ms-3 m-3">
                <div class="col-md-2">
                    <label class="fw-normal fs-3">Cantidad de vehiculos</label>
                </div>
                <div class="col-md-2 d-flex justify-content-end">
                    <label class="fw-normal fs-4">Carros</label>
                </div>
                <div class="col-md-1">
                    <input class="form-control" type="text" name="cantCarros" disabled value="${cantidadCarros}">
                </div>
                <div class="col-md-2 d-flex justify-content-end">
                    <label class="fw-normal fs-4">Motocicletas</label>
                </div>
                <div class="col-md-1">
                    <input class="form-control" type="text" name="cantMotos" disabled value="${cantidadMotos}">
                </div>
                <div class="col-md-2 d-flex justify-content-end">
                    <label class="fw-normal fs-4">Bicicletas</label>
                </div>     
                <div class="col-md-1">
                    <input class="form-control" type="text" name="cantBicis" disabled value="${cantidadBicicletas}">  
                </div>        
            </div>

            <div class="row">
            </div>
            
            <div class="row m-5 ">
                <div class="col-md-11">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Tipo</th>
                                <th>Placa</th>
                                <th>Fecha y Hora</th>
                                <th>Factura</th>
                            </tr>
                        </thead>
                        <c:forEach var="item" items="${sessionScope.registros}">
                        <tbody>
                            <tr>
                                <td><c:out value="${item.getTipoVehiculo()}"/></td>
                                <td><c:out value="${item.getPlaca()}"/></td>
                                <td><c:out value="${item.getFechaHora()}"/></td>
                                <td><c:out value="${item.getIdFactura()}"/></td>
                            </tr>
                        </tbody>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-1">
                    <button class="btn btn-secondary btn-lg">Refrescar</button>
                </div>
            </div>                
        </form>
    </body>
</html>
