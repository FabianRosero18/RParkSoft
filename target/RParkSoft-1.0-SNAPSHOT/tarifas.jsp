<%-- 
    Document   : tarifas
    Created on : 28/08/2025, 12:09:57 p. m.
    Author     : COMERCIAL
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">        
        <title>Tarifas</title>
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
            <br>   
        <form action="SvTarifas" method="GET">
                
            <div class="row m-2">
                <div class="col-md-6 text-end">
                    <label class="fw-semibold fs-5"> Tarifa actual Motocicleta</label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="motoActual" value="${sessionScope.valores.get(1)}" disabled>
                </div>
            </div>
            <div class="row m-2">
                <div class="col-md-6 text-end">
                    <label class="fw-semibold fs-5"> Tarifa actual Automovil</label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="autoActual" value="${sessionScope.valores.get(0)}" disabled>
                </div>
            </div>
            <div class="row m-2">
                <div class="col-md-6 text-end">
                    <label class="fw-semibold fs-5"> Tarifa actual Bicicleta</label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="biciActual" value="${sessionScope.valores.get(2)}" disabled>
                </div>
            </div>
            <div class="row m-4">
                <div class="d-grid gap-2 col-2 mx-auto">
                    <button class="btn btn-secondary btn-lg">Refrescar</button>
                </div>
            </div>
        </form>
            
            <div class="row">
                <div class="col">
                    <hr class="border border-secondary border-3 opacity-75">
                </div>
            </div>
            
            <div class="row m-2">
                <div class="col">
                    <label class="fs-1 fw-bold fst-italic">Modificacion de tarifas</label>    
                </div>
            </div>
            
            
        <form action="SvTarifas" method="POST">
                
            <div class="row m-2">
                <div class="col-md-6 text-end">
                    <label class="fw-semibold fs-5"> Nueva tarifa Motocicleta</label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="motoNueva" >
                </div>
            </div>
            <div class="row m-2">
                <div class="col-md-6 text-end">
                    <label class="fw-semibold fs-5"> Nueva tarifa Automovil</label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="autoNueva" >
                </div>
            </div>
            <div class="row m-2">
                <div class="col-md-6 text-end">
                    <label class="fw-semibold fs-5"> Nueva tarifa Bicicleta</label>
                </div>
                <div class="col-md-2">
                    <input class="form-control" type="text" name="biciNueva" >
                </div>
            </div>
            <div class="row m-4">
                <div class="d-grid gap-2 col-2 mx-auto">
                    <button class="btn btn-secondary btn-lg">Modificar</button>
                </div>
            </div>
        </form>            
            
    </body>
</html>
