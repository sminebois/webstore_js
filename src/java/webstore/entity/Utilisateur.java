/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String login;
    private String mdp;
    private String adresse;
    @OneToMany(mappedBy = "client")
    private List<Commande> lcommande;
    @Enumerated(EnumType.STRING)
    private Type utilType;
    
    public enum Type{
        ADMIN,
        EXPEDITEUR,
        NORMAL;
    }
    

    public Type getUtilType() {
        return utilType;
    }

    public void setUtilType(Type utilType) {
        this.utilType = utilType;
    }
        
    public List<Commande> getLcommande() {
        return lcommande;
    }

    public void setLcommande(List<Commande> lcommande) {
        this.lcommande = lcommande;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webstore.entity.Utilisateur[ id=" + id + " nom=" + this.login + " ]";
    }

    public Utilisateur() {
    }

    public Utilisateur(String login, String mdp, String adresse) {
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.utilType = Type.NORMAL;
    }
    
    public Utilisateur(String login, String mdp){
        this.login = login;
        this.mdp = mdp;
        this.utilType = Type.NORMAL;
    }
    
    
    
    
}
