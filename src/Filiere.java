/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayman
 */
import java.util.ArrayList;

public class Filiere {

    private int id;
    private String intitule;
    private Enseignant chef;
    private Departement dept;

    ArrayList<Module> modules = new ArrayList<Module>();
public Filiere() {
    }
    public Filiere(String intitule) {
        this.intitule=intitule;
    }

    public Filiere(String intitule, Enseignant chef, Departement dept) {
        this.intitule = intitule;
        this.chef = chef;
        this.dept = dept;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void ajouterModule(Module module) {
        int NOMBRE_MIN_MODULES=12;
         modules.add(module);
	        if (modules.size() < NOMBRE_MIN_MODULES) {
	           
                    System.out.println("add more.");
	        } else if(modules.size()>20) {
	            System.out.println("Nombre maximal de modules atteint pour cette filière.");
	        }
	    }
    public static Filiere updateFiliere(int id , String intitule, Enseignant chef, Departement dept){
        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        return  DB.filieres;
    }

    public static Filiere getFiliereById(int id){
        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DB.filieres;
    }
  
}
