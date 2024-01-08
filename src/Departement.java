/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ayman
 */
import java.util.ArrayList;
import java.util.List;

public class Departement {
         private int id;
	    private String intitule;
	    private Enseignant responsable;
	    private List<Filiere> filieres;
	    
		public Departement(String intitule, Enseignant responsable) {
			super();
			this.intitule = intitule;
			this.responsable = responsable;
			this.filieres = new ArrayList<>();
		}

    private Departement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
		public String getIntitule() {
			return intitule;
		}
		public void setIntitule(String intitule) {
			this.intitule = intitule;
		}
		public Enseignant getResponsable() {
			return responsable;
		}
		public void setResponsable(Enseignant responsable) {
			this.responsable = responsable;
		}
                  public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
                 public static Departement addDept(String intitule, Enseignant... chef){
        Departement departement = new Departement();
        departement.setIntitule(intitule);
        departement.setId(DB.getDeptId());
        if (chef.length > 0){
            departement.setResponsable(chef[0]);
        }
        DB.departements.add(departement);

        return  departement;
    }

    public static Departement updateDept(int id , String intitule, Enseignant... chef){
        for (Departement departement : DB.departements) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
                if (chef.length > 0){
                    departement.setResponsable(chef[0]);
                }
                return departement;
            }
        }

        return  new Departement();
    }
    public static ArrayList<Departement>  deleteDeptById(int id){
        DB.departements.remove(getDeptById(id));
        return DB.departements ;
    }

    public static Departement getDeptById(int id){
        for (Departement departement : DB.departements) {
            if (departement.getId() == id) return  departement;
        }
        return  new Departement();
    }

	}
