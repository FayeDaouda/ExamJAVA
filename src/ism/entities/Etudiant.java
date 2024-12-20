package ism.entities;

public class Etudiant {
    private String nom;
    private String prenom;
    private String niveau;
    private String classe;

    // Constructeur
    public Etudiant(String nom, String prenom, String niveau, String classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.classe = classe;
    }

    // Getters et Setters
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

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", niveau='" + niveau + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }
}
