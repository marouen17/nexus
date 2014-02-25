/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author MaruLanD
 */
public final class Cnx {

    private Connection dbCnx;
    private final String user = "root";
    private final String password = "rootroot";
    private final String url = "jdbc:mysql://localhost:3306/sosAnimaux";
    private static Cnx instance = null;

    private Cnx() {
        try {
            dbCnx = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Impossible de ce connecter ");
        }

    }

    public static Cnx getInstance() {
        if (instance == null) {
            instance = new Cnx();
            System.out.println("instance de la cnx en cours ");

        } else {
            System.out.println("cnx existante");
        }
        System.out.println("le hashcode de cette instance est" + instance.hashCode());
        return instance;
    }

    public Connection getConnection() {
        return dbCnx;
    }

}
