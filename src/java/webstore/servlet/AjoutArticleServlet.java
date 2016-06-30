/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webstore.entity.Article;
import webstore.service.ArticleService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutArticleServlet", urlPatterns = {"/ajout_article"})
public class AjoutArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ajout_article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article a = new Article(req.getParameter("nom"), Integer.parseInt(req.getParameter("qtt")), Integer.parseInt(req.getParameter("prix")));
        new ArticleService().creerArticle(a);
        resp.sendRedirect("ajout_article");
    }
    
    
    
}
