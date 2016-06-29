<%-- 
    Document   : _MENU
    Created on : 29 juin 2016, 16:21:04
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<a href='home.jsp'>Page d'accueil</a>
<a class="liensmenu" href="film_liste">Films</a>
<a class="liensmenu" href="serie_liste">Séries</a>
<c:choose>   

    <c:when test="${utilconnecte.type=='ADMIN'}">

        <a class="liensmenu" href="form">Ajouter film</a>
        <a class="liensmenu" href="form_serie">Ajouter série</a>
    </c:when>
</c:choose>
<c:choose>
    <c:when test="${utilconnecte.nom==null}">

        <a class="liensmenu" href="connect">Connexion</a>
    </c:when>
    <c:otherwise>
        <a class="liensmenu" href="deconnect">Déconnexion</a>
    </c:otherwise>
</c:choose>