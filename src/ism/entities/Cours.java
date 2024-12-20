package ism.entities;

public class Cours {
    private String nom;
    private String professeur;
    private String niveau;
    private String module;

    // Constructeur
    public Cours(String nom, String professeur, String niveau, String module) {
        this.nom = nom;
        this.professeur = professeur;
        this.niveau = niveau;
        this.module = module;
    }
    // Constructeur avec nom et niveau
    public Cours(String nom, String niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProfesseur() {
        return professeur;
    }

    public void setProfesseur(String professeur) {
        this.professeur = professeur;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Cours{" +
                "nom='" + nom + '\'' +
                ", professeur='" + professeur + '\'' +
                ", niveau='" + niveau + '\'' +
                ", module='" + module + '\'' +
                '}';
    }
}
