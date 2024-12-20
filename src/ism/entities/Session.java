package ism.entities;

public class Session {
    private String date;
    private String heureDebut;
    private String heureFin;
    private String salle;
    private Cours cours;  // Ajout de l'attribut Cours

    // Constructeur avec 4 paramètres (dateSession, heureDebut, heureFin, salle)
    public Session(String date, String heureDebut, String heureFin, String salle) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salle = salle;
        this.cours = cours;  // Initialisation de l'attribut Cours
    }

    // Getters et setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
    // Getter pour l'attribut Cours
    public Cours getCours() {
        return cours;
    }

    @Override
    public String toString() {
        return "Session{" +
                "date='" + date + '\'' +
                ", heureDebut='" + heureDebut + '\'' +
                ", heureFin='" + heureFin + '\'' +
                ", salle='" + salle + '\'' +
                '}';
    }
}
