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
                        ${art.nom} ${art.prix} €<br>
                        
                    </c:forEach>
                    <br>
                    <strong>Total : </strong>${total} €<br>
                    
                    <c:choose>
                        <c:when test="${larticle != null}">
                            <form method="post">
                                <input type="hidden" value="true" name="validation">
                                <input type="submit" value="Passer commande">
                            </form>
                            <form method="post">
                                <input type="hidden" value="false" name="validation">
                                <input type="submit" value="Vider mon panier">
                            </form>
                        </c:when>
                    </c:choose>
                    
                    
                </c:when>
            </c:choose>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>