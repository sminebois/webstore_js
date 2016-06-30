<%-- 
    Document   : panier
    Created on : 30 juin 2016, 16:02:32
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONSOMMEZ BANDE DE !</title>            
    </head>
    <body>
        <div class="titre">
            <c:import url="_TITRE.jsp"/>
        </div>
        <div class="menu">
            <c:import url="_MENU.jsp"/>
        </div>
        <div class="contenu">     
            <c:choose>
                <c:when test="${utilconnecte.login!=null}">
                    <h1>Mon panier</h1>
                    <c:forEach items="${larticle}" var="art">
                        ${art.nom}<br>
                        
                        
                    </c:forEach>
                </c:when>
            </c:choose>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>