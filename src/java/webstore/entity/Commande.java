/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    private int total;
    @ManyToMany
    @JoinTable(name = "article_commande")
    private List<Article> larticle=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Utilisateur client;
    
    @Enumerated(EnumType.STRING)
    private etatCmd etat;
    
    public enum etatCmd{
        NON_FINALISEE,
        FINALISEE,
        EXPEDIEE;
    }
    

    public etatCmd getEtat() {
        return etat;
    }

    public void setEtat(etatCmd etat) {
        this.etat = etat;
    }
    
    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }
    
    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    
    public void setDateCommande(){
        this.dateCommande = new Date();
    }

    public int getTotal() {
        return total;
    }
    
    public void setTotal(){
        int tot = 0;
        
        for(Article art : this.larticle){
            tot += art.getPrix();
        }
        
        this.total = tot;
    }            

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Article> getLarticle() {
        return larticle;
    }

    public void setLarticle(List<Article> larticle) {
        this.larticle = larticle;
        setTotal();
        
        //ajout de la commande dans l'article
        /*for(Article art : this.larticle){
            List<Commande> lc = art.getLcommande();
            lc.add(this);
            art.setLcommande(lc);
        }*/
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webstore.entity.Commande[ id=" + id + " ]";
    }

    public Commande() {
        this.etat = etatCmd.NON_FINALISEE;
        setDateCommande();
    }

    public Commande(List<Article> larticle, Utilisateur client) {
        this.larticle = larticle;
        this.client = client;
        setTotal();
        this.dateCommande = new Date();
    }
    
    
    
}
