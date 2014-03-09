
package nexus.java.gui;

import javax.swing.JOptionPane;
import nexus.java.business.AdministrateurBo;
import nexus.java.entity.Administrateur;

public class AjoutModifAdministrateur extends javax.swing.JFrame {
    
    private AdministrateurBo adminBo=AdministrateurBo.getInstance();
    private boolean ifAdd = true;

     Administrateur admin = new Administrateur();
    

    public AjoutModifAdministrateur() {
        initComponents();
        idField.setText((adminBo.getMaxID() + 1) + "");
        

    }

    public AjoutModifAdministrateur (int id) {

        admin = adminBo.readByID(id);
       
        initComponents();
        idField.setText(admin.getIdAdmin()+"");
        NomField.setText(admin.getLoginAdmin());
        prenomField.setText(admin.getMtPasse());
        codeField.setText(admin.getNomPrenom());
        adresseField.setText(admin.getFonction());
              
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
        jLabel8 = new javax.swing.JLabel();
        NomField = new javax.swing.JTextField();
        prenomField = new javax.swing.JTextField();
        adresseField = new javax.swing.JTextField();
        codeField = new javax.swing.JTextField();
        precedentButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Login: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jLabel3.setText("Mot de passe: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel4.setText("Fonction: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        jLabel8.setText("Nom et prénom: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        NomField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomFieldActionPerformed(evt);
            }
        });
        jPanel1.add(NomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 120, -1));
        jPanel1.add(prenomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 120, -1));
        jPanel1.add(adresseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 120, -1));
        jPanel1.add(codeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 120, -1));

        precedentButton.setText("Annuler");
        precedentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precedentButtonActionPerformed(evt);
            }
        });
        jPanel1.add(precedentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 80, -1));

        jLabel1.setText("Id: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        idField.setBackground(new java.awt.Color(250, 250, 250));
        idField.setEnabled(false);
        jPanel1.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 120, -1));

        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 580, 310));

        jLabel5.setFont(new java.awt.Font("Vijaya", 1, 24)); // NOI18N
        jLabel5.setText("Ajouter administrateur");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       
        String login = NomField.getText();
        String motpass = prenomField.getText();
        String nomprenom = codeField.getText() ;
        String fonction = adresseField.getText();
        

      
        admin.setLoginAdmin(login);
        admin.setMtPasse(motpass);
        admin.setNomPrenom(nomprenom);
        admin.setFonction(fonction);
       
        String errors = adminBo.verifAdmin(admin);
        if (errors.equals("")) {
            if (ifAdd) {
               adminBo.insert(admin);
                this.setVisible(false);
                new MainAdministrateurForm().setVisible(true);
            } else {
                adminBo.update(admin);
                this.setVisible(false);
                new MainAdministrateurForm().setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Veuillez revérifier les champs suivants: \n" + errors, "Erreur", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void precedentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precedentButtonActionPerformed
        new MainAdministrateurForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_precedentButtonActionPerformed

    private void NomFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomFieldActionPerformed
    
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
            java.util.logging.Logger.getLogger(AjoutModifAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutModifAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutModifAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutModifAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutModifAdministrateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NomField;
    private javax.swing.JTextField adresseField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField codeField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton precedentButton;
    private javax.swing.JTextField prenomField;
    // End of variables declaration//GEN-END:variables
}
