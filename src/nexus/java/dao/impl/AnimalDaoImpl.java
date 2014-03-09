package nexus.java.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            if (a.getAge() != null) {
                ps.setInt(5, a.getAge());
            } else {
                ps.setObject(5, null);
            }

            FileInputStream istreamImage = new FileInputStream(a.getImage());
            if (a.getImage() != null) {
                ps.setBinaryStream(6, istreamImage, (int) a.getImage().length());
            } else {
                ps.setObject(6, null);
            }
            ps.setString(7, a.getSexe());
            ps.setString(8, a.getCommentaire());

            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnimalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
            ex.printStackTrace();
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
            if (a.getAge() != null) {
                ps.setInt(5, a.getAge());
            } else {
                ps.setObject(5, null);
            }
            FileInputStream istreamImage = new FileInputStream(a.getImage());
            if (a.getImage() != null) {
                ps.setBinaryStream(6, istreamImage, (int) a.getImage().length());
            } else {
                ps.setObject(6, null);
            }
            ps.setString(7, a.getSexe());
            ps.setString(8, a.getCommentaire());

            ps.setInt(9, a.getIdAnimal());
            ps.executeUpdate();
            System.out.println("modification effectuée avec succès");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnimalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Animal a
    ) {
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

                File img = new File("C:\\Users\\imen\\Documents\\NetBeansProjects\\image.nex");
                String s = img.getPath();
                FileOutputStream ostreamImage = new FileOutputStream(img);

                if (rs.getBinaryStream(7) != null) {
                    InputStream istreamImage = rs.getBinaryStream(7);

                    byte[] buffer = new byte[1024];
                    int length = 0;

                    while ((length = istreamImage.read(buffer)) != -1) {
                        ostreamImage.write(buffer, 0, length);
                    }

                } else {
                    img = null;
                }
                Animal animal = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), img, rs.getString(8), rs.getString(9));

                animals.add(animal);
            }

        } catch (IOException ex) {
            Logger.getLogger(AnimalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Animal readByID(Integer id
    ) {
        Animal a = null;
        String sql = "select * from animal where id_animal=" + id;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                File img = new File("C:\\Users\\imen\\Documents\\NetBeansProjects\\image.nex");
                FileOutputStream ostreamImage = new FileOutputStream(img);
                if (rs.getBinaryStream(7) != null) {
                    InputStream istreamImage = rs.getBinaryStream(7);
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while ((length = istreamImage.read(buffer)) != -1) {
                        ostreamImage.write(buffer, 0, length);
                    }
                } else {
                    img = null;
                }
                a = new Animal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), img, rs.getString(8), rs.getString(9));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(AnimalDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }
}
