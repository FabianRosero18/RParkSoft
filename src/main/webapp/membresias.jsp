<%-- 
    Document   : membresias
    Created on : 18/07/2025, 12:20:31 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                    <option value="moto">Motocicleta</option>
                                    <option value="automovil">Automovil</option>
                                    <option value="bicicleta">Bicicleta</option>
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
            
            <<form action="SvMembresias" method="GET">
                
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
                    <input class="form-control" type="text" name="id">   
                </div>
                <div class="col-md-2  text-end">
                    <label class="fw-semibold fs-5 ">Dias restantes</label> 
                </div>
                <div class="col-md-1">
                    <input class="form-control" type="text" name="dias" disabled="true">   
                </div>
                <div class="col-md-1 d-grid gap-5 align-self-end offset-md-1">
                    <button class="btn btn-secondary btn-lg">Ingresar</button>
                </div>
            </div>    
            </form>
                
            <br>

            <div class="row">
                <div class="col">
                        
                </div>
            </div>                
                
                
        
        
    </body>
</html>
