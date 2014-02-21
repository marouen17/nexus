/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.dao;

import java.sql.Connection;
import java.util.List;
import nexus.java.utils.Cnx;

/**
 *
 * @author MaruLanD
 */
public interface UtilDao<E, I> {

    public boolean insert(E obj);

    public boolean update(E obj);

    public boolean delete(E obj);

    public List<E> readAll();

    public E readByID(I id);

}
