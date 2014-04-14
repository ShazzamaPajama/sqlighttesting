/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sqlitetest;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author paul.koroski
 */
public class Sqlitetest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        Connection c = null;
        
        //Establish Database connection with Database File
        try {
            c = DriverManager.getConnection("jdbc:sqlite:testdb.db");
        } catch (SQLException ex) {
            Logger.getLogger(Sqlitetest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Could Not Print");
            System.exit(0);
        }
        
        // Execute Queries on Characters table
        System.out.println("Sucessfully connected to database");
        try {
            System.out.println("Printing table as is:");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CHARACTERS;");
            
            while(rs.next()){
                String name = rs.getString("Name");
                int Strength = rs.getInt("Strength");
                int Vitality = rs.getInt("Vitality");
                
                System.out.println("Character Name: " + name);
                System.out.println("Str: " + Strength);
                System.out.println("Vit: " + Vitality);
                System.out.println();
            }
            
            System.out.println("Printing table ordered by Strength:");
            rs = stmt.executeQuery("Select * FROM CHARACTERS ORDER BY Strength;");
            
            while(rs.next()){
                String name = rs.getString("Name");
                int Strength = rs.getInt("Strength");
                int Vitality = rs.getInt("Vitality");
                
                System.out.println("Character Name: " + name);
                System.out.println("Str: " + Strength);
                System.out.println("Vit: " + Vitality);
                System.out.println();
            }
            
            System.out.println("Printing table ordered by Vitality:");
            rs = stmt.executeQuery("Select * FROM CHARACTERS ORDER BY Vitality;");
            
            while(rs.next()){
                String name = rs.getString("Name");
                int Strength = rs.getInt("Strength");
                int Vitality = rs.getInt("Vitality");
                
                System.out.println("Character Name: " + name);
                System.out.println("Str: " + Strength);
                System.out.println("Vit: " + Vitality);
                System.out.println();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Sqlitetest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Could not execute query");
        }
    }
    
}
