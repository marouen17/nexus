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
import nexus.java.business.MembreBo;
import nexus.java.entity.Animal;
import nexus.java.connection.Cnx;
import nexus.java.dao.IAnimalDao;
import nexus.java.entity.Membre;

/**
 *
 * @author imen
 */
public class AnimalDaoImpl implements IAnimalDao {
    
    private Connection cnx = Cnx.getInstance().getConnection();
    
    @Override
    public boolean insert(Animal a) {
        
        String requete = "insert into animal (espece,couleur,type,taille,age,sexe,commentaire,id_membre) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, a.getEspece());
            ps.setString(2, a.getCouleur());
            ps.setString(3, a.getType());
            ps.setString(4, a.getTaille());
            
            if (a.getAge() != null) {
                ps.setInt(5, a.getAge());
            } else {
                ps.setObject(5, null);
            }
            ps.setString(6, a.getSexe());
            ps.setString(7, a.getCommentaire());
            ps.setInt(8, a.getMembre().getIdMembre());
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
        String requete = "update  animal set espece=?,couleur=?,type=?,taille=?,age=?,sexe=?,commentaire=? where id_animal=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1, a.getEspece());
            ps.setString(2, a.getCouleur());
            ps.setString(3, a.getType());
            ps.setString(4, a.getTaille());
            if (a.getAge() != null) {
                ps.setInt(5, a.getAge());
            } else {
                ps.setObject(5, null);
            }
            ps.setString(6, a.getSexe());
            ps.setString(7, a.getCommentaire());
            ps.setInt(8, a.getIdAnimal());
            ps.executeUpdate();
            System.out.println("modification effectuée avec succès");
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
                MembreBo membreBo = MembreBo.getInstance();
                Animal animal = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), null, rs.getString(8), rs.getString(9), membreBo.readByID(rs.getInt("membre_id_membre"))); // a revoir
                animals.add(animal);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return animals;
    }
    
    @Override
    public int getMaxID() {
        String sql = "select id_animal from animal order by id_animal desc";
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
    
    @Override
    public Animal readByID(Integer id) {
        Animal a = null;
        String sql = "select * from animal where id_animal=" + id;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            MembreBo membreBo=MembreBo.getInstance();
            while (rs.next()) {
                a = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), null, rs.getString(8), rs.getString(9),membreBo.readByID(rs.getInt("membre_id_membre"))); 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return a;
    }
}
