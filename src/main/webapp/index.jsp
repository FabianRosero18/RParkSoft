<%-- 
    Document   : index
    Created on : 11/06/2025, 2:05:49 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loggin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">         
    </head>
    <body class="bg-primary bg-opacity-75">
        <%        
        String mensajeError = request.getParameter("validacion"); 
        if(mensajeError == null){
            mensajeError = "hidden";
        }
        %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js" integrity="sha384-j1CDi7MgGQ12Z7Qab0qlWQ/Qqz24Gc6BM0thvEMVjHnfYGF0rmFCozFSxQBxwHKO" crossorigin="anonymous"></script>        
         
        <div class="row">
            <div class="col">
              <img class="img-fluid m-3" src="images/logo.png" style="max-width:350px"/><br>
            </div>
        </div>
        
        <div class="container text-center">
           <div class="row">
               <div class="col-md-12">
                   <h1>Iniciar sesion</h1><br>
               </div>
           </div>
        </div>
                
        <form action="SvLoggin" method="GET">
            
            <div class="container text-center">
                <div class="row justify-content-center">
                    <div class="col-md-3">
                        
                    <label class="form-label blockquote text-center">Usuario</label><br>
                    <input type="text" class="form-control" name="usuario"><br>
                    <label class="form-label blockquote text-center">Contraseña</label><br>
                    <input type="password" class="form-control" name="contrasena"><br>
                    
                    </div>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-sm-2 mx-auto">
                    <p class="text-center" style="visibility:<%=mensajeError%>" >Usuario o contraseña incorrecta</p>
                </div>
            </div>
            <div class="row">
                <div class="d-grid gap-2 col-2 mx-auto">
                    <button class="btn btn-secondary btn-lg">Ingresar</button>
                </div>
            </div>
        </form>
    </body>
</html>
