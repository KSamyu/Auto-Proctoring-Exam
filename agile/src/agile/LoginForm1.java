package agile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class LoginForm1 extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;
    private JTextField captchaField;
    private JButton loginButton;
    private JLabel captchaLabel;

    public LoginForm1() {
        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Set the frame to full screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;

        // Username
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Username:"), c);
        c.gridx = 1;
        add(Box.createRigidArea(new Dimension(10, 0))); // Create spacing
        c.gridx = 2;
        nameField = new JTextField(10);
        add(nameField, c);

        // Password
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Password:"), c);
        c.gridx = 2;
        passwordField = new JPasswordField(10);
        add(passwordField, c);

        // CAPTCHA
        String captchaText = generateCaptchaText();
        c.gridx = 0;
        c.gridy = 2;
        add(new JLabel("CAPTCHA:"), c);
        c.gridx = 2;
        captchaLabel = new JLabel(captchaText);
        add(captchaLabel, c);

        // CAPTCHA Input Field
        c.gridx = 0;
        c.gridy = 3;
        add(Box.createRigidArea(new Dimension(10, 0))); // Create spacing
        c.gridx = 2;
        captchaField = new JTextField(10);
        add(captchaField, c);

        // Login Button
        c.gridx = 0;
        c.gridy = 4;
        add(Box.createRigidArea(new Dimension(10, 0))); // Create spacing
        c.gridx = 2;
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String enteredCaptcha = captchaField.getText();

                // Verify the CAPTCHA
                if (enteredCaptcha.equalsIgnoreCase(captchaText)) {
                    boolean isValid = checkCredentials(name, password);

                    if (isValid) {
                     ProfileForm profileForm = new ProfileForm(name);
                     profileForm.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(LoginForm1.this, "Invalid credentials. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginForm1.this, "CAPTCHA verification failed.");
                }
            }
        });
        add(loginButton, c);
    }

    private boolean checkCredentials(String name, String password) {
        // Replace with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/hbas";
        String username = "root";
        String dbPassword = "samyu_park";

        try (Connection connection = DriverManager.getConnection(url, username, dbPassword)) {
            String query = "SELECT * FROM alogin WHERE uname=? AND psswd=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
            //Amain a=new Amain();
          //  a.setVisible(true); // If a row is returned, credentials are valid
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateCaptchaText() {
        // Generates a random CAPTCHA text
        int length = 6; // You can adjust the length of the CAPTCHA text
        Random random = new Random();
        StringBuilder captchaText = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        for (int i = 0; i < length; i++) {
            captchaText.append(characters.charAt(random.nextInt(characters.length())));
        }

        return captchaText.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm1 loginForm = new LoginForm1();
            loginForm.setVisible(true);
        });
    }
}