/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.entity;

/**
 *
 * @author MaruLanD
 */
public class Declaration {

    private int idDeclaration;
    private Integer membre;
    private Animal animal;
    private String lieuDeclaration;
    private String etat;
    private String commentaire;
    private Short type;

    public Declaration() {
    }

    public Declaration(int idDeclaration) {
        this.idDeclaration = idDeclaration;
    }

    public Declaration(int idDeclaration, Integer idMembre, Animal animal, String lieuDeclaration, String etat,
            String commentaire, Short type) {
        this.idDeclaration = idDeclaration;
        this.membre = idMembre;
        this.animal = animal;
        this.lieuDeclaration = lieuDeclaration;
        this.etat = etat;
        this.commentaire = commentaire;
        this.type = type;
    }

    public int getIdDeclaration() {
        return this.idDeclaration;
    }

    public void setIdDeclaration(int idDeclaration) {
        this.idDeclaration = idDeclaration;
    }

    public Integer getMembre() {
        return this.membre;
    }

    public void setMembre(Integer idMembre) {
        this.membre = idMembre;
    }

    public Animal getAnimal() {
        return this.animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getLieuDeclaration() {
        return this.lieuDeclaration;
    }

    public void setLieuDeclaration(String lieuDeclaration) {
        this.lieuDeclaration = lieuDeclaration;
    }

    public String getEtat() {
        return this.etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

}
