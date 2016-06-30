<%-- 
    Document   : articles
    Created on : 30 juin 2016, 12:45:55
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
                    <h2>Articles en vente</h2>
                    <br>
                    <table>
                        <tr>
                            <th>Nom</th>
                            <th>Prix</th>
                            <th>Quantité restante</th>
                            <th>Quantité commandée</th>
                        </tr>
                        <c:forEach items="${larticle}" var="article">
                            <tr>
                                <form method="post">
                                    <td>${article.nom}</td>
                                    <td>${article.prix} €</td>
                                    <td>${article.stock}</td>
                                    <td><input type="number" value="0" min="0" max="${article.stock}" name="qtt">
                                        <input type="submit" value="Ajouter au panier"></td>
                                    <input type="hidden" value="${article.id}" name="id">
                                </form>
                            </tr>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>