
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayman
 */
public class main {
    public static void main(String[] args) {
        // Création d'un département et d'un enseignant responsable
        
        Departement departementInfo = new Departement("Informatique", new Enseignant("John", "Doe", "john@example.com", "Professeur", null));
        
        // Création d'une filière avec l'enseignant responsable
        Filiere filiereInfo = new Filiere("Ingénierie Informatique", new Enseignant("Jane", "Smith", "jane@example.com", "Maître de conférences", null), departementInfo);

        // Création de plusieurs modules
        Module module1 = new Module("Programmation Java", filiereInfo, null);
        Module module2 = new Module("Algorithmique1", filiereInfo, null);
        Module module3 = new Module("Algorithmique2", filiereInfo, null);
        Module module4 = new Module("Algorithmique3", filiereInfo, null);
        Module module5 = new Module("Algorithmique4", filiereInfo, null);
        Module module6 = new Module("Algorithmique5", filiereInfo, null);
        Module module7 = new Module("Algorithmique6", filiereInfo, null);
        Module module8 = new Module("Algorithmique7", filiereInfo, null);
        Module module9 = new Module("Algorithmique8", filiereInfo, null);
        Module module10 = new Module("Algorithmique9", filiereInfo, null);
        Module module11= new Module("Algorithmique10", filiereInfo, null);
        Module module12= new Module("Algorithmique11", filiereInfo, null);
        Module module13 = new Module("Algorithmique12", filiereInfo, null);
        Module module14 = new Module("Algorithmique13", filiereInfo, null);
        Module module15= new Module("Algorithmique14", filiereInfo, null);
       
        filiereInfo.ajouterModule(module1);
        filiereInfo.ajouterModule(module2);
        filiereInfo.ajouterModule(module3);
        filiereInfo.ajouterModule(module4);
        filiereInfo.ajouterModule(module5);
        filiereInfo.ajouterModule(module6);
        filiereInfo.ajouterModule(module7);
        filiereInfo.ajouterModule(module8);
        filiereInfo.ajouterModule(module9);
        filiereInfo.ajouterModule(module10);
        filiereInfo.ajouterModule(module11);
        filiereInfo.ajouterModule(module12);
        filiereInfo.ajouterModule(module13);
        filiereInfo.ajouterModule(module14);
        filiereInfo.ajouterModule(module15);
   System.out.println("Modules de la filière " + filiereInfo.getIntitule() + ":");
        for (Module module : filiereInfo.getModules()) {
            System.out.println(module.getIntitule());
        }
}
}