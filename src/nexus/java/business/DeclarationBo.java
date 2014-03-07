/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.business;

import java.util.List;
import javax.swing.JOptionPane;
import nexus.java.dao.IAnimalDao;
import nexus.java.dao.IDeclarationDao;
import nexus.java.dao.IMembreDao;
import nexus.java.dao.Impl.MembreDaoImpl;
import nexus.java.dao.impl.AnimalDaoImpl;
import nexus.java.dao.impl.DeclarationDaoImpl;
import nexus.java.entity.Animal;
import nexus.java.entity.Declaration;
import nexus.java.entity.Membre;

/**
 *
 * @author MaruLanD
 */
public class DeclarationBo {

    private IDeclarationDao declarationDao = new DeclarationDaoImpl();
    private IAnimalDao animalDao = new AnimalDaoImpl();
    private IMembreDao membreDao = new MembreDaoImpl();

    private static DeclarationBo instance = null;

    private DeclarationBo() {
    }

    public static DeclarationBo getInstance() {
        if (instance == null) {
            instance = new DeclarationBo();
        }
        return instance;
    }

    public boolean veriflieux(String lieux) {
        if (lieux.equals(null) || lieux.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verifeEtat(String etat) {
        if (etat.equals(null) || etat.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public String verifDeclaration(Declaration d) {
        String errors = "";
        if (!veriflieux(d.getLieuDeclaration())) {
            errors += "-Lieu de déclaration\n";
        }
        if (!verifeEtat(d.getEtat())) {
            errors += "-Etat de l'animal\n";
        }

        return errors;
    }

    public void insert(Declaration d, Animal a, Membre m) {

        if (membreDao.insert(m)) {
            if (d.getType().equals("1")) {
                a.setMembre(new Membre(membreDao.getMaxID()));
            }
            animalDao.insert(a);
            d.setMembre(new Membre(membreDao.getMaxID()));
            d.setAnimal(new Animal(animalDao.getMaxID()));

            d.setIsFound(false);
            declarationDao.insert(d);
        } else {
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de l'ajout", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void insert(Declaration d, Animal a) {

        if (animalDao.insert(a)) {
            d.setAnimal(new Animal(animalDao.getMaxID()));
            declarationDao.insert(d);
        } else {
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de l'ajout", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void update(Declaration d, Animal a, Membre m) {
        if (animalDao.update(a) && declarationDao.update(d) && membreDao.update(m)) {

        } else {
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la modification", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void update(Declaration d, Animal a) {
        if (animalDao.update(a) && declarationDao.update(d)) {

        } else {
            JOptionPane.showMessageDialog(null, "Une erreur est survenue lors de la modification", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean delete(Declaration obj) {
        return declarationDao.delete(obj);
    }

    public List<Declaration> readAll() {
        return declarationDao.readAll();
    }

    public Declaration readByID(Integer id) {
        return declarationDao.readByID(id);
    }

    public int getMaxID() {
        return declarationDao.getMaxID();
    }

}
