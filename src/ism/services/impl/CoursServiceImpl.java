package ism.services.impl;

import ism.entities.Cours;
import ism.services.CoursService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoursServiceImpl implements CoursService {
    private List<Cours> coursList = new ArrayList<>();

    public CoursServiceImpl() {
        // Initialisation de la liste de cours pour l'exemple
        coursList = new ArrayList<>();
        // Ajoutez des cours à la liste si nécessaire
    }

    

    @Override
    public List<Cours> getCoursParClasse(String classe) {
        return coursList.stream()
                        .filter(c -> c.getNiveau().equals(classe))
                        .collect(Collectors.toList());
    }

    @Override
    public void creerCours(Cours cours) {
        coursList.add(cours);
        System.out.println("Cours créé : " + cours);
    }

    @Override
    public void afficherCours() {
        if (coursList.isEmpty()) {
            System.out.println("Aucun cours disponible.");
        } else {
            for (Cours cours : coursList) {
                System.out.println(cours);
            }
        }
    }
    @Override
    public Cours getCoursParNom(String nom) {
        // Chercher un cours par son nom
        for (Cours cours : coursList) {
            if (cours.getNom().equalsIgnoreCase(nom)) {
                return cours;
            }
        }
        return null;  // Retourne null si aucun cours trouvé
    }
}

