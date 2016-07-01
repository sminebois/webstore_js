/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.service;

import java.util.List;
import webstore.dao.CommandeDAO;
import webstore.entity.Commande;

/**
 *
 * @author admin
 */
public class CommandeService {
    public void enregistrerCommande(Commande c){
        new CommandeDAO().enregistrerCommande(c);
    }
    
    public void supprimerCommande(long id){
        new CommandeDAO().supprimerCommande(id);
    }
    
    public void modifierCommande(Commande c){
        new CommandeDAO().modifierCommande(c);
    }
    
    public List<Commande> listerCommande(){
        return new CommandeDAO().listerCommande();
    }
    
    public Commande getCommandeById(long id){
        return new CommandeDAO().getCommandeById(id);
    }
    
    public List<Commande> listerCommandeByIdClient(long id){
        return new CommandeDAO().listerCommandeByIdClient(id);
    }
}
