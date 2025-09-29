<%-- 
    Document   : usuarios
    Created on : 3/09/2025, 4:41:05 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">                 
        <title>Usuarios</title>
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
            
            <form action="SvUsuarios" method="POST">
                
            <div class="row m-2">
                <div class="col">
                    <label class="fs-1 fw-bold fst-italic">Registro de usuario</label>    
                </div>
            </div>
                
            <br>
            <div class="row m-2">
                <div class="col-md-11">
                    <div class="row m-3">

                        <div class="col-md-5 offset-md-1">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Numero de identificacion</label>
                                </div>
                            </div>    
                            <div class="row m-2">    
                                <div class="col">
                                    <input class="form-control" type="text" name="id" value="${datosUsuario['id']}">   
                                </div>    
                            </div>        
                        </div>
                        <div class="col-md-5">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Nombre y apellido</label>
                                </div>
                            </div>
                            <div class="row m-2">
                                <div class="col">
                                    <input class="form-control" type="text" name="nombre" value="${datosUsuario['nombre']}">   
                                </div>    
                            </div>        
                        </div>                 
                    </div>

                    <div class="row m-3">
              
                        <div class="col-md-5 offset-md-1">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Telefono</label>
                                </div>
                            </div>    
                            <div class="row m-2">    
                                <div class="col">
                                    <input class="form-control" type="text" name="telefono" value="${datosUsuario['telefono']}">   
                                </div>    
                            </div>                          
                        </div>  
                        
                        <div class="col-md-5">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Correo</label>
                                </div>
                            </div>
                            <div class="row m-2">
                                <div class="col">
                                    <input class="form-control" type="text" name="correo" value="${datosUsuario['correo']}">   
                                </div>    
                            </div>        
                        </div>                 
                    </div>
                    <div class="row m-3">
                        <div class="col-md-5 offset-md-1">
                            <div class="row m-2">
                                <div class="col">
                                    <label class="fw-semibold fs-5">Membresia mensual</label>
                                </div>
                            </div>
                            <div class="row m-2">
                                <div class="col">
                                    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                                    <input type="radio" class="btn-check" name="membresia" id="btnradio1" 
                                        value="true" autocomplete="off"
                                        <%-- lo siguiente valida si el atributo es true o false y selecciona segun el que corresponde al usuario--%>
                                        ${datosUsuario["membresia"] eq 'true' ? "checked" : ""}>
                                    <label class="btn btn-outline-dark fw-bold bg-info w-50" for="btnradio1">SI</label>

                                    <input type="radio" class="btn-check" name="membresia" id="btnradio2" 
                                        value="false" autocomplete="off"
                                        ${datosUsuario["membresia"] eq 'false' ? "checked" : ""}>
                                    <label class="btn btn-outline-dark fw-bold bg-info w-50" for="btnradio2">NO</label>
                                    </div>
                                </div>    
                            </div>
                        </div>   
                    </div>    
                </div>
            </div>
            <c:if test="${ingresoExitoso}">
                <div class="row">
                    <div class="col">                    
                        <div class="alert alert-success alert-dismissible fade show" role="alert">
                            <p class="fs-3">Accion realizada con exito</p>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </div>
                </div>    
            </c:if>
            <c:if test="${ingresoFallido}">
                <div class="row">
                    <div class="col">                    
                        <div class="alert alert-danger alert-dismissible fade show" role="alert">
                            <p class="fs-3">ERROR: ${mensajeFallido}</p>
                            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                        </div>
                    </div>
                </div>    
            </c:if>            
            <div class="row m-5">
                <div class="col-md-2 offset-md-1 d-grid gap-4 align-self-center">
                    <button class="btn btn-secondary btn-lg" name="accion" value="consultar">Consultar</button>
                </div>
                <div class="col-md-2 offset-md-2 d-grid gap-4 align-self-center">
                    <button class="btn btn-secondary btn-lg" name="accion" value="guardar">Guardar</button>
                </div>
                <c:if test="${botonEliminar}">
                <div class="col-md-2 offset-md-2 d-grid gap-4 align-self-center">
                    <button class="btn btn-secondary btn-lg" name="accion" value="eliminar">Eliminar</button>
                </div>
                </c:if>
            </div>
        </form>
    </body>
</html>

