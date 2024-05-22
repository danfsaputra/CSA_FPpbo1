package csa_fppbo1;

import javax.swing.JOptionPane;
import java.sql.*;
import database.dbconnection;

public class Register extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    ResultSet rs;

    dbconnection koneksi;

    public Register() {
        initComponents();

        koneksi = new dbconnection();
        conn = koneksi.getConnection();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNama = new javax.swing.JTextField();
        jTextFieldNpm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNama.setBackground(new java.awt.Color(218, 218, 218));
        jTextFieldNama.setBorder(null);
        jTextFieldNama.setVerifyInputWhenFocusTarget(false);
        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 215, 300, 40));

        jTextFieldNpm.setBackground(new java.awt.Color(218, 218, 218));
        jTextFieldNpm.setBorder(null);
        jTextFieldNpm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNpmActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNpm, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 315, 300, 40));

        jButton1.setBackground(new java.awt.Color(218, 218, 218));
        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Masuk");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 470, 70, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Dasboard2.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

    private void jTextFieldNpmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNpmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNpmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nama = jTextFieldNama.getText();
        String npm = jTextFieldNpm.getText();

        try {
            // Cek apakah nama dan npm sudah ada di database
            String checkSql = "SELECT * FROM register WHERE nama = ? AND npm = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, nama);
            checkStmt.setString(2, npm);
            rs = checkStmt.executeQuery();

            if (rs.next()) {
                // Jika data sudah ada, arahkan ke HalamanUtama
                HalamanUtama hu = new HalamanUtama(nama, npm);
                hu.setVisible(true);
                this.setVisible(false);
            } else {
                // Jika data belum ada, simpan data baru dan kemudian arahkan ke HalamanUtama
                String insertSql = "INSERT INTO register (nama, npm) VALUES (?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSql);
                insertStmt.setString(1, nama);
                insertStmt.setString(2, npm);
                insertStmt.executeUpdate();

                HalamanUtama hu = new HalamanUtama(nama, npm);
                hu.setVisible(true);
                this.setVisible(false);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldNpm;
    // End of variables declaration//GEN-END:variables
}
