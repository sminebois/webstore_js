<%-- 
    Document   : commandes
    Created on : 1 juil. 2016, 15:21:14
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
                <c:when test="${(utilconnecte.utilType=='ADMIN') or (utilconnecte.utilType=='EXPEDITEUR')}">
                    <h1>Commandes</h1>
                    <c:forEach items="${lcommande}" var="cmd">
                        <strong>${cmd.client.login}</strong> | ${cmd.dateCommande} | ${cmd.total} €<br>
                        <c:forEach items="${cmd.larticle}" var="art">
                              - ${art.nom}<br>
                        </c:forEach>
                        <br>
                    </c:forEach>                    
                    
                    
                    
                </c:when>
            </c:choose>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>