
import nexus.java.dao.impl.AnimalDaoImpl;
import nexus.java.utils.ReportGen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * Togfghj change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MaruLanD
 */
public class Test {
    public static void main(String[] args) {
        AnimalDaoImpl adi=new AnimalDaoImpl();
        adi.readAll();
        
    }
}
