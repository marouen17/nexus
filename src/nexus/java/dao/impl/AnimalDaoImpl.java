package nexus.java.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nexus.java.entity.Animal;
import nexus.java.connection.Cnx;
import nexus.java.dao.IAnimalDao;

/**
 *
 * @author imen
 */
public class AnimalDaoImpl implements IAnimalDao {

    private Connection cnx = Cnx.getInstance().getConnection();

    @Override
    public boolean insert(Animal a) {

        String requete = "insert into animal (espece,couleur,type,taille,age,image,sexe,commentaire) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, a.getEspece());
            ps.setString(2, a.getCouleur());
            ps.setString(3, a.getType());
            ps.setString(4, a.getTaille());
            ps.setInt(5, a.getAge());
            ps.setBlob(6, new InputStream() {

                @Override
                public int read() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });//a.getImage());
            ps.setString(7, a.getSexe());
            ps.setString(8, a.getCommentaire());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean update(Animal a) {
        String requete = "update  animal set espece=?,couleur=?,type=?,taille=?,age=?,image=?,sexe=?,commentaire=? where id_animal=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, a.getEspece());
            ps.setString(2, a.getCouleur());
            ps.setString(3, a.getType());
            ps.setString(4, a.getTaille());
            ps.setInt(5, a.getAge());
            ps.setBlob(6, new InputStream() {

                @Override
                public int read() throws IOException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });//a.getImage());
            ps.setString(7, a.getSexe());
            ps.setString(8, a.getCommentaire());
            ps.setInt(9, a.getIdAnimal());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Animal a) {
        String sql = "delete from animal where id_animal=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, a.getIdAnimal());

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
    public List<Animal> readAll() {
        List<Animal> animals = new ArrayList<Animal>();
        try {
            Statement st = cnx.createStatement();
            String sql = "select * from animal";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Animal animal = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), null, rs.getString(8), rs.getString(9)); // a revoir
                animals.add(animal);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animals;
    }

    @Override
    public Animal readByID(Integer id) {
        Animal a = null;
        String sql = "select * from animal where id_animal=" + id;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                a = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), null, rs.getString(8), rs.getString(9));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return a;
    }
}
