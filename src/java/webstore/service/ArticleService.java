/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.service;

import java.util.List;
import webstore.dao.ArticleDAO;
import webstore.entity.Article;

/**
 *
 * @author admin
 */
public class ArticleService {
    public void creerArticle(Article a){
        new ArticleDAO().creerArticle(a);
    }
    
    public List<Article> listerArticle(){
        return new ArticleDAO().listerArticle();
    }
    
    public void modiferArticle(Article a){
        new ArticleDAO().modiferArticle(a);
    }
    
    public Article getArticleById(long id){
        return new ArticleDAO().getArticleById(id);
    }
    
    public void supprimerQuantiteArticle(int quantite, long id){
        Article a = new ArticleDAO().getArticleById(id);
        a.setStock(a.getStock() - quantite);
        new ArticleDAO().modiferArticle(a);
    }
    
    public void ajouterQuantiteArticle(int quantite, long id){
        Article a = new ArticleDAO().getArticleById(id);
        a.setStock(a.getStock() + quantite);
        new ArticleDAO().modiferArticle(a);
    }
    
}
