package ism.services;

import ism.entities.Etudiant;

public interface EtudiantService {
    void inscrireEtudiant(Etudiant etudiant);
    void reinscrireEtudiant(Etudiant etudiant);
    void afficherEtudiants();
    Etudiant getEtudiantParNom(String nom, String prenom);
}
