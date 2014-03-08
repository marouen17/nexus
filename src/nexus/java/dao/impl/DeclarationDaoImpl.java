/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nexus.java.entity.Declaration;
import nexus.java.connection.Cnx;
import nexus.java.dao.IAnimalDao;
import nexus.java.dao.IDeclarationDao;
import nexus.java.dao.IMembreDao;

/**
 *
 * @author MaruLanD
 */
public class DeclarationDaoImpl implements IDeclarationDao {

    private final Connection cnx = Cnx.getInstance().getConnection();

    @Override
    public boolean insert(Declaration obj) {
        try {
            PreparedStatement ps = cnx.prepareStatement("insert "
                    + "into declaration(Id_Membre,Id_Animal,"
                    + "Lieu_Declaration,Etat,Commentaire,Type,date,isfound) values(?,?,?,?,?,?,?,?)");

            if (obj.getMembre() != null) {
                ps.setInt(1, obj.getMembre().getIdMembre());
            } else {
                ps.setObject(1, null);
            }
            if (obj.getAnimal() != null) {
                ps.setInt(2, obj.getAnimal().getIdAnimal());
            } else {
                ps.setObject(2, null);
            }
            ps.setString(3, obj.getLieuDeclaration());
            ps.setString(4, obj.getEtat());
            ps.setString(5, obj.getCommentaire());
            ps.setShort(6, obj.getType());
            ps.setDate(7,(Date) obj.getDate());
            ps.setBoolean(8, obj.getIsFound());

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
    public boolean update(Declaration obj) {
        String sql = "update declaration set "
                + "Lieu_Declaration=?,Etat=?,Commentaire=?,date=?,isfound=? where id_declaration=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(4, obj.getIdDeclaration());
            ps.setString(1, obj.getLieuDeclaration());
            ps.setString(2, obj.getEtat());
            ps.setString(3, obj.getCommentaire());
            ps.setDate(4, (Date)obj.getDate());
            ps.setBoolean(5, obj.getIsFound());

            int var = ps.executeUpdate();
            if (var == 0) {
                return false;
            } else {
                System.out.println("aaa");
                return true;

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(Declaration obj) {
        String sql = "delete from declaration where id_declaration=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(1, obj.getIdDeclaration());

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
    public List<Declaration> readAll() {
        IAnimalDao animalDao = new AnimalDaoImpl();
        IMembreDao membreDao = new nexus.java.dao.Impl.MembreDaoImpl();
        List<Declaration> declarations = new ArrayList<Declaration>();
        try {
            Statement st = cnx.createStatement();
            String sql = "select * from declaration";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Declaration declaration = new Declaration(rs.getInt(1), membreDao.readByID(rs.getInt(2)), animalDao.readByID(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getShort(7),rs.getDate("date"),rs.getBoolean("isfound"));
                declarations.add(declaration);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return declarations;
    }

    @Override
    public Declaration readByID(Integer id) {
        IAnimalDao animalDao = new AnimalDaoImpl();
        IMembreDao membreDao= new nexus.java.dao.Impl.MembreDaoImpl();
        Declaration d = null;
        String sql = "select * from declaration where id_declaration=" + id;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                d = new Declaration(rs.getInt(1),membreDao.readByID(rs.getInt(2)), animalDao.readByID(rs.getInt(3)), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getShort(7),rs.getDate("date"),rs.getBoolean("isfound"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return d;
    }

    @Override
    public int getMaxID() {
        String sql = "select id_declaration from declaration order by id_declaration desc";
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
