/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author georg
 */
public class connectionMySQL {
    
    Connection connection = null;
    
    public Connection connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventario", "root", "");
            //JOptionPane.showConfirmDialog(null, "Success Connection");
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error Connection " + e.getMessage());
        }
        
        return connection;
    }
}
