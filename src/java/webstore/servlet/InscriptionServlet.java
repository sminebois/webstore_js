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
import webstore.entity.Utilisateur;
import webstore.service.UtilisateurService;

/**
 *
 * @author admin
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = new Utilisateur(req.getParameter("login"), req.getParameter("mdp"), req.getParameter("addr"));
        
        new UtilisateurService().creerUtilisateur(u);        
        
        u = new UtilisateurService().rechercheParLoginEtMdp(u);
            
        req.getSession().setAttribute("utilconnecte", u);         
        
        resp.sendRedirect("home");
    }
    
    
    
}
