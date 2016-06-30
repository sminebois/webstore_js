/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webstore.entity.Article;
import webstore.entity.Commande;

/**
 *
 * @author admin
 */
@WebServlet(name = "PanierServlet", urlPatterns = {"/panier"})
public class PanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commande cmd = (Commande) req.getSession().getAttribute("commande");
        List<Article> la = new ArrayList<>();
        la = cmd.getLarticle();
        req.setAttribute("larticle", la);
        
        
        req.getRequestDispatcher("panier.jsp").forward(req, resp);
    }
    
}
