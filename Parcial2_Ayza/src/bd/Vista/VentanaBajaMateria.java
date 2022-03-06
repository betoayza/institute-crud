/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.Vista;

import bd.Modelo.ManejoBD;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author beto
 */
public class VentanaBajaMateria extends javax.swing.JInternalFrame {

    /**
     * Creates new form BajaMateria
     */
    public VentanaBajaMateria() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbl_tituloBajaMateria = new javax.swing.JLabel();
        jlbl_ID_bajaMateria = new javax.swing.JLabel();
        jtf_ID_bajaMateria = new javax.swing.JTextField();
        jb_AceptarBajaMateria = new javax.swing.JButton();
        jb_cancelarBajaMateria = new javax.swing.JButton();

        jlbl_tituloBajaMateria.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        jlbl_tituloBajaMateria.setText("Baja Materia");

        jlbl_ID_bajaMateria.setText("ID:");

        jb_AceptarBajaMateria.setText("Aceptar");
        jb_AceptarBajaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_AceptarBajaMateriaActionPerformed(evt);
            }
        });

        jb_cancelarBajaMateria.setText("Cancelar");
        jb_cancelarBajaMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarBajaMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtf_ID_bajaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jb_cancelarBajaMateria)
                            .addComponent(jlbl_tituloBajaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jlbl_ID_bajaMateria))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jb_AceptarBajaMateria)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlbl_tituloBajaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlbl_ID_bajaMateria)
                .addGap(18, 18, 18)
                .addComponent(jtf_ID_bajaMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_AceptarBajaMateria)
                    .addComponent(jb_cancelarBajaMateria))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarBajaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarBajaMateriaActionPerformed
        dispose();
    }//GEN-LAST:event_jb_cancelarBajaMateriaActionPerformed

    private void jb_AceptarBajaMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_AceptarBajaMateriaActionPerformed
        ManejoBD manbd = new ManejoBD();
        try {
            manbd.bajaMateria(this.jtf_ID_bajaMateria.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(VentanaBajaMateria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_AceptarBajaMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_AceptarBajaMateria;
    private javax.swing.JButton jb_cancelarBajaMateria;
    private javax.swing.JLabel jlbl_ID_bajaMateria;
    private javax.swing.JLabel jlbl_tituloBajaMateria;
    private javax.swing.JTextField jtf_ID_bajaMateria;
    // End of variables declaration//GEN-END:variables
}