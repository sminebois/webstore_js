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
import webstore.dao.ArticleDAO;
import webstore.entity.Article;
import webstore.entity.Commande;
import webstore.service.ArticleService;

/**
 *
 * @author admin
 */
@WebServlet(name = "ArticlesServlet", urlPatterns = {"/articles"})
public class ArticlesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("larticle", new ArticleDAO().listerArticle());
        
        req.getRequestDispatcher("articles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(Integer.parseInt(req.getParameter("qtt")) > 0){
            
            Commande cmd = new Commande();
            List<Article> lart = new ArrayList<>();
            if(req.getSession().getAttribute("commande") != null){
                cmd = (Commande) req.getSession().getAttribute("commande");
            }
            if(cmd.getLarticle() != null){
                lart = cmd.getLarticle();
            }        
        

            //ajout du nombre voulu d'articles
            for(int i = 0; i < Integer.parseInt(req.getParameter("qtt")); i++){
                Article a = new ArticleService().getArticleById(Integer.parseInt(req.getParameter("id")));
                
                List<Commande> lc = new ArrayList<>();
                lc.add(cmd);
                a.setLcommande(lc);
                
                lart.add(a); 
                
            }
            //retrait en bdd du nb d'articles
            new ArticleService().supprimerQuantiteArticle(Integer.parseInt(req.getParameter("qtt")), Long.parseLong(req.getParameter("id")));

            cmd.setLarticle(lart);
            req.getSession().setAttribute("commande", cmd);


        }
        resp.sendRedirect("articles");
    }
    
    
    
}
