/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agile;

/**
 *
 * @author nancy
 */
import java.sql.*;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;
import javax.crypto.spec.*;

public class StudentDetailsEncryption {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/agile";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "samyu_park";
    private static final String ENCRYPTION_KEY = "123456789rrrrrrrrrrrrrrrrrrrrrrrrrrr";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();

            // Retrieve student details from the database
            String query = "SELECT name, email, address, phone FROM students";
            resultSet = statement.executeQuery(query);

            // Display student details
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String encryptedEmail = encrypt(resultSet.getString("email"));
                String encryptedAddress = encrypt(resultSet.getString("address"));
                String encryptedPhone = encrypt(resultSet.getString("phone"));

                System.out.println("Name: " + name);
                System.out.println("Email: " + encryptedEmail);
                System.out.println("Address: " + encryptedAddress);
                System.out.println("Phone: " + encryptedPhone);
                System.out.println("----------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close database resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String encrypt(String data) {
        try {
            // Create AES encryption cipher
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCRYPTION_KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            // Encrypt the data
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

