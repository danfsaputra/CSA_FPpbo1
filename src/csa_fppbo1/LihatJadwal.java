/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package csa_fppbo1;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.sql.DriverManager;

/**
 * LihatJadwal class
 */
public class LihatJadwal extends javax.swing.JFrame {
    public Connection con;
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel model;
    private String npm;
    private String nama;
    private Date tanggalSekarang;

    public LihatJadwal() {
        initComponents();
        String[] header = {"mata_kuliah"};
        model = new DefaultTableModel(header, 0);
        connectToDatabase();
        setTanggal();
    }

    public LihatJadwal(String nama, String npm) {
        this.nama = nama;
        this.npm = npm;
        initComponents();
        jLabel1.setText("Selamat datang, " + nama);
        connectToDatabase();
        setTanggal();
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/csa_fppbo"; // Ganti dengan URL database Anda
            String user = "root"; // Ganti dengan username database Anda
            String password = ""; // Ganti dengan password database Anda
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setTanggal() {
        tanggalSekarang = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");
        tanggal.setText("Tanggal: " + formatter.format(tanggalSekarang));
    }

    private void tampilkanJadwalDanTugas(String hari) {
        clearJadwalLabels();
        try {
            String query = "SELECT mata_kuliah, jam, tugas FROM jadwal_dan_tugas WHERE hari = '" + hari + "'";
            rs = st.executeQuery(query);
            int counter = 1;
            while (rs.next()) {
                if (counter == 1) {
                    setJadwalLabel(jadwal1, jLabelT1, rs);
                } else if (counter == 2) {
                    setJadwalLabel(jadwal2, jLabelT2, rs);
                } else if (counter == 3) {
                    setJadwalLabel(jadwal3, jLabelT3, rs);
                } else if (counter == 4) {
                    setJadwalLabel(jadwal4, jLabelT4, rs);
                }
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearJadwalLabels() {
        jadwal1.setText("");
        jadwal2.setText("");
        jadwal3.setText("");
        jadwal4.setText("");
        jLabelT1.setText("");
        jLabelT2.setText("");
        jLabelT3.setText("");
        jLabelT4.setText("");
    }

    private void setJadwalLabel(JLabel jadwalLabel, JLabel tugasLabel, ResultSet rs) throws SQLException {
        String mataKuliah = rs.getString("mata_kuliah");
        String jam = rs.getString("jam");
        String tugas = rs.getString("tugas");
        jadwalLabel.setText(mataKuliah + " - " + jam);
        tugasLabel.setText(tugas);
    }

    private void jButtonSeninActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanJadwalDanTugas("Senin");
    }

    private void jButtonSelasaActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanJadwalDanTugas("Selasa");
    }

    private void jButtonRabuActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanJadwalDanTugas("Rabu");
    }

    private void jButtonKamisActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanJadwalDanTugas("Kamis");
    }

    private void jButtonJumatActionPerformed(java.awt.event.ActionEvent evt) {
        tampilkanJadwalDanTugas("Jumat");
    }

