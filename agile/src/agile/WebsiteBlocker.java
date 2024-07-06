/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agile;

/**
 *
 * @author nancy
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User 1
 */
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WebsiteBlocker {

    public static void main(String[] args) {
        blockWebsite("chat.openai.com");
    }

    public static void blockWebsite(String website) {
        try {
            // Open the hosts file in append mode
            FileWriter fileWriter = new FileWriter("C:/Windows/System32/drivers/etc/hosts", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Add an entry to block the website
            printWriter.println("127.0.0.1 " + website);

            // Close the file
            printWriter.close();

            System.out.println("Website blocked successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


