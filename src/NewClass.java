
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewClass {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mysql";
        String user = "root";
        String pwd = "";
        try {
            Connection cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");

            Departement departementInfo=null;
 Filiere filiereInfo = new Filiere("Ingénierie Informatique", new Enseignant("Jane", "Smith", "jane@example.com", "Maître de conférences", null), departementInfo);
            int id=26;
            String nom="abid";
            String prenom="aymane";
            String email;
              email="aymaneaabid960@gmail.com";
            int apogee =11756932;
                    
         Etudiant etudiant0=new Etudiant(id,nom,prenom,email,apogee,filiereInfo);
     /*  insertEtudiant(etudiant0,cx);*/
        Note note =new Note(19,etudiant0,filiereInfo);
        Etudiant etudiant1=new Etudiant(id,note);
    /*insertNoteEtudiant(etudiant1,cx);*/
         Etudiant etudiant2=new Etudiant(id);
        etudiant2.DeleteEtudiant(etudiant2, cx);
          // Appel de la méthode getAllEtudaint pour obtenir tous les étudiants
        /* updateEtudiant(new Etudiant(id, "abid", "aymane", "aymaneaabid960@gmail.com", 188756932, filiereInfo),cx);*/
          List<Etudiant> etudiants = getAllEtudaint(cx);
        // Affichage des étudiants récupérés
        for (Etudiant etudiant : etudiants) {
        System.out.println("ID: " + etudiant.getId() +
                           ", Nom: " + etudiant.getNom() +
                           ", Prenom: " + etudiant.getPrenom() +
                           ", Email: " + etudiant.getEmail() +
                           ", Apogee: " + etudiant.getApogee() +
                           ", Filiere: " + etudiant.getFiliere().getIntitule());
    }

       
    
       
         

        
         
         

        } catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();
        }
    }


    public static void  insertEtudiant( Etudiant  etudiant, Connection cx) throws SQLException {
        String query = "INSERT INTO etudiant1 (id, nom,prenom,email,apogee,filiere) values (?,?,?,?,?,?)";
        String noteQuery = "INSERT INTO note (id, note) VALUES (?, ?)";
      PreparedStatement ps1 = cx.prepareStatement(noteQuery);
        PreparedStatement ps = cx.prepareStatement(query);

        ps.setInt(1,  etudiant.getId());
        ps.setString(2,  etudiant.getNom());
        ps.setString(3,  etudiant.getPrenom());
        ps.setString(4,  etudiant.getEmail());
        ps.setInt(5,  etudiant.getApogee());
        ps.setString(6,  etudiant.getFiliere().getIntitule());
    
            
        ps.executeUpdate();


    }
     public static void  insertNoteEtudiant( Etudiant  etudiant, Connection cx) throws SQLException {
        String query = "INSERT INTO note (id,note) values (?,?)";
        PreparedStatement ps = cx.prepareStatement(query);
        ps.setInt(1,  etudiant.getId());
        ps.setFloat(2,etudiant.getNote().getNote());
    
            
        ps.executeUpdate();


    }

  
   public static void deleteEtudiant(Etudiant etudiant, Connection cx) throws SQLException {
        String query = "DELETE  from etudiant1 where id = ?";
        Statement ps = cx.createStatement();
        ps.execute(query);


    }

    public static List<Etudiant> getAllEtudaint(Connection cx) throws SQLException {
        String query ="SELECT id, nom, prenom, email, apogee, filiere FROM etudiant1";
        List<Etudiant> etudiant = new ArrayList<>();

        Statement st = cx.createStatement();

        ResultSet r = st.executeQuery(query);

        while (r.next()) {
             Filiere filiere = new Filiere(r.getString("filiere"));
            etudiant.add(
                    new Etudiant(
                r.getInt("id"),
                r.getString("nom"),
                r.getString("prenom"),
                r.getString("email"),
                r.getInt("apogee"),
                filiere
            )
                    
                    
             
            );
                  
        }
        return etudiant;
    }
public static void updateEtudiant(Etudiant etudiant, Connection cx) throws SQLException {
    String query = "UPDATE etudiant1 SET nom=?, prenom=?, email=?, apogee=?, filiere=? WHERE id=?";

    PreparedStatement ps = cx.prepareStatement(query);

    ps.setString(1, etudiant.getNom());
    ps.setString(2, etudiant.getPrenom());
    ps.setString(3, etudiant.getEmail());
    ps.setInt(4, etudiant.getApogee());
    ps.setString(5, etudiant.getFiliere().getIntitule());
    ps.setInt(6, etudiant.getId());

    ps.executeUpdate();
}
   /*  public static void createTable(Connection cx) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS products(\n" +
                "                                       id int primary key auto_increment,\n" +
                "                                       name nvarchar(255),\n" +
                "                                       price int\n" +
                ");";

        Statement st = cx.createStatement();

        st.execute(query);


    }*/}