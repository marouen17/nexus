package nexus.java.business;

import java.util.List;
import nexus.java.dao.IAnimalDao;
import nexus.java.dao.impl.AnimalDaoImpl;
import nexus.java.entity.Animal;

public class AnimalBo {

    private IAnimalDao animalDao = new AnimalDaoImpl();

    private static AnimalBo instance = null;

    private AnimalBo() {
    }

    public static AnimalBo getInstance() {
        if (instance == null) {
            instance = new AnimalBo();
        }
        return instance;
    }

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
        String errors ="";
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

        return animalDao.insert(obj);

    }

    public boolean update(Animal obj) {

        return animalDao.update(obj);
    }

    public boolean delete(Animal obj) {
        return animalDao.delete(obj);

    }

    public List<Animal> readAll() {
        return animalDao.readAll();
    }

    public Animal readByID(Integer id) {
        return animalDao.readByID(id);
    }

    public Integer getMaxID() {
        return animalDao.getMaxID();
    }
}
