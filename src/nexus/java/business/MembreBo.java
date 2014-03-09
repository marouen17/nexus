package nexus.java.business;

import java.util.List;
import nexus.java.dao.IMembreDao;
import nexus.java.dao.Impl.MembreDaoImpl;
import nexus.java.entity.Membre;

/**
 *
 * @author MaruLanD
 */
public class MembreBo {

    private static MembreBo instance = null;

    private MembreBo() {
    }

    public static MembreBo getInstance() {
        if (instance == null) {
            instance = new MembreBo();
        }
        return instance;
    }

    private IMembreDao membreDao = new MembreDaoImpl();

    public boolean verifeNom(String nom) {
        if (nom.equals(null) || nom.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifePrenom(String prenom) {
        if (prenom.equals(null) || prenom.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifeCodePostal(String codePostal) {
        if (codePostal.equals(null) || codePostal.equals("")) {
            return false;
        } else {
            try {
                Integer.parseInt(codePostal);
                return true;
            } catch (NumberFormatException e) {
                return false;

            }

        }
    }

    public boolean verifeAdresse(String adresse) {
        if (adresse.equals(null) || adresse.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifeVille(String ville) {
        if (ville.equals(null) || ville.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verifePays(String pays) {
        if (pays.equals(null) || pays.equals("")) {
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

    public boolean verifeLogin(String login) {
        if (login.equals(null) || login.equals("")) {
            return false;
        } else {
            java.util.regex.Pattern p = java.util.regex.Pattern.compile(".+@.+\\.[a-z]+");
            try {
                java.util.regex.Matcher m = p.matcher(login);
                return m.matches();
            } catch (NullPointerException ee) {

                return false;
            }
        }

    }

    public boolean verifeMdp(String mdpasse) {
        if (mdpasse.equals(null) || mdpasse.equals("")) {
            return false;
        } else {
            return true;
        }

    }

    public String verifMembre(Membre m) {
        String errors = "";
        if (!verifeNom(m.getNom())) {
            errors += "-Nom\n";
        }
        if (!verifePrenom(m.getPrenom())) {
            errors += "-Prénom\n";
        }
        if (!verifeAdresse(m.getAdresse())) {
            errors += "-Adresse\n";
        }
        if (!verifeCodePostal(m.getCodePostal() + "")) {
            errors += "-Code postal\n";
        }
        if (!verifeSexe(m.getSexe())) {
            errors += "-Sexe\n";
        }
        if (!verifeVille(m.getVille())) {
            errors += "-Ville\n";
        }
        if (!verifePays(m.getPays())) {
            errors += "-Pays\n";
        }
        if (!verifeMdp(m.getMdpasse())) {
            errors += "-Mot de passe\n";
        }
        if (!verifeLogin(m.getLogin())) {
            errors += "-Login\n";
        }

        return errors;
    }

    public boolean insert(Membre obj) {
        return membreDao.insert(obj);

    }

    public boolean update(Membre obj) {
        return membreDao.update(obj);

    }

    public boolean delete(Membre obj) {
        return membreDao.delete(obj);

    }

    public List<Membre> readAll() {
        return membreDao.readAll();
    }

    public Membre readByID(Integer id) {
        return membreDao.readByID(id);
    }

    public int getMaxID() {
        return membreDao.getMaxID();
    }

}
