
package nexus.java.gui;

import javax.swing.JOptionPane;
import nexus.java.business.MembreBo;
import nexus.java.entity.Membre;

public class AjoutModifMembre extends javax.swing.JFrame {
    
    private MembreBo membreBo=MembreBo.getInstance();
   private boolean ifAdd = true;

    Membre membre = new Membre();
    

    public AjoutModifMembre() {
        initComponents();
        idField.setText((membreBo.getMaxID() + 1) + "");
        

    }

    public AjoutModifMembre (int id) {

        membre = membreBo.readByID(id);
       
        initComponents();
        idField.setText(membre.getIdMembre()+ "");
        NomField.setText(membre.getNom());
        prenomField.setText(membre.getPrenom());
        codeField.setText(membre.getCodePostal()+"");
        adresseField.setText(membre.getAdresse());
        if (membre.getSexe().equals("Homme")) {
            hommeRadioButton.setSelected(true);
        } else {
            femmeRadioButton.setSelected(true);
        }
        villeField.setText(membre.getVille());
        paysField.setText(membre.getPays());
        loginField.setText(membre.getLogin());
        mdpField.setText(membre.getMdpasse());
       
        ifAdd = false;
        jButton1.setText("Modifier");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NomField = new javax.swing.JTextField();
        prenomField = new javax.swing.JTextField();
        adresseField = new javax.swing.JTextField();
        hommeRadioButton = new javax.swing.JRadioButton();
        femmeRadioButton = new javax.swing.JRadioButton();
        villeField = new javax.swing.JTextField();
        paysField = new javax.swing.JTextField();
        codeField = new javax.swing.JTextField();
        loginField = new javax.swing.JTextField();
        mdpField = new javax.swing.JTextField();
        precedentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nom");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, -1, -1));

        jLabel3.setText("Prenom");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel4.setText("Adresse");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, -1, -1));

        jLabel5.setText("Sexe");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 167, -1, -1));

        jLabel6.setText("Ville");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 14, -1, -1));

        jLabel7.setText("Pays");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 52, -1, -1));

        jLabel8.setText("Code postal");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 90, -1, -1));

        jLabel9.setText("Login");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 128, -1, -1));

        jLabel10.setText("Mot de passe");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 166, -1, -1));

        NomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomFieldActionPerformed(evt);
            }
        });
        jPanel1.add(NomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 49, 126, -1));
        jPanel1.add(prenomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 87, 126, -1));
        jPanel1.add(adresseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 125, 126, -1));

        buttonGroup1.add(hommeRadioButton);
        hommeRadioButton.setText("Homme");
        hommeRadioButton.setSelected(true);
        jPanel1.add(hommeRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 163, 90, -1));

        buttonGroup1.add(femmeRadioButton);
        femmeRadioButton.setText("Femme");
        jPanel1.add(femmeRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 163, -1, -1));
        jPanel1.add(villeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 11, 126, -1));
        jPanel1.add(paysField, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 49, 126, -1));

        codeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeFieldFocusLost(evt);
            }
        });
        jPanel1.add(codeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 87, 126, -1));
        jPanel1.add(loginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 125, 126, -1));
        jPanel1.add(mdpField, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 163, 126, -1));

        precedentButton.setText("Annuler");
        precedentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precedentButtonActionPerformed(evt);
            }
        });
        jPanel1.add(precedentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        jLabel1.setText("Id");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, -1, -1));

        idField.setBackground(new java.awt.Color(250, 250, 250));
        idField.setEnabled(false);
        jPanel1.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 11, 120, -1));

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 11, 580, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void precedentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precedentButtonActionPerformed
        new MainMembreForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_precedentButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String sexe ="";
        if (femmeRadioButton.isSelected()){
            sexe = femmeRadioButton.getText();
        }
        if (hommeRadioButton.isSelected()){
            sexe = hommeRadioButton.getText();
        }
        String nom = NomField.getText();
        String prenom = prenomField.getText();
        String adresse = adresseField.getText();
        Integer codePostal = Integer.parseInt(codeField.getText()) ;
        String ville = villeField.getText();
        String pays = paysField.getText();
        String login = loginField.getText();
        String mdp = mdpField.getText();

        membre.setNom(nom);
        membre.setPrenom(prenom);
        membre.setAdresse(adresse);
        membre.setCodePostal(codePostal);
        membre.setPays(pays);
        membre.setVille(ville);
        membre.setLogin(login);
        membre.setMdpasse(mdp);
        membre.setSexe(sexe);
        
        String errors = membreBo.verifAnimal(membre);
        if (errors.equals("")) {
            if (ifAdd) {
                membreBo.insert(membre);
                this.setVisible(false);
                new MainMembreForm().setVisible(true);
              } else {
                membreBo.update(membre);
                this.setVisible(false);
                new MainMembreForm().setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Veuillez revérifier les champs suivants: \n" + errors, "Erreur", JOptionPane.ERROR_MESSAGE);

        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomFieldActionPerformed

    private void codeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codeFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_codeFieldFocusLost
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjoutModifMembre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutModifMembre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutModifMembre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutModifMembre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutModifMembre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NomField;
    private javax.swing.JTextField adresseField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField codeField;
    private javax.swing.JRadioButton femmeRadioButton;
    private javax.swing.JRadioButton hommeRadioButton;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loginField;
    private javax.swing.JTextField mdpField;
    private javax.swing.JTextField paysField;
    private javax.swing.JButton precedentButton;
    private javax.swing.JTextField prenomField;
    private javax.swing.JTextField villeField;
    // End of variables declaration//GEN-END:variables
}
