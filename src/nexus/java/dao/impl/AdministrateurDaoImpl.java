package nexus.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nexus.java.entity.Administrateur;
import nexus.java.connection.Cnx;
import nexus.java.dao.IAdministrateurDao;

public class AdministrateurDaoImpl implements IAdministrateurDao {

    private final Connection cnx = Cnx.getInstance().getConnection();

    public boolean insert(Administrateur obj) {
        String requete = "INSERT INTO administrateur(`login`,`mt_passe`,`nom_prenom`,`fonction`) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = cnx.prepareStatement(requete);

            ps.setString(1, obj.getLoginAdmin());
            ps.setString(2, obj.getMtPasse());
            ps.setString(3, obj.getNomPrenom());
            ps.setString(4, obj.getFonction());

            int var = ps.executeUpdate();
            if (var == 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public boolean update(Administrateur obj) {
        String requete = "update administrateur set login=?,mt_passe=?,nom_prenom=?,fonction=? where id_admin=?";

        try {
            PreparedStatement ps = cnx.prepareStatement(requete);

            ps.setString(1, obj.getLoginAdmin());
            ps.setString(2, obj.getMtPasse());
            ps.setString(3, obj.getNomPrenom());
            ps.setString(4, obj.getFonction());
            ps.setInt(5, obj.getIdAdmin());

            int var = ps.executeUpdate();
            if (var == 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public boolean delete(Administrateur obj) {

        try {
            PreparedStatement ps = cnx.prepareStatement("delete from administrateur where id_admin=?");
            ps.setInt(1, obj.getIdAdmin());

            int var = ps.executeUpdate();
            if (var == 0) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public List<Administrateur> readAll() {
        List<Administrateur> listeadmin = new ArrayList<Administrateur>();

        String requete = "select * from administrateur";
        try {
            Statement statement = cnx.createStatement();

            ResultSet resultat = statement.executeQuery(requete);
            AdministrateurDaoImpl adminDAO = new AdministrateurDaoImpl();
            while (resultat.next()) {
                Administrateur a = new Administrateur();
                a.setIdAdmin(resultat.getInt(1));
                a.setLoginAdmin(resultat.getString(2));
                a.setMtPasse(resultat.getString(3));
                a.setNomPrenom(resultat.getString(4));
                a.setFonction(resultat.getString(5));

                listeadmin.add(a);
            }
            return listeadmin;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Administrateur readByID(Integer id) {
        Administrateur a = new Administrateur();

        String requete = "select * from administrateur where id_admin=" + id;
        try {
            Statement statement = cnx.createStatement();

            ResultSet resultat = statement.executeQuery(requete);

            resultat.next();
            a.setIdAdmin(resultat.getInt(1));
            a.setLoginAdmin(resultat.getString(2));
            a.setMtPasse(resultat.getString(3));
            a.setNomPrenom(resultat.getString(4));
            a.setFonction(resultat.getString(5));

            return a;
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int getMaxID() {
        String sql = "select id_admin from administrateur order by id_admin desc";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
