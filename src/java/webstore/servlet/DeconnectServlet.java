package webstore.servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import webstore.service.ArticleService;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/deconnect"})
public class DeconnectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Commande cmd;
        List<Article> la = new ArrayList<>();
        
        if (req.getSession().getAttribute("commande") != null) {
        
            cmd = (Commande) req.getSession().getAttribute("commande");
            la = cmd.getLarticle();

            //remet les articles en stock
            ArticleService as = new ArticleService();
            for(Article art : la){
                as.ajouterQuantiteArticle(1, art.getId());
            }
        }
        
        req.getSession().removeAttribute("utilconnecte");
        req.getSession().removeAttribute("commande");
        resp.sendRedirect("home");
    }
    
}
