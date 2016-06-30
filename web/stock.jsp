<%-- 
    Document   : stock
    Created on : 30 juin 2016, 13:21:13
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
                <c:when test="${utilconnecte.login==null}">
                    <br>
                    Connectez vous pour accéder a la boutique.
                </c:when>
                <c:otherwise>
                    <h2>Gestion des stocks</h2>
                    <br>
                    <c:forEach items="${larticle}" var="article">
                        <form method="post">
                            ${article.nom} | 
                            Quantité : <input type="number" value="${article.stock}" name="qtt" min="0"> 
                            Prix : <input type="number" value="${article.prix}" name="prix" min="0">
                            
                            <input type="hidden" value="${article.id}" name="id">                            
                            <input type="submit" value="Modifier"><br>
                        </form>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>