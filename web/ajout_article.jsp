<%-- 
    Document   : ajout_article
    Created on : 30 juin 2016, 12:00:08
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
                <c:when test="${utilconnecte.utilType=='ADMIN'}">
                    <h2>Ajout d'article</h2>
                    <form method='post'>
                        Nom <input type="text" name='nom'><br>
                        Quantité <input type='number' min='0' name="qtt"><br>
                        Prix <input type='number' min='0' name="prix"><br>
                        <input type="submit" value='Ajouter'>
                    </form>
                </c:when>
            </c:choose>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>