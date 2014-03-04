/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nexus.java.dao;

import nexus.java.entity.Declaration;

/**
 *
 * @author MaruLanD
 */
public interface IDeclarationDao extends IUtilDao<Declaration, Integer>{

    public int getMaxID();
    
}
