package nexus.java.business;

import java.util.List;
import nexus.java.dao.IUtilDao;
import nexus.java.dao.impl.AdministrateurDaoImpl;
import nexus.java.entity.Administrateur;

/**
 *
 * @author MaruLanD
 */
public class AdministrateurBo {

    private static AdministrateurBo instance = null;

    private AdministrateurBo() {
    }

    public static AdministrateurBo getInstance() {
        if (instance == null) {
            instance = new AdministrateurBo();
        }
        return instance;
    }

    private AdministrateurDaoImpl adminDao = new AdministrateurDaoImpl();

    public boolean verifeLogin(String log) {
        if (log.equals(null) || log.equals("")) {
            return false;
        } else {
            return true;
        }

    }
   
    public boolean verifeNomPrenom(String ch) {
        if (ch.equals(null) || ch.equals("")) {
            return false;
        } else {
            return true;
        }

    }
     public boolean verifeSexe(String sexe) {
        if (sexe.equals(null) || sexe.equals("")) {
            return false;
        } else {
            return true;
        }

    }
    public boolean verifeFonction(String fonction) {
        if (fonction.equals(null) || fonction.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifeMotPass(String mdpasse) {
        if (mdpasse.equals(null) || mdpasse.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public String verifAdmin(Administrateur a) {
        String errors = "";
        if (!verifeLogin((a.getLoginAdmin()))) {
            errors += "-Login\n";
        }
        if (!verifeMotPass(a.getMtPasse())) {
            errors += "-mot de passe \n";
        }
        if (!verifeNomPrenom(a.getNomPrenom())) {
            errors += "-nom et prénom \n";
        }
        if (!verifeFonction(a.getFonction())) {
            errors += "-Fonction\n";
        }
        
        return errors;
    }

    public boolean insert(Administrateur obj) {
        return adminDao.insert(obj);

    }

    public boolean update(Administrateur obj) {
        return adminDao.update(obj);

    }

    public boolean delete(Administrateur obj) {
        return adminDao.delete(obj);

    }

    public List<Administrateur> readAll() {
        return adminDao.readAll();
    }

    public Administrateur readByID(Integer id) {
        return adminDao.readByID(id);
    }
    public  int getMaxID() {
        return adminDao.getMaxID();
    }

    

}
