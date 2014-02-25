/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nexus.java.dao.IUtilDao;
import nexus.java.entity.Declaration;
import nexus.java.connection.Cnx;
import nexus.java.dao.IDeclarationDao;

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
                    + "into declaration(id_declaration,Id_Membre,Id_Animal,"
                    + "Lieu_Declaration,Etat,Commentaire,Type) values(?,?,?,?,?,?,?)");

            ps.setInt(1, obj.getIdDeclaration());
            ps.setInt(2, obj.getIdMembre());
            ps.setInt(3, obj.getIdAnimal());
            ps.setString(4, obj.getLieuDeclaration());
            ps.setString(5, obj.getEtat());
            ps.setString(6, obj.getCommentaire());
            ps.setShort(7, obj.getType());

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
                    + "Lieu_Declaration=?,Etat=?,Commentaire=? where id_declaration=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(sql);

            ps.setInt(4, obj.getIdDeclaration());
            ps.setString(1, obj.getLieuDeclaration());
            ps.setString(2, obj.getEtat());
            ps.setString(3, obj.getCommentaire());

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
    public boolean delete(Declaration obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Declaration> readAll() {
        List<Declaration> declarations = new ArrayList<Declaration>();
        try {
            Statement st = cnx.createStatement();
            String sql = "select * from declaration";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Declaration declaration = new Declaration(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getShort(7));
                declarations.add(declaration);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return declarations;
    }

    @Override
    public Declaration readByID(Integer id) {
        Declaration d = null;
        String sql = "select * from declaration where id_declaration=" + id;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                d = new Declaration(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getShort(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return d;
    }

}
