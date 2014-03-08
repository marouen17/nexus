package nexus.java.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nexus.java.entity.Membre;
import nexus.java.connection.Cnx;
import nexus.java.dao.IMembreDao;

public class MembreDaoImpl implements IMembreDao {

    private final Connection cnx = Cnx.getInstance().getConnection();

    @Override
    public boolean insert(Membre obj) {
        String requete = "insert into membre (login,mdpasse,nom,prenom,adresse,sexe,code_postal,ville,pays) values (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = cnx.prepareStatement(requete);

            
            ps.setString(1, obj.getLogin());
            ps.setString(2, obj.getMdpasse());
            ps.setString(3, obj.getNom());
            ps.setString(4, obj.getPrenom());
            ps.setString(5, obj.getAdresse());
            ps.setString(6, obj.getSexe());
            ps.setInt(7, obj.getCodePostal());
            ps.setString(8, obj.getVille());
            ps.setString(9, obj.getPays());

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

    @Override
    public boolean update(Membre obj) {
        String requete = "update membre set login=?,mdpasse=?,nom=?,prenom=?,adresse=?,sexe=?,code_postal=?,ville=?,pays=? where id_Membre=?";

        try {
            PreparedStatement ps = cnx.prepareStatement(requete);

            
            ps.setString(1, obj.getLogin());
            ps.setString(2, obj.getMdpasse());
            ps.setString(3, obj.getNom());
            ps.setString(4, obj.getPrenom());
            ps.setString(5, obj.getAdresse());
            ps.setString(6, obj.getSexe());
            ps.setInt(7, obj.getCodePostal());
            ps.setString(8, obj.getVille());
            ps.setString(9, obj.getPays());
            
            ps.setInt(10, obj.getIdMembre());

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

    @Override
    public boolean delete(Membre obj) {

        try {
            PreparedStatement ps = cnx.prepareStatement("delete from membre where id_Membre=?");
            ps.setInt(1, obj.getIdMembre());

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

    @Override
    public List<Membre> readAll() {
        List<Membre> listemem = new ArrayList<Membre>();

        String requete = "select * from membre";
        try {
            Statement statement = cnx.createStatement();

            ResultSet resultat = statement.executeQuery(requete);
            MembreDaoImpl memDAO = new MembreDaoImpl();
            while (resultat.next()) {
                Membre m = new Membre();

                m.setIdMembre(resultat.getInt(1));
                m.setLogin(resultat.getString(2));
                m.setMdpasse(resultat.getString(3));
                m.setNom(resultat.getString(4));
                m.setPrenom(resultat.getString(5));
                m.setAdresse(resultat.getString(6));
                m.setSexe(resultat.getString(7));
                m.setCodePostal(resultat.getInt(8));
                m.setVille(resultat.getString(9));
                m.setPays(resultat.getString(10));
                
                
                listemem.add(m);
            }
            return listemem;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des stocks " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Membre readByID(Integer id) {
        Membre m = new Membre();

        String requete = "select * from membre where id_membre=" + id;
        try {
            Statement statement = cnx.createStatement();

            ResultSet resultat = statement.executeQuery(requete);

            resultat.next();

            m.setIdMembre(resultat.getInt(1));
            m.setLogin(resultat.getString(2));
            m.setMdpasse(resultat.getString(3));
            m.setNom(resultat.getString(4));
            m.setPrenom(resultat.getString(5));
            m.setAdresse(resultat.getString(6));
            m.setSexe(resultat.getString(7));
            m.setCodePostal(resultat.getInt(8));
            m.setVille(resultat.getString(9));
            m.setPays(resultat.getString(10));

            return m;
        } catch (SQLException ex) {
            System.out.println("erreur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public int getMaxID() {
        String sql = "select id_membre from membre order by id_membre desc";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            return rs.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    

}
