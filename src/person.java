
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayman
 */
class Person {
     private int id;

     private String nom;
   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     
    Person(int id, String nom) {
        this.id=id;
        this.nom=nom;
    }
     Person(int id) {
        this.id=id;
    }
     public void setId(int id) {
        this.id = id;
    }
     public int getId() {
        return id;
    }
    
   public  void insertProduct(Person person, Connection cx) throws SQLException {
        String query = "INSERT INTO person (id, nom) values (?,?)";

        PreparedStatement ps = cx.prepareStatement(query);

        ps.setInt(1, person.getId());
        ps.setString(2, person.getNom());

        ps.executeUpdate();
}
      public  void DeleteProduct(Person person, Connection cx) throws SQLException {
          String query = "DELETE  from person where id = ?";
        PreparedStatement ps = cx.prepareStatement(query);

        ps.setInt(1, person.getId());

        ps.executeUpdate();
}
}