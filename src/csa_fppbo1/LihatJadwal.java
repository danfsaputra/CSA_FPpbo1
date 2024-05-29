/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package csa_fppbo1;

import database.dbconnection;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author ASUS TUF
 */
public class LihatJadwal extends javax.swing.JFrame {
     private String npm;
     private String nama;
     private String hari;

     public LihatJadwal() {
        initComponents();
    }
     
    
    public LihatJadwal(String nama, String npm, String hari){
        this.nama = nama;
        this.npm = npm;
        this.hari = hari;
        initComponents();
        // Setel teks label dengan nama yang diterima
        jLabel1.setText("Selamat datang, " + nama);
        jLabelTanggal.setText(hari);
        loadJadwal(hari);
    }

<<<<<<< HEAD
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
        jLabel2.setText("Tanggal: " + formatter.format(tanggalSekarang));
    }

    private void tampilkanJadwalDanTugas(String hari) {
        clearJadwalLabels();
        try {
            String query = "SELECT mata_kuliah, jam, tugas FROM jadwal_dan_tugas WHERE hari = '" + hari + "'";
            rs = st.executeQuery(query);
            int counter = 1;
            while (rs.next()) {
                if (counter == 1) {
                    setJadwalLabel(jLabel3, jLabelT1, rs);
                } else if (counter == 2) {
                    setJadwalLabel(jLabel4, jLabelT2, rs);
                } else if (counter == 3) {
                    setJadwalLabel(jLabel5, jLabelT3, rs);
                } else if (counter == 4) {
                    setJadwalLabel(jLabel6, jLabelT4, rs);
                }
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearJadwalLabels() {
        jLabel3.setText("");
        jLabel4.setText("");
        jLabel5.setText("");
        jLabel6.setText("");
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelT1 = new javax.swing.JLabel();
        jLabelT2 = new javax.swing.JLabel();
        jLabelT3 = new javax.swing.JLabel();
        jLabelT4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        add(jLabel2);
        add(jButtonSenin);
        add(jButtonSelasa);
        add(jButtonRabu);
        add(jButtonKamis);
        add(jButtonJumat);
        add(jLabel3);
        add(jLabelT1);
        add(jLabel4);
        add(jLabelT2);
        add(jLabel5);
        add(jLabelT3);
        add(jLabel6);
        add(jLabelT4);

        pack();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonSenin;
    private javax.swing.JButton jButtonSelasa;
    private javax.swing.JButton jButtonRabu;
    private javax.swing.JButton jButtonKamis;
    private javax.swing.JButton jButtonJumat;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelT1;
    private javax.swing.JLabel jLabelT2;
    private javax.swing.JLabel jLabelT3;
    private javax.swing.JLabel jLabelT4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}


=======
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void loadJadwal(String hari) {
        try {
            dbconnection koneksi = new dbconnection();
            Connection conn = koneksi.getConnection();
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");
            String query = "SELECT * FROM schedule WHERE hari = ? AND npm = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.hari);
            ps.setString(2, this.npm);
            ResultSet rs = ps.executeQuery();

            JLabel[] jLabelsJ = {jLabelJ1, jLabelJ2, jLabelJ3, jLabelJ4};
            JLabel[] jLabelsT = {jLabelJam1, jLabelJam2, jLabelJam3, jLabelJam4};
            JLabel[] jLabelsTask = {jLabelT1, jLabelT2, jLabelT3, jLabelT4};

            int index = 0;
            while (rs.next() && index < 4) {
                jLabelsJ[index].setText(rs.getString("mata_kuliah"));
                jLabelsT[index].setText(rs.getString("jam"));
                int scheduleId = rs.getInt("id");
                loadTugas(scheduleId, jLabelsTask[index]);
                index++;
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void loadTugas(int scheduleId, JLabel label) {
        try {
            dbconnection koneksi = new dbconnection();
            Connection conn = koneksi.getConnection();
            String query = "SELECT deskripsi_tugas FROM tugas WHERE schedule_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, scheduleId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                label.setText(rs.getString("deskripsi_tugas"));
            } else {
                label.setText("Tidak ada tugas.");
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    
    private void deleteJadwal(int index) {
        try {
            dbconnection koneksi = new dbconnection();
            Connection conn = koneksi.getConnection();
            //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");
            JLabel[] jLabelsJ = {jLabelJ1, jLabelJ2, jLabelJ3, jLabelJ4};
            JLabel[] jLabelsT = {jLabelJam1, jLabelJam2, jLabelJam3, jLabelJam4};

            String mataKuliah = jLabelsJ[index].getText();
            if (mataKuliah.equals("J1") || mataKuliah.equals("J2") || mataKuliah.equals("J3") || mataKuliah.equals("j4")) {
                JOptionPane.showMessageDialog(this, "Tidak ada jadwal yang dipilih untuk dihapus.");
                return;
            }

            String query = "DELETE FROM schedule WHERE hari = ? AND npm = ? AND mata_kuliah = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.hari);
            ps.setString(2, this.npm);
            ps.setString(3, mataKuliah);
            ps.executeUpdate();

            jLabelsJ[index].setText("Jadwal " + (index + 1));
            jLabelsT[index].setText("");

            ps.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Jadwal berhasil dihapus.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    
    private void deleteTugas(int index) {
        try {
            dbconnection koneksi = new dbconnection();
            Connection conn = koneksi.getConnection();
            JLabel[] jLabelsTask = {jLabelT1, jLabelT2, jLabelT3, jLabelT4};
            JLabel[] jLabelsJ = {jLabelJ1, jLabelJ2, jLabelJ3, jLabelJ4};

            String mataKuliah = jLabelsJ[index].getText();
            if (mataKuliah.equals("J1") || mataKuliah.equals("J2") || mataKuliah.equals("J3") || mataKuliah.equals("J4")) {
                JOptionPane.showMessageDialog(this, "Tidak ada tugas yang dipilih untuk dihapus.");
                return;
            }

            String query = "DELETE FROM tugas WHERE schedule_id = (SELECT id FROM schedule WHERE hari = ? AND npm = ? AND mata_kuliah = ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, this.hari);
            ps.setString(2, this.npm);
            ps.setString(3, mataKuliah);
            ps.executeUpdate();

            jLabelsTask[index].setText("Tidak ada tugas.");

            ps.close();
            conn.close();

            JOptionPane.showMessageDialog(this, "Tugas berhasil dihapus.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jhapustugas3 = new javax.swing.JButton();
        jhapustugas4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jhapustugas2 = new javax.swing.JButton();
        jButtonTtugas1 = new javax.swing.JButton();
        jButtonTtugas3 = new javax.swing.JButton();
        jButtonTtugas2 = new javax.swing.JButton();
        jButtonTtugas4 = new javax.swing.JButton();
        jButtonHapusJ4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
<<<<<<< HEAD
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
=======
        jLabelTanggal = new javax.swing.JLabel();
        jLabelJam4 = new javax.swing.JLabel();
        jLabelJam1 = new javax.swing.JLabel();
        jLabelJam2 = new javax.swing.JLabel();
        jLabelJam3 = new javax.swing.JLabel();
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963
        jLabelT4 = new javax.swing.JLabel();
        jLabelT1 = new javax.swing.JLabel();
        jLabelT2 = new javax.swing.JLabel();
        jLabelT3 = new javax.swing.JLabel();
<<<<<<< HEAD
        jButton21 = new javax.swing.JButton();
<<<<<<< HEAD
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
=======
=======
        jhapustugas1 = new javax.swing.JButton();
>>>>>>> 153c4bb81a5af810e76e40201305d19467e40c78
        jButtonHapusJ1 = new javax.swing.JButton();
        jButtonHapusJ2 = new javax.swing.JButton();
        jButtonHapusJ3 = new javax.swing.JButton();
        jLabelJ1 = new javax.swing.JLabel();
        jLabelJ2 = new javax.swing.JLabel();
        jLabelJ3 = new javax.swing.JLabel();
        jLabelJ4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jhapustugas3.setBackground(new java.awt.Color(218, 218, 218));
        jhapustugas3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jhapustugas3.setText("-");
        jhapustugas3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jhapustugas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhapustugas3ActionPerformed(evt);
            }
        });
        getContentPane().add(jhapustugas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 473, 20, 11));

        jhapustugas4.setBackground(new java.awt.Color(218, 218, 218));
        jhapustugas4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jhapustugas4.setText("-");
        jhapustugas4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jhapustugas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhapustugas4ActionPerformed(evt);
            }
        });
        getContentPane().add(jhapustugas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 583, 20, 11));

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

        jhapustugas2.setBackground(new java.awt.Color(218, 218, 218));
        jhapustugas2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jhapustugas2.setText("-");
        jhapustugas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jhapustugas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhapustugas2ActionPerformed(evt);
            }
        });
        getContentPane().add(jhapustugas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 362, 20, 11));

        jButtonTtugas1.setBackground(new java.awt.Color(218, 218, 218));
        jButtonTtugas1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonTtugas1.setText("+");
        jButtonTtugas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonTtugas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTtugas1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTtugas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 20, 11));

        jButtonTtugas3.setBackground(new java.awt.Color(218, 218, 218));
        jButtonTtugas3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonTtugas3.setText("+");
        jButtonTtugas3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonTtugas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTtugas3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTtugas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 473, 20, 11));

        jButtonTtugas2.setBackground(new java.awt.Color(218, 218, 218));
        jButtonTtugas2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonTtugas2.setText("+");
        jButtonTtugas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonTtugas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTtugas2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTtugas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 362, 20, 11));

        jButtonTtugas4.setBackground(new java.awt.Color(218, 218, 218));
        jButtonTtugas4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jButtonTtugas4.setText("+");
        jButtonTtugas4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonTtugas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTtugas4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonTtugas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 583, 20, 11));

        jButtonHapusJ4.setBackground(new java.awt.Color(218, 218, 218));
        jButtonHapusJ4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonHapusJ4.setText("-");
        jButtonHapusJ4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonHapusJ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusJ4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHapusJ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 510, 20, 11));

        jLabel1.setText("Nama");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 280, 30));

<<<<<<< HEAD
        jLabel2.setText("Tanggal");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, 20));

        jLabel6.setText("Jadwal 1");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 508, 150, -1));

        jLabel3.setText("Jadwal 1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 178, 150, -1));

        jLabel4.setText("Jadwal 1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 288, 150, -1));

        jLabel5.setText("Jadwal 1");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 398, 150, -1));
=======
        jLabelTanggal.setText("Tanggal");
        getContentPane().add(jLabelTanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 190, 20));

        jLabelJam4.setText("Jam");
        getContentPane().add(jLabelJam4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 505, 100, -1));

        jLabelJam1.setText("Jam");
        getContentPane().add(jLabelJam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 178, 100, -1));

        jLabelJam2.setText("Jam");
        getContentPane().add(jLabelJam2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 287, 100, -1));

        jLabelJam3.setText("Jam");
        getContentPane().add(jLabelJam3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 397, 100, -1));
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963
        getContentPane().add(jLabelT4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 280, 40));
        getContentPane().add(jLabelT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 280, 40));
        getContentPane().add(jLabelT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 280, 40));
        getContentPane().add(jLabelT3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 280, 40));

        jhapustugas1.setBackground(new java.awt.Color(218, 218, 218));
        jhapustugas1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jhapustugas1.setText("-");
        jhapustugas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jhapustugas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jhapustugas1ActionPerformed(evt);
            }
        });
        getContentPane().add(jhapustugas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 250, 20, 11));

        jButtonHapusJ1.setBackground(new java.awt.Color(218, 218, 218));
        jButtonHapusJ1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonHapusJ1.setText("-");
        jButtonHapusJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonHapusJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusJ1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHapusJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 180, 20, 11));

        jButtonHapusJ2.setBackground(new java.awt.Color(218, 218, 218));
        jButtonHapusJ2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonHapusJ2.setText("-");
        jButtonHapusJ2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonHapusJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusJ2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHapusJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 290, 20, 11));

        jButtonHapusJ3.setBackground(new java.awt.Color(218, 218, 218));
        jButtonHapusJ3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonHapusJ3.setText("-");
        jButtonHapusJ3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButtonHapusJ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHapusJ3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHapusJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 400, 20, 11));

<<<<<<< HEAD
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Tambah Tugas.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 660));
=======
        jLabelJ1.setText("J1");
        getContentPane().add(jLabelJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 178, 100, -1));

        jLabelJ2.setText("J2");
        getContentPane().add(jLabelJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 288, 100, -1));

        jLabelJ3.setText("J3");
        getContentPane().add(jLabelJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 398, 100, -1));

        jLabelJ4.setText("J4");
        getContentPane().add(jLabelJ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 508, 100, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Tambah Tugas.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 660));
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jhapustugas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhapustugas3ActionPerformed
        // TODO add your handling code here:
        deleteTugas(2);
    }//GEN-LAST:event_jhapustugas3ActionPerformed

    private void jhapustugas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhapustugas4ActionPerformed
        // TODO add your handling code here:
        deleteTugas(3);
    }//GEN-LAST:event_jhapustugas4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        MenuLihatJadwal mlj = new MenuLihatJadwal(nama, npm);
        mlj.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jhapustugas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhapustugas2ActionPerformed
        // TODO add your handling code here:
        deleteTugas(1);
    }//GEN-LAST:event_jhapustugas2ActionPerformed

    private void jButtonTtugas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTtugas1ActionPerformed
        // TODO add your handling code here:
        String namaMatkul = jLabelJ1.getText(); 
        String jam = jLabelJam1.getText(); 

        if (namaMatkul.equals("J1") || jam.equals("Jam")) {
            JOptionPane.showMessageDialog(this, "Jadwal kosong. Silakan pilih jadwal terlebih dahulu.");
            return;
        }

        TambahTugas tt = new TambahTugas(nama, npm, namaMatkul, jam);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonTtugas1ActionPerformed

    private void jButtonTtugas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTtugas3ActionPerformed
        // TODO add your handling code here:
        String namaMatkul = jLabelJ3.getText(); 
        String jam = jLabelJam3.getText(); 

        if (namaMatkul.equals("J1") || jam.equals("Jam")) {
            JOptionPane.showMessageDialog(this, "Jadwal kosong. Silakan pilih jadwal terlebih dahulu.");
            return;
        }

        TambahTugas tt = new TambahTugas(nama, npm, namaMatkul, jam);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonTtugas3ActionPerformed

    private void jButtonTtugas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTtugas2ActionPerformed
        // TODO add your handling code here:
        String namaMatkul = jLabelJ2.getText(); 
        String jam = jLabelJam2.getText(); 

        if (namaMatkul.equals("J1") || jam.equals("Jam")) {
            JOptionPane.showMessageDialog(this, "Jadwal kosong. Silakan pilih jadwal terlebih dahulu.");
            return;
        }

        TambahTugas tt = new TambahTugas(nama, npm, namaMatkul, jam);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonTtugas2ActionPerformed

    private void jButtonTtugas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTtugas4ActionPerformed
        // TODO add your handling code here:
        String namaMatkul = jLabelJ4.getText(); 
        String jam = jLabelJam4.getText(); 

        if (namaMatkul.equals("J1") || jam.equals("Jam")) {
            JOptionPane.showMessageDialog(this, "Jadwal kosong. Silakan pilih jadwal terlebih dahulu.");
            return;
        }

        TambahTugas tt = new TambahTugas(nama, npm, namaMatkul, jam);
        tt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonTtugas4ActionPerformed

    private void jButtonHapusJ4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusJ4ActionPerformed
        // TODO add your handling code here:
        deleteJadwal(3);
    }//GEN-LAST:event_jButtonHapusJ4ActionPerformed

    private void jhapustugas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jhapustugas1ActionPerformed
        // TODO add your handling code here:
         deleteTugas(0);
    }//GEN-LAST:event_jhapustugas1ActionPerformed

    private void jButtonHapusJ1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusJ1ActionPerformed
        // TODO add your handling code here:
        deleteJadwal(0);
    }//GEN-LAST:event_jButtonHapusJ1ActionPerformed

    private void jButtonHapusJ2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusJ2ActionPerformed
        // TODO add your handling code here:
        deleteJadwal(1);
    }//GEN-LAST:event_jButtonHapusJ2ActionPerformed

    private void jButtonHapusJ3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHapusJ3ActionPerformed
        // TODO add your handling code here:
        deleteJadwal(2);
    }//GEN-LAST:event_jButtonHapusJ3ActionPerformed

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
    private javax.swing.JButton jButtonHapusJ1;
    private javax.swing.JButton jButtonHapusJ2;
    private javax.swing.JButton jButtonHapusJ3;
    private javax.swing.JButton jButtonHapusJ4;
    private javax.swing.JButton jButtonTtugas1;
    private javax.swing.JButton jButtonTtugas2;
    private javax.swing.JButton jButtonTtugas3;
    private javax.swing.JButton jButtonTtugas4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
=======
    private javax.swing.JLabel jLabelJ1;
    private javax.swing.JLabel jLabelJ2;
    private javax.swing.JLabel jLabelJ3;
    private javax.swing.JLabel jLabelJ4;
    private javax.swing.JLabel jLabelJam1;
    private javax.swing.JLabel jLabelJam2;
    private javax.swing.JLabel jLabelJam3;
    private javax.swing.JLabel jLabelJam4;
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963
    private javax.swing.JLabel jLabelT1;
    private javax.swing.JLabel jLabelT2;
    private javax.swing.JLabel jLabelT3;
    private javax.swing.JLabel jLabelT4;
<<<<<<< HEAD
=======
    private javax.swing.JLabel jLabelTanggal;
<<<<<<< HEAD
>>>>>>> cfd59d478c6b85b3af7120f985651c4b1693e963
=======
    private javax.swing.JButton jhapustugas1;
    private javax.swing.JButton jhapustugas2;
    private javax.swing.JButton jhapustugas3;
    private javax.swing.JButton jhapustugas4;
>>>>>>> 153c4bb81a5af810e76e40201305d19467e40c78
    // End of variables declaration//GEN-END:variables
}
