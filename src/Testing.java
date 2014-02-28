
import java.util.List;
import nexus.java.dao.IAnimalDao;
import nexus.java.dao.IDeclarationDao;
import nexus.java.dao.impl.AnimalDaoImpl;
import nexus.java.dao.impl.DeclarationDaoImpl;
import nexus.java.entity.Animal;
import nexus.java.entity.Declaration;
import nexus.java.gui.DeclarationAddUpdateForm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MaruLanD 
 */
public class Testing {

    public static void main(String[] args) {

        //DeclarationDaoImpl adi=new DeclarationDaoImpl();
       // adi.update(new Declaration(1, null, null, null, null, "marwen", (short)1));
        DeclarationAddUpdateForm dauf=new DeclarationAddUpdateForm(1);
        dauf.setVisible(true);
    }
}
