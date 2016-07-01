/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import webstore.entity.Article;
import webstore.entity.Commande;
import webstore.entity.Utilisateur;
import webstore.service.ArticleService;
import webstore.service.CommandeService;
import webstore.service.UtilisateurService;

/**
 *
 * @author admin
 */
public class TestVrac {

    @Test
    public void test() {
        Utilisateur u = new Utilisateur("kevin", "leboss");
        u = new UtilisateurService().rechercheParLoginEtMdp(u);

        Commande commande = new Commande();

        // Associe util et commande
        commande.setClient(u);
        u.getLcommande().add(commande);

        // Associe article et commande
        ArticleService articleService = new ArticleService();
        Article art1 = articleService.getArticleById(301);
        Article art2 = articleService.getArticleById(303);
        Article art3 = articleService.getArticleById(303);

        commande.getLarticle().add(art1);
        commande.getLarticle().add(art2);
        commande.getLarticle().add(art3);
        
        art1.getLcommande().add(commande);
        art2.getLcommande().add(commande);
        art3.getLcommande().add(commande);

        new CommandeService().enregistrerCommande(commande);
    }
}
