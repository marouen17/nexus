/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import nexus.java.business.AnimalBo;
import nexus.java.entity.Animal;

/**
 *
 * @author MaruLanD
 */
class AfficherAnimalModel extends AbstractTableModel {

    List<Animal> animals = new ArrayList<Animal>();
    String[] headers = {"Id", "Espece",
        "Couleur", "Race", "Taille", "Age", "Sexe", "Commentaire", "propriétaire"};

    public AfficherAnimalModel() {
        AnimalBo animalBo = AnimalBo.getInstance();
        animals = animalBo.readAll();
    }

    public int getRowCount() {
        return animals.size();
    }

    public int getColumnCount() {
        return headers.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return animals.get(rowIndex).getIdAnimal();
            case 1:
                return animals.get(rowIndex).getEspece();
            case 2:
                return animals.get(rowIndex).getCouleur();
            case 3:
                return animals.get(rowIndex).getType();
            case 4:
                return animals.get(rowIndex).getTaille();
            case 5:
                return animals.get(rowIndex).getAge();
            case 6:
                return animals.get(rowIndex).getSexe();
            case 7:
                return animals.get(rowIndex).getCommentaire();
            case 8:
                if (animals.get(rowIndex).getMembre() != null) {
                    return animals.get(rowIndex).getMembre().getNom() + " " + animals.get(rowIndex).getMembre().getPrenom();
                }

            default:
                return null;

        }
    }

    @Override
    public String getColumnName(int column) {
        return headers[column];
    }
}

public class MainAnimalForm extends javax.swing.JFrame {

    private AnimalBo animalBo = AnimalBo.getInstance();

    public MainAnimalForm() {
        initComponents();
        jTAffichage.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBAdd = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane(jTAffichage, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jTAffichage = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("icon.jpg")).getImage());
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBAdd.setText("Ajouter");
        jBAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAddActionPerformed(evt);
            }
        });
        jPanel1.add(jBAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 23, 80, -1));

        jBUpdate.setText("Modifier");
        jBUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(jBUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 82, -1));

        jBDelete.setText("Supprimer");
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(jBDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 98, -1, -1));

        jTAffichage.setModel(new AfficherAnimalModel());
        jTAffichage.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(jTAffichage);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, 590, 340));

        jLabel1.setFont(new java.awt.Font("Utsaah", 1, 24)); // NOI18N
        jLabel1.setText("Gestion des animaux");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAddActionPerformed
        new AnimalAddUpdateForm().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBAddActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed

        if ((int) jTAffichage.getModel().getValueAt(jTAffichage.getSelectedRow(), 0) != -1) {
            new AnimalAddUpdateForm((int) jTAffichage.getModel().getValueAt(jTAffichage.getSelectedRow(), 0)).setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Erreur", "Vous devez d'abord selectionner la ligne à modifier", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBUpdateActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        int id = (int) jTAffichage.getModel().getValueAt(jTAffichage.getSelectedRow(), 0);
        if (id != -1) {
            if (JOptionPane.showConfirmDialog(null, "êtes-vous sure de vouloir supprimer cette ligne?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Animal animal = animalBo.readByID(id);
                animalBo.delete(animal);
                jTAffichage.setModel(new AfficherAnimalModel());
            }

        } else {
            JOptionPane.showMessageDialog(null, "Erreur", "Vous devez d'abord selectionner la ligne à modifier", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainAnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainAnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainAnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainAnimalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainAnimalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdd;
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTAffichage;
    // End of variables declaration//GEN-END:variables
}
