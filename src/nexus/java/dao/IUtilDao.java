/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.dao;

import java.util.List;

/**
 *
 * @author MaruLanD
 * @param <E> Class
 * @param <I> Id
 */
public interface IUtilDao<E, I> {

    public boolean insert(E obj);

    public boolean update(E obj);

    public boolean delete(E obj);

    public List<E> readAll();

    public E readByID(I id);

    public int getMaxID();

}
