package ism.services.impl;

import ism.entities.Etudiant;
import ism.services.EtudiantService;

import java.util.ArrayList;
import java.util.List;

public class EtudiantServiceImpl implements EtudiantService {
    private List<Etudiant> etudiantList = new ArrayList<>();

    @Override
    public void inscrireEtudiant(Etudiant etudiant) {
        etudiantList.add(etudiant);
        System.out.println("Étudiant inscrit : " + etudiant);
    }

    @Override
    public void afficherEtudiants() {
        if (etudiantList.isEmpty()) {
            System.out.println("Aucun étudiant inscrit.");
        } else {
            for (Etudiant etudiant : etudiantList) {
                System.out.println(etudiant);
            }
        }
    }

    @Override
    public void reinscrireEtudiant(Etudiant etudiant) {
        // Mettre à jour les informations d'inscription de l'étudiant
        etudiant.setClasse(etudiant.getClasse());  // La classe peut être modifiée ici si nécessaire
        etudiant.setNiveau(etudiant.getNiveau());  // Le niveau peut aussi être ajusté
        System.out.println("Étudiant réinscrit : " + etudiant);
    }

    @Override
    public Etudiant getEtudiantParNom(String nom, String prenom) {
        return etudiantList.stream()
                            .filter(e -> e.getNom().equals(nom) && e.getPrenom().equals(prenom))
                            .findFirst()
                            .orElse(null); // Si l'étudiant n'est pas trouvé, retourne null
    }
}