    private void initComponents() {
        jButtonSenin = new javax.swing.JButton();
        jButtonSelasa = new javax.swing.JButton();
        jButtonRabu = new javax.swing.JButton();
        jButtonKamis = new javax.swing.JButton();
        jButtonJumat = new javax.swing.JButton();
        jadwal1 = new javax.swing.JLabel();
        jadwal2 = new javax.swing.JLabel();
        jadwal3 = new javax.swing.JLabel();
        jadwal4 = new javax.swing.JLabel();
        jLabelT1 = new javax.swing.JLabel();
        jLabelT2 = new javax.swing.JLabel();
        jLabelT3 = new javax.swing.JLabel();
        jLabelT4 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jButtonSenin.setText("Senin");
        jButtonSelasa.setText("Selasa");
        jButtonRabu.setText("Rabu");
        jButtonKamis.setText("Kamis");
        jButtonJumat.setText("Jumat");

        jButtonSenin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeninActionPerformed(evt);
            }
        });

        jButtonSelasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelasaActionPerformed(evt);
            }
        });

        jButtonRabu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRabuActionPerformed(evt);
            }
        });

        jButtonKamis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKamisActionPerformed(evt);
            }
        });

        jButtonJumat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJumatActionPerformed(evt);
            }
        });

        // Contoh sederhana layout, bisa disesuaikan dengan kebutuhan
        setLayout(new java.awt.GridLayout(6, 2));
        add(jLabel1);
        add(tanggal);
        add(jButtonSenin);
        add(jButtonSelasa);
        add(jButtonRabu);
        add(jButtonKamis);
        add(jButtonJumat);
        add(jadwal1);
        add(jLabelT1);
        add(jadwal2);
        add(jLabelT2);
        add(jadwal3);
        add(jLabelT3);
        add(jadwal4);
        add(jLabelT4);

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonSenin;
    private javax.swing.JButton jButtonSelasa;
    private javax.swing.JButton jButtonRabu;
    private javax.swing.JButton jButtonKamis;
    private javax.swing.JButton jButtonJumat;
    private javax.swing.JLabel jadwal1;
    private javax.swing.JLabel jadwal2;
    private javax.swing.JLabel jadwal3;
    private javax.swing.JLabel jadwal4;
    private javax.swing.JLabel jLabelT1;
    private javax.swing.JLabel jLabelT2;
    private javax.swing.JLabel jLabelT3;
    private javax.swing.JLabel jLabelT4;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jadwal4 = new javax.swing.JLabel();
        jadwal1 = new javax.swing.JLabel();
        jadwal2 = new javax.swing.JLabel();
        jadwal3 = new javax.swing.JLabel();
        jLabelT4 = new javax.swing.JLabel();
        jLabelT1 = new javax.swing.JLabel();
        jLabelT2 = new javax.swing.JLabel();
        jLabelT3 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        tugas2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(218, 218, 218));
        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setText("-");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 473, 20, 11));

        jButton9.setBackground(new java.awt.Color(218, 218, 218));
        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setText("-");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 583, 20, 11));

        jButton10.setBackground(new java.awt.Color(218, 218, 218));
        jButton10.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton10.setText("Kembali");
        jButton10.setBorder(null);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(903, 630, 60, 20));

        jButton11.setBackground(new java.awt.Color(218, 218, 218));
        jButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton11.setText("-");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 362, 20, 11));

        jButton16.setBackground(new java.awt.Color(218, 218, 218));
        jButton16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton16.setText("+");
        jButton16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 20, 11));

        jButton17.setBackground(new java.awt.Color(218, 218, 218));
        jButton17.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton17.setText("+");
        jButton17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 473, 20, 11));

        jButton18.setBackground(new java.awt.Color(218, 218, 218));
        jButton18.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton18.setText("+");
        jButton18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 362, 20, 11));

        jButton19.setBackground(new java.awt.Color(218, 218, 218));
        jButton19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButton19.setText("+");
        jButton19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 583, 20, 11));

        jButton20.setBackground(new java.awt.Color(218, 218, 218));
        jButton20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton20.setText("-");
        jButton20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 510, 20, 11));

        jLabel1.setText("Nama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 280, 30));

        tanggal.setText("Tanggal");
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, 20));

        jadwal4.setText("Jadwal 1");
        getContentPane().add(jadwal4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 508, 150, -1));

        jadwal1.setText("Jadwal 1");
        getContentPane().add(jadwal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 178, 150, -1));

        jadwal2.setText("Jadwal 1");
        getContentPane().add(jadwal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 288, 150, -1));

        jadwal3.setText("Jadwal 1");
        getContentPane().add(jadwal3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 398, 150, -1));
        getContentPane().add(jLabelT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 280, 40));
        getContentPane().add(jLabelT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 280, 40));
        getContentPane().add(jLabelT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 280, 40));
        getContentPane().add(jLabelT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 280, 40));

        jButton21.setBackground(new java.awt.Color(218, 218, 218));
        jButton21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton21.setText("-");
        jButton21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 250, 20, 11));

        jButton22.setBackground(new java.awt.Color(218, 218, 218));
        jButton22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton22.setText("-");
        jButton22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 180, 20, 11));

        jButton23.setBackground(new java.awt.Color(218, 218, 218));
        jButton23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton23.setText("-");
        jButton23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 290, 20, 11));

        jButton24.setBackground(new java.awt.Color(218, 218, 218));
        jButton24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton24.setText("-");
        jButton24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 400, 20, 11));

        tugas2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Tambah Tugas.png"))); // NOI18N
        getContentPane().add(tugas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 660));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        MenuLihatJadwal mlj = new MenuLihatJadwal(nama, npm);
        mlj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        TambahTugas tt = new TambahTugas(nama, npm);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        TambahTugas tt = new TambahTugas(nama, npm);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        TambahTugas tt = new TambahTugas(nama, npm);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        TambahTugas tt = new TambahTugas(nama, npm);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

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
            java.util.logging.Logger.getLogger(LihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LihatJadwal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LihatJadwal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelT1;
    private javax.swing.JLabel jLabelT2;
    private javax.swing.JLabel jLabelT3;
    private javax.swing.JLabel jLabelT4;
    private javax.swing.JLabel jadwal1;
    private javax.swing.JLabel jadwal2;
    private javax.swing.JLabel jadwal3;
    private javax.swing.JLabel jadwal4;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel tugas2;
    // End of variables declaration//GEN-END:variables
}