<%-- 
    Document   : connect
    Created on : 30 juin 2016, 09:17:32
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
            <h1>Connexion</h1>
            <a href="inscription">Inscription</a><br>
            <form method="post">
                Login <input type="text" name="login"><br>
                Mot de passe <input type="password" name="mdp"><br>
                <input type="submit" value="Connexion">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>