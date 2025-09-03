<%-- 
    Document   : vehiculos
    Created on : 3/09/2025, 5:01:26 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">                 
        <title>Vehiculos</title>
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
            
            <form action="SvMembresias" method="POST">
                
            <div class="row m-2">
                <div class="col">
                    <label class="fs-1 fw-bold fst-italic">Registro de vehiculo</label>    
                </div>
            </div>
                
            <br>
            <div class="row m-2">
                <div class="col-md-11">

                    <div class="row m-3">

                        <div class="col-md-5 offset-md-1">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Placa</label>
                                </div>
                            </div>    
                            <div class="row m-2">    
                                <div class="col">
                                    <input class="form-control" type="text" name="placa">   
                                </div>    
                            </div>        
                        </div>
                        <div class="col-md-5">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Tipo de vehiculo </label>
                                </div>
                            </div>    
                            <div class="row m-2">    
                                <div class="col">
                                    <select class="form-select" id="floatingSelect" aria-label="Elija uno" name="tipo">
                                    <option value="Motocicleta">Motocicleta</option>
                                    <option value="Automovil">Automovil</option>
                                    <option value="Bicicleta">Bicicleta</option>
                                    </select>
                                </div>    
                            </div>        
                        </div>               
                    </div>

                    <div class="row m-3">
              
                        <div class="col-md-5 offset-md-1">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Color</label>
                                </div>
                            </div>    
                            <div class="row m-2">    
                                <div class="col">
                                    <input class="form-control" type="text" name="color">   
                                </div>    
                            </div>                          
                        </div>  
                        
                        <div class="col-md-5">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Marca</label>
                                </div>
                            </div>
                            <div class="row m-2">
                                <div class="col">
                                    <input class="form-control" type="text" name="marca">   
                                </div>    
                            </div>        
                        </div>                 
                    </div>
                </div>
            </div>
            <div class="row m-2">
                <div class="col-md-5 offset-md-1">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Identificacion usuario</label>
                                </div>
                            </div>
                            <div class="row m-2">
                                <div class="col">
                                    <input class="form-control" type="text" name="idUsuario">   
                                </div>    
                            </div>                     
                </div>
            </div>
            <div class="row m-5">
                <div class="col-md-2 offset-md-5 d-grid gap-5 align-self-center">
                    <button class="btn btn-secondary btn-lg">Guardar</button>
                </div>
            </div>
        </form>
            
            
            <br>

    </body>
</html>

