package nexus.java.entity;

import javax.swing.JTextField;


public class Administrateur {
    private int idAdmin;
    private String loginAdmin;
    private String mtPasse;
    private String nomPrenom;
    private String fonction;

    public Administrateur() {
    }

    public Administrateur(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    

    public Administrateur(int idAdmin, String loginAdmin, String mtPasse, String nomPrenom, String fonction) {
        this.idAdmin = idAdmin;
        this.loginAdmin = loginAdmin;
        this.mtPasse = mtPasse;
        this.nomPrenom = nomPrenom;
        this.fonction = fonction;
    }

    public int getIdAdmin() {
        return idAdmin;
    }
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }
    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }


    public String getMtPasse() {
        return mtPasse;
    }
     public void setMtPasse(String mtPasse) {
        this.mtPasse = mtPasse;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }
     public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public String getFonction() {
        return fonction;
    }
    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setLoginAdmin(JTextField login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setfonction(String directeur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
}