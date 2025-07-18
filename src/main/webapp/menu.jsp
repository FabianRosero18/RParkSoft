<%-- 
    Document   : menu
    Created on : 17/07/2025, 4:35:32 p. m.
    Author     : COMERCIAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <header>
        <form action="SvMenu" method="GET">
                
            <input name="direccionamiento" id="seleccion" type="hidden" value=""/>

            <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
                <div class="container-fluid justify-content-end">   
                  <a class="navbar-brand" href="#"></a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <!-- los botones tienen funciones javascript para enviarlo como valor a trabes del input tipo hidden al servlet y asi redireccionar -->
                            <button class="nav-link" aria-current="page" onclick="javascript:document.getElementById('seleccion').value = 'principal.jsp'">Principal</button>
                        </li>
                        <li class="nav-item">
                            <button class="nav-link" aria-current="page" onclick="javascript:document.getElementById('seleccion').value = 'membresias.jsp'">Membresias</button>
                        </li>
                        <li class="nav-item">
                            <button class="nav-link" aria-current="page" onclick="javascript:document.getElementById('seleccion').value = 'index.jsp'">Cerrar Sesion</button>
                        </li>
                    </ul>
                  </div>
                </div>
            </nav>
        </form>
    </header>
