/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayman
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Etudiant {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private int apogee;
    private Filiere filiere;
    private Note note;

    Etudiant(int id, String nom, String prenom,String email) {
       this.id=id;
       this.nom=nom;
       this.prenom=prenom;
       this.email=email;
               }

    Etudiant() {
        
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
    
    ArrayList<Note> notes = new ArrayList<Note>();

public Etudiant(int id){
this.id=id;
}

 public Etudiant(int id, String nom, String prenom, String email, int apogee) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
    }
    public Etudiant(int id,Note note) {
        this.id=id;
        this.note = note;
    }

    public Etudiant(int id, String nom, String prenom, String email, int apogee,Filiere filiere) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.filiere = filiere;
    }
    
    public Etudiant(int id, String nom, String prenom, String email, int apogee,String filiere) {
        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.apogee = apogee;
        this.getFiliere().getIntitule();
    }
  

    Etudiant(int id, String nom) {
       this.id=id;
       this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }
     public void ajouterNote(Note note) {
         notes.add(note);
	    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public  void insertEtudiant(Etudiant etudiant, Connection cx) throws SQLException {
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
      public  void DeleteEtudiant(Etudiant etudiant, Connection cx) throws SQLException {
          String query = "DELETE  from etudiant1 where id = ?";
        PreparedStatement ps = cx.prepareStatement(query);

        ps.setInt(1, etudiant.getId());

        ps.executeUpdate();
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
}
