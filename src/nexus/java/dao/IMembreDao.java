/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.dao;

import nexus.java.entity.Membre;

/**
 *
 * @author lenovo
 */
public interface IMembreDao extends IUtilDao<Membre, Integer> {

    public int getMaxID();

}
