package ism.services;

import java.util.List;

import ism.entities.Cours;

public interface CoursService {
    void creerCours(Cours cours);
    void afficherCours();
    Cours getCoursParNom(String nom);
    List<Cours> getCoursParClasse(String classe);
}
