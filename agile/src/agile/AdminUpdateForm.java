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

public class AdminUpdateForm extends JFrame {
    private JTextField googleFormURLField; // Text field for Google Form URL

    public AdminUpdateForm() {
        setTitle("Admin Update Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set to fullscreen
        setLocationRelativeTo(null);

        // Create a panel for admin input
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.Y_AXIS));
        adminPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Align panel to the center

        // Text field for admin to update the Google Form URL
        googleFormURLField = new JTextField("https://docs.google.com/forms/d/e/your-form-id/viewform", 20);
        googleFormURLField.setHorizontalAlignment(JTextField.CENTER); // Align text field contents to center
        adminPanel.add(Box.createVerticalGlue()); // Add vertical glue to center-align the text field
        adminPanel.add(googleFormURLField);
        adminPanel.add(Box.createVerticalGlue()); // Add vertical glue to center-align the button

        // Button to update the Google Form URL
        JButton updateButton = new JButton("Update Google Form URL");
        updateButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button to the center
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the updated Google Form URL from the text field
                String updatedURL = googleFormURLField.getText();
               
                // Do something with the updated URL (you can add more functionality here)
               
                // Display a success message
                JOptionPane.showMessageDialog(AdminUpdateForm.this, "URL updated successfully!");
            }
        });
        adminPanel.add(updateButton);
       
        // Button to go back
        JButton backButton = new JButton("Back");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button to the center
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform actions to go back to the previous frame or close the current frame
                // For example, you can dispose the current frame:
                dispose();
            }
        });
        adminPanel.add(backButton);

        // Add the admin input panel to the frame
        add(adminPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdminUpdateForm().setVisible(true);
            }
        });
    }
}
