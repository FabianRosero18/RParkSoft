<%-- 
    Document   : membresias
    Created on : 18/07/2025, 12:20:31 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">                 
        <title>JSP Page</title>
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
                    <label class="fs-1 fw-bold fst-italic">Registro de membresia</label>    
                </div>
            </div>
                
            <br>
            <div class="row m-2">
                <div class="col-md-11">
                    <div class="row">

                        <div class="col-md-5 offset-md-1">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Numero de identificacion </label>
                                </div>
                            </div>    
                            <div class="row">    
                                <div class="col">
                                    <input class="form-control" type="text" name="id">   
                                </div>    
                            </div>                          
                        </div>   
                    </div>

                    <div class="row">

                        <div class="col-md-5 offset-md-1">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Nombre </label>
                                </div>
                            </div>    
                            <div class="row">    
                                <div class="col">
                                    <input class="form-control" type="text" name="nombre">   
                                </div>    
                            </div>        
                        </div>
                        <div class="col-md-5">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Apellido </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <input class="form-control" type="text" name="apellido">   
                                </div>    
                            </div>        
                        </div>                 
                    </div>

                    <div class="row">
              
                        <div class="col-md-5 offset-md-1">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Tipo de vehiculo </label>
                                </div>
                            </div>    
                            <div class="row">    
                                <div class="col">
                                    <select class="form-select" id="floatingSelect" aria-label="Elija uno" name="tipoVehiculo">
                                    <option value="Motocicleta">Motocicleta</option>
                                    <option value="Automovil">Automovil</option>
                                    <option value="Bicicleta">Bicicleta</option>
                                    </select>
                                </div>    
                            </div>        
                        </div>
                        <div class="col-md-5">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Placa </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <input class="form-control" type="text" name="placa">   
                                </div>    
                            </div>        
                        </div>                 
                    </div>

                    <div class="row">
              
                        <div class="col-md-5 offset-md-1">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Telefono </label>
                                </div>
                            </div>    
                            <div class="row">    
                                <div class="col">
                                    <input class="form-control" type="text" name="telefono">   
                                </div>    
                            </div>        
                        </div>
                        <div class="col-md-5">
                            <div class="row">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Direccion </label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <input class="form-control" type="text" name="direccion">   
                                </div>    
                            </div>        
                        </div>                 
                    </div>
                </div>
                <div class="col-md-1 d-grid gap-5 align-self-center">
                    <button class="btn btn-secondary btn-lg">Guardar</button>
                </div>
            </div>
            </form>
            
            
            <div class="row">
                <div class="col">
                    <hr class="border border-secondary m-3 border-3 opacity-75">
                </div>
            </div>
            
            <br>
            
            <form action="SvMembresias" method="GET">
                
            <div class="row m-2">
                <div class="col">
                    <label class="fs-1 fw-bold fst-italic">Ingreso de cliente membresia</label>    
                </div>
            </div>
            
            <br>
            
            <div class="row m-2">
                <div class="col-md-1">  
                </div>
                <div class="col-md-2">
                    <label class="fw-semibold fs-5">Numero de identificacion </label> 
                </div>
                <div class="col-md-3">
                    <input class="form-control" type="text" name="id" id="id">   
                </div>
                <div class="col-md-2  text-end">
                    <label class="fw-semibold fs-5 ">Dias restantes</label> 
                </div>
                <div class="col-md-1">
                    <input class="form-control" type="text" name="dias" disabled="true" value="${diasRestantes}">   
                </div>
                <div class="col-md-1 d-grid gap-5 align-self-end offset-md-1">
                    <button class="btn btn-secondary btn-lg" name="accion" value="ingreso">Ingresar</button>
                </div>
            </div>
                
                <c:if test="${vigenciaActiva}">
                <div class="row">
                    <div class="col">                    
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            <p class="fs-3">Cliente ingresado al parqueadero, no olvide refrescar el listado en modulo principal</p>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </div>
                </div>    
                </c:if>
                
                <c:if test="${vigenciaVencida}">
                <script>
                    document.getElementById("id").value = "${sessionScope.id}";
                </script>
                <div class="row">
                    <div class="col-md-10">
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <p class="fs-3">Cliente con vigencia vencida, debe renovarse</p>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </div>
                    <div class="col-md-1 d-grid gap-5 align-self-center">
                        <button class="btn btn-secondary btn-lg" name="accion" value="renovacion">Click aqui para renovar</button>
                    </div>
                </div>                       
                </c:if>

                <c:if test="${renovacionExitosa}">                
                <div class="row">
                    <div class="col">
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                <p class="fs-3">Renovacion realizada con exito, proceda con el formulario de ingreso</p>
                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                            </div>  
                    </div>
                </div>                   
                </c:if>
            </form>
                
            <br>
            
              
                
                
        
        
    </body>
</html>
