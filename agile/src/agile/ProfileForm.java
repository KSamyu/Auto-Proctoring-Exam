package agile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileForm extends JFrame {
    private JLabel nameLabel;
    private JLabel emailLabel;
    private JLabel instituteLabel;
    private JLabel fatherLabel;
    private JLabel countryLabel;
    private JLabel maritalStatusLabel;
    private JLabel DOB;
    private JButton loginButton;
    private JCheckBox agreeCheckBox;

    public ProfileForm(String username) {
        setTitle("Profile Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame to fullscreen
        setLocationRelativeTo(null);

        nameLabel = new JLabel("Name: ");
        emailLabel = new JLabel("Email: ");
        instituteLabel = new JLabel("Institute: ");
        fatherLabel = new JLabel("Father's Name: ");
        countryLabel = new JLabel("Country: ");
        maritalStatusLabel = new JLabel("Marital Status: ");
        DOB = new JLabel("Other Details: ");
        loginButton = new JButton("Take Test");
        agreeCheckBox = new JCheckBox("I agree to take the test");
        agreeCheckBox.setFont(new Font("Arial", Font.PLAIN, 14)); // Adjust font size

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (agreeCheckBox.isSelected()) {
                    GoogleFormRedirector11 profileForm = new GoogleFormRedirector11();
                    profileForm.setVisible(true);
                    dispose();
                    JOptionPane.showMessageDialog(ProfileForm.this, "Redirecting to the exam page");
                } else {
                    JOptionPane.showMessageDialog(ProfileForm.this, "Please agree to take the test.");
                }
            }
        });

        setLayout(new GridLayout(10, 2)); // Adjust grid rows to accommodate the new elements
        add(new JLabel("Profile Details:"));
      //  add(new JLabel(" "); // Empty label for spacing
        add(nameLabel);
        add(emailLabel);
        add(instituteLabel);
        add(fatherLabel);
        add(countryLabel);
        add(maritalStatusLabel);
        add(DOB);
        add(agreeCheckBox); // Add the checkbox
        add(loginButton);

        // Fetch user details from the database
        fetchUserDetails(username);
    }

    private void fetchUserDetails(String username) {
        // Replace these with your actual database connection details
        String jdbcURL = "jdbc:mysql://localhost:3306/hbas";
        String dbUsername = "root";
        String dbPassword = "samyu_park";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUsername, dbPassword)) {
            String query = "SELECT name, email, institute, fname, country, marstatus, DOB FROM profile2 WHERE regno=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nameLabel.setText("Name: " + resultSet.getString("name"));
                emailLabel.setText("Email: " + resultSet.getString("email"));
                instituteLabel.setText("Institute: " + resultSet.getString("institute"));
                fatherLabel.setText("Father's Name: " + resultSet.getString("fname"));
                countryLabel.setText("Country: " + resultSet.getString("country"));
                maritalStatusLabel.setText("Marital Status: " + resultSet.getString("marstatus"));
                DOB.setText("Other Details: " + resultSet.getString("DOB"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // This is a separate form, typically opened from the login form.
        // You should add code to create and display the ProfileForm.
    }
}