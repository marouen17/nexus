package nexus.java.business;

import java.util.List;
import nexus.java.dao.IAnimalDao;
import nexus.java.dao.impl.AnimalDaoImpl;
import nexus.java.entity.Animal;

public class AnimalBo {

    private IAnimalDao animalDao = new AnimalDaoImpl();

    public boolean verifAge(Integer age) {
        if ((age == null)) {
            return false;
        } else {
            if (age < 0) {
                return false;
            }
            return true;
        }

    }

    public boolean verifeEspece(String espece) {
        if (espece.equals(null) || espece.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifeCouleur(String couleur) {
        if (couleur.equals(null) || couleur.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifeType(String type) {
        if (type.equals(null) || type.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifeTaille(String taille) {
        if (taille.equals(null) || taille.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public String verifAnimal(Animal a) {
        String errors = null;
        if (!verifAge(a.getAge())) {
            errors += "-Age\n";
        }
        if (!verifeCouleur(a.getCouleur())) {
            errors += "-Couleur\n";
        }
        if (!verifeEspece(a.getEspece())) {
            errors += "-Espece\n";
        }
        if (!verifeTaille(a.getTaille())) {
            errors += "-Taille\n";
        }
        if (!verifeType(a.getType())) {
            errors += "-Type\n";
        }

        return errors;
    }

    public boolean insert(Animal obj) {
        animalDao.insert(obj);
        return true;

    }

    public boolean update(Animal obj) {
        animalDao.update(obj);
        return true;
    }

    public boolean delete(Animal obj) {
        animalDao.delete(obj);
        return true;
    }

    public List<Animal> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Animal readByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
