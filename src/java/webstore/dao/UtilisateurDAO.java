/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import webstore.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurDAO {
    public void creerUtilisateur(Utilisateur u){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }

    public Utilisateur rechercheParLoginEtMdp(Utilisateur u) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();  
        return (Utilisateur) em.createQuery("SELECT u FROM Utilisateur u WHERE u.login='" + u.getLogin() + "' AND u.mdp='" + u.getMdp() + "'").getSingleResult();       

    }

    public List<Utilisateur> rechercherParLogin(String login) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT u FROM Utilisateur u WHERE u.login=:login").setParameter("login", login).getResultList();
    }
}
