/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package agile;

/**
 *
 * @author nancy
 */
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
public class L2 extends javax.swing.JFrame {

    /**
     * Creates new form List
     */
    public L2() {
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

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("FreeSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("STUDENT LIST");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 340, 40));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("FreeSerif", 1, 18)); // NOI18N
        jButton1.setText("SHOW LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, -1, -1));

        tab.setBackground(new java.awt.Color(204, 204, 204));
        tab.setFont(new java.awt.Font("FreeSerif", 1, 12)); // NOI18N
        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Regno", "Name"
            }
        ));
        jScrollPane1.setViewportView(tab);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 780, 230));

        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(744, 550, 80, 30));

        jButton3.setFont(new java.awt.Font("Century", 1, 12)); // NOI18N
        jButton3.setText("PRINT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 80, 30));

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 100, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\nancy\\OneDrive\\Pictures\\sepproj\\seat2.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1650, 940));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
/*  DefaultTableModel model = new DefaultTableModel();
model.addColumn("Ano");
model.addColumn("name");
model.addColumn("class");
model.addColumn("year");
model.addColumn("placr");


String selectedPlace = pl.getSelectedItem().toString();
String sqlQuery = "SELECT ANo,name,class,year,placr FROM student WHERE placr = ? GROUP BY placr";

try {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HBAS","root","samyu_park");
    PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
   
    pstmt.setString(1, selectedPlace);
   
    ResultSet resultSet = pstmt.executeQuery();

    while (resultSet.next()) {
        
        int Ano = resultSet.getInt("Ano");
       
        String name = resultSet.getString("name");
        String class1 = resultSet.getString("class");
        String year = resultSet.getString("year");
         String placr = resultSet.getString("place");
       // String placr = resultSet.getString("place");
        
        
        model.addRow(new Object[]{Ano, name,class1,year,placr});
    }

    tab.setModel(model); // Set the model to your JTable

    resultSet.close();
    pstmt.close();
    conn.close();
} catch (SQLException e) {
    e.printStackTrace();
}// TODO add your handling code here:*/
try{
      Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HBAS","root","samyu_park");
     // String str = stitle.getText();

    // String str = pl.getSelectedItem().toString();
    // PreparedStatement st = conn.prepareStatement("SELECT max(ANo),max(name),max(class),max(year),max(placr) FROM student  GROUP BY placr having placr=?");
 PreparedStatement st = conn.prepareStatement("SELECT regno,name  FROM profile2");
           // st.setString(1, str); 
            int i=0;
               DefaultTableModel m=(DefaultTableModel)tab.getModel();
               tab.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
               tab.setColumnSelectionAllowed(false);
               tab.setRowSelectionAllowed(true);
               tab.addRowSelectionInterval(1,2);
            //Excuting Query  
            ResultSet rs = st.executeQuery();  
            while (rs.next()) {  
               /* String isbn2 = rs.getString(1);  
                String bid2 = rs.getString(2);  
                String w2=rs.getString(3);
                String c2=rs.getString(4);
                String pr2=rs.getString(5);
                 
                //Sets Records in TextFields.  
                isbn1.setText(isbn2);
                 bid.setText(bid2);  
                w.setText(w2); 
                c.setText(c2);
                pr.setText(pr2);*/
                String a[]={rs.getString("regno"),rs.getString("name")};
                
                   m.insertRow(0,a);
                 
                
                 
            }// else {  
               //  javax.swing.JOptionPane.showMessageDialog(null, "Name not Found");  
            //}  
     
     
      }catch (SQLException | ClassNotFoundException e) {  
        javax.swing.JOptionPane.showMessageDialog(null, e);  
    }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();      
//new Aupload().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            tab.print();        // TODO add your handling code here:
        } catch (PrinterException ex) {
            Logger.getLogger(L2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel m=(DefaultTableModel)tab.getModel();
       m.setRowCount(0);
       m.setRowCount(10);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(L2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(L2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(L2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(L2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new L2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab;
    // End of variables declaration//GEN-END:variables
}
