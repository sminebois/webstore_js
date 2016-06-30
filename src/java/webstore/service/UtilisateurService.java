/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.service;

import webstore.dao.UtilisateurDAO;
import webstore.entity.Utilisateur;

/**
 *
 * @author admin
 */
public class UtilisateurService {

    public void creerUtilisateur(Utilisateur u) {
        UtilisateurDAO dao = new UtilisateurDAO();
        if (dao.rechercherParLogin(u.getLogin()).size() > 0) {
            throw new RuntimeException("Login deja existant");
        }

        dao.creerUtilisateur(u);
    }

    public Utilisateur rechercheParLoginEtMdp(Utilisateur u) {
        return new UtilisateurDAO().rechercheParLoginEtMdp(u);
    }
}
