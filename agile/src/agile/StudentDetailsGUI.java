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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class StudentDetailsGUI extends JFrame {
    private JTextField regNoField;
    private JTextField nameField;
    private JTextField fathersNameField;
    private JTextField nationalityField;
    private JTextField maritalStatusField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/agile";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "samyu_park";
    private static final String ENCRYPTION_KEY = "krisahim";

    public StudentDetailsGUI() {
        setTitle("Student Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(9, 2));

        JLabel regNoLabel = new JLabel("Enter Reg No:");
        regNoField = new JTextField(20);
        JButton getDetailsButton = new JButton("Get Details");

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);

        JLabel fathersNameLabel = new JLabel("Father's Name:");
        fathersNameField = new JTextField(20);

        JLabel nationalityLabel = new JLabel("Nationality:");
        nationalityField = new JTextField(20);

        JLabel maritalStatusLabel = new JLabel("Marital Status:");
        maritalStatusField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField(20);

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField(20);

        getDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getStudentDetails();
            }
        });

        panel.add(regNoLabel);
        panel.add(regNoField);
        panel.add(getDetailsButton);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(fathersNameLabel);
        panel.add(fathersNameField);

        panel.add(nationalityLabel);
        panel.add(nationalityField);

        panel.add(maritalStatusLabel);
        panel.add(maritalStatusField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(phoneLabel);
        panel.add(phoneField);

        panel.add(addressLabel);
        panel.add(addressField);

        add(panel);
    }

    private void getStudentDetails() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            // Retrieve student details from the database based on regNoField
            String query = "SELECT name, fathersname, nationality, maritalstatus, email, phonenumber, address FROM students2 WHERE registerno = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, regNoField.getText());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nameField.setText(resultSet.getString("name"));
                fathersNameField.setText(resultSet.getString("fathersname"));
                nationalityField.setText(resultSet.getString("nationality"));
                maritalStatusField.setText(resultSet.getString("maritalstatus"));
                String encryptedEmail = resultSet.getString("email");
                String encryptedPhone = resultSet.getString("phonenumber");
                String encryptedAddress = resultSet.getString("address");

                // Decrypt and set the encrypted values in the respective fields
                emailField.setText(decrypt(encryptedEmail));
                phoneField.setText(decrypt(encryptedPhone));
                addressField.setText(decrypt(encryptedAddress));
            } else {
                JOptionPane.showMessageDialog(this, "Student with Reg No not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private String decrypt(String encryptedData) {
        try {
            // Create AES decryption cipher
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            // Decrypt the data
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentDetailsGUI gui = new StudentDetailsGUI();
            gui.setVisible(true);
        });
    }
}
