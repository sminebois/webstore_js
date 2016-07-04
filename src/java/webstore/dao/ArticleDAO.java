/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import webstore.entity.Article;

/**
 *
 * @author admin
 */
public class ArticleDAO {
    public void creerArticle(Article a){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
    }
    
    public List<Article> listerArticle(){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT a FROM Article a ORDER BY a.nom").getResultList();
    }
    
    public void modiferArticle(Article a){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();        
    }

    public Article getArticleById(long id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.find(Article.class, id);
    }
    
}
