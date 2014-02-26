/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.business;

import java.util.List;
import nexus.java.dao.IDeclarationDao;
import nexus.java.dao.impl.DeclarationDaoImpl;
import nexus.java.entity.Declaration;

/**
 *
 * @author MaruLanD
 */
public class DeclarationBo {

    private IDeclarationDao declarationDao=new DeclarationDaoImpl();

   // public boolean insert(Declaration obj) {
   //     if (obj.getLieuDeclaration().equals(null)) {
            
   //    }

   // }

    public boolean update(Declaration obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean delete(Declaration obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Declaration> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Declaration readByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
