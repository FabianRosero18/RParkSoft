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
            <div class="col m-5">
                <jsp:include page="menu.jsp" flush="true" />
            </div>
        </div>

        <form id="formIngresoRetiro" action="SvPrincipal" method="POST">
            
            <div class="row m-3">
                <div class="col">
                    <label class="fs-1 fw-bold fst-italic">INGRESO</label>    
                </div>
            </div>
           
            <div class="row m-2">
                <div class="col-md-4 text-end ms-1">
                    <label class="fs-3 fw-bold fst-italic">Placa o Codigo (bicicleta)</label>
                </div>    
                <div class="col-md-5 ms-3">
                    <input class="form-control" type="text" name="idVehiculo">
                </div>
                <div class="d-grid gap-2 col-md-1 mx-auto">
                        <!--se coloca el mismo name a los botones de ingreso y salida (accion) ya que en el servlet el campo tomara el value del boton oprimido, segun sea 
                            salida o entrada-->
                        <button type="submit" name="accion" value="ingreso" class="btn btn-secondary btn-lg">Ingreso</button>
                </div>
            </div>
            
            <div class="row m-1">
                <div class="col">
                    <hr class="border border-secondary border-3 opacity-75">
                </div>
            </div>
            
            <div class="row m-3">
                <div class="col">
                    <label class="fs-1 fw-bold fst-italic">SALIDA</label>    
                </div>
            </div>

            <div class="row m-3">
                <div class="col-md-4 text-end ms-1">
                    <label class="fs-3 fw-bold fst-italic">Numero de factura o placa</label>
                </div>    
                <div class="col-md-5 ms-3">
                    <input class="form-control" type="text" name="idSalida">
                </div>
                <div class="d-grid gap-2 col-md-1 mx-auto">
                   <!-- se coloca el mismo name a los botones de ingreso y salida (accion) ya que en el servlet el campo tomara el value del boton oprimido, segun sea 
                        salida o entrada-->
                    <button type="submit" name="accion" value="salida" class="btn btn-secondary btn-lg">Salida</button>
                </div>
            </div>
            <!-- usamos JSTL para validar si el mensaje de salida es exitoso, y lo mostramos usando el atributo pasado por Request.setParameter -->
            <c:if test="${mensajeSalida}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <p class="fs-3">valor a pagar $= ${valorPagar}. Recuerde refrescar la Tabla</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
        </form>
        
        <div class="row m-1">
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
                    <label class="fw-normal fs-4">Automoviles</label>
                </div>
                <div class="col-md-1">
                    <!-- atributo pasado por session, lo mostamos usando JSTL -->
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
                        <!-- mediante JSTL creamos un foreach para recorrer el arreglo de registros enviado por session desde el servlet -->
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