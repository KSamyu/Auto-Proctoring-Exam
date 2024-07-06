/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agile;

/**
 *
 * @author nancy
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GoogleFormRedirector1 extends JFrame {
    public GoogleFormRedirector1() {
        setTitle("Proctor Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame to fullscreen
        setLocationRelativeTo(null);

        // Create a panel to hold the rules
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new BoxLayout(rulesPanel, BoxLayout.Y_AXIS));

        // Add 8 rules to the panel
        String[] rules = {
            "1. Familiarize yourself with the exam format and instructions.",
            "2. Ensure a stable internet connection.",
            "3. Create a suitable testing environment.",
            "4. Check your equipment and software.",
            "5. Avoid cheating or unauthorized assistance.",
            "6. Manage your time effectively.",
            "7. Save and submit your answers.",
            "8. Follow any additional exam-specific rules."
        };

        for (int i = 0; i < rules.length; i++) {
            JLabel ruleLabel = new JLabel(rules[i]);
            ruleLabel.setFont(new Font("Serif", Font.BOLD, 18)); // Increase font size
            ruleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label
            rulesPanel.add(ruleLabel);
        }

        // Display a "Good Luck!" message
        JLabel goodLuckLabel = new JLabel("Good Luck!");
        goodLuckLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Increase font size
        goodLuckLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label
        rulesPanel.add(goodLuckLabel);

        // Create a button
        JButton redirectButton = new JButton("Redirect to Google Form");
        redirectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
      Class.forName("com.mysql.jdbc.Driver");
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/agile","root","samyu_park");
                  String sql = "select link from gf  where id= 1";
  PreparedStatement pst=conn.prepareStatement(sql);
   //pst.setString(1, bid.getText());
   
    //  pst.setString(3, pr.getText());
     
     //pst.setString(4, part.getText());
     pst.execute();
        //pst.executeUpdate();
        //stmt.execute("update spareparts set sno="+sno.getText()+",partno="+part.getText()+" where itemname='"+itemname.getText()+"'");
       
           String url = "pst";
               // String url = "https://docs.google.com/forms/d/e/your-form-id/viewform";
               // String url = "https://docs.google.com/forms/d/e/1FAIpQLSd9ObkhQpHbCD8ZF3xdnxXsThbdjNMEd2l9z6VI3bfKzyTCKw/viewform?usp=sf_link";
               try {
                    Desktop.getDesktop().browse(new java.net.URI(url));
                }
               catch (Exception ex) {
                    ex.printStackTrace();
                }
       // javax.swing.JOptionPane.showMessageDialog(null, "Record is updated...");  
        //stmt.close();  
        conn.close();  
       // Referesh(); //Calling Referesh() method
       
}catch (SQLException | ClassNotFoundException e1) {  
        javax.swing.JOptionPane.showMessageDialog(null, e1);  
    } // Open the Google Form URL in a browser
              
            }
        });

        // Create a container for the button and rules
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Add the rules panel to the center of the content panel
        contentPanel.add(rulesPanel, BorderLayout.CENTER);

        // Add the button to the bottom of the content panel
        contentPanel.add(redirectButton, BorderLayout.SOUTH);

        // Add the content panel to the frame
        add(contentPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GoogleFormRedirector1().setVisible(true);
            }
        });
    }

    GoogleFormRedirector1(String url1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

