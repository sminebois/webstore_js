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
import webstore.service.CommandeService;

/**
 *
 * @author admin
 */
@WebServlet(name = "CommandesServlet", urlPatterns = {"/commandes"})
public class CommandesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("lcommande", new CommandeService().listerCommande());
        
        
        req.getRequestDispatcher("commandes.jsp").forward(req, resp);
    }
    
}
