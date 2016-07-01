/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import webstore.entity.Commande;

/**
 *
 * @author admin
 */
public class CommandeDAO {

    public void enregistrerCommande(Commande c) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    public void modifierCommande(Commande c) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
    }

    public void supprimerCommande(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.createQuery("DELETE FROM Commande c WHERE c.id=:cId").setParameter("cId", id).executeUpdate();
    }
    
    public List<Commande> listerCommande(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT c FROM Commande c").getResultList();
    }
    
    public Commande getCommandeById(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Commande.class, id);
    }
    
    public List<Commande> listerCommandeByIdClient(long id){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT c FROM Commande c WHERE c.client=:cId").setParameter("cID", id).getResultList();
    }
    
}
