
import nexus.java.dao.IDeclarationDao;
import nexus.java.dao.IMembreDao;
import nexus.java.dao.Impl.MembreDaoImpl;
import nexus.java.dao.impl.DeclarationDaoImpl;
import nexus.java.utils.ReportGen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MaruLanD
 */
public class Test {
    public static void main(String[] args) {
        IMembreDao dao=new MembreDaoImpl();
        IDeclarationDao dao1=new DeclarationDaoImpl();
        dao1.readAll();
                
        
    }
}
