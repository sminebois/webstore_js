<%-- 
    Document   : _MENU
    Created on : 29 juin 2016, 16:21:04
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href='home.jsp'>Page d'accueil</a>
<c:choose>   

    <c:when test="${utilconnecte.utilType=='ADMIN'}">

        <a href="ajout_article">Ajouter article</a>
        <a href="stock">Stock</a>
    </c:when>
    <c:when test="${utilconnecte.utilType=='EXPEDITEUR'}">
        <a href="commandes">Voir commandes</a>
    </c:when>
</c:choose>

<c:choose>
    <c:when test="${utilconnecte.login==null}">

        <a class="liensmenu" href="connect">Connexion</a>
    </c:when>
    <c:otherwise>
        <a href="articles">Voir articles</a>
        <a class="liensmenu" href="deconnect">Déconnexion</a>
    </c:otherwise>
</c:choose>