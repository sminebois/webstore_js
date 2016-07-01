/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webstore.entity.Article;
import webstore.entity.Commande;
import webstore.entity.Utilisateur;
import webstore.service.ArticleService;
import webstore.service.CommandeService;

/**
 *
 * @author admin
 */
@WebServlet(name = "PanierServlet", urlPatterns = {"/panier"})
public class PanierServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commande cmd;
        List<Article> la = new ArrayList<>();
        int total = 0;
        
        la.clear();

        if (req.getSession().getAttribute("commande") != null) {
            cmd = (Commande) req.getSession().getAttribute("commande");
            la = cmd.getLarticle();
            req.setAttribute("larticle", la);
            total = cmd.getTotal();
        }

        req.setAttribute("total", total);

        req.getRequestDispatcher("panier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commande cmd;
        List<Article> la = new ArrayList<>();
        cmd = (Commande) req.getSession().getAttribute("commande");
        la = cmd.getLarticle();
        
        if (Boolean.parseBoolean(req.getParameter("validation")) == false) {
            //remet les articles en stock
            ArticleService as = new ArticleService();
            for(Article art : la){
                as.ajouterQuantiteArticle(1, art.getId());
            }
            
            req.getSession().removeAttribute("commande");
        } else {
            //enregistrement de la commande
            cmd.setClient((Utilisateur) req.getSession().getAttribute("utilconnecte"));
            
            cmd.setTotal();
            cmd.setEtat(Commande.etatCmd.FINALISEE);
            
            //new CommandeService().enregistrerCommande(cmd);
            
            Commande c = new Commande();
            c.setClient((Utilisateur) req.getSession().getAttribute("utilconnecte"));
            c.setDateCommande();
            c.setEtat(Commande.etatCmd.FINALISEE);
            
            c.setLarticle(la);
            
            new CommandeService().enregistrerCommande(c);
            
        }

        resp.sendRedirect("home");
    }

}
