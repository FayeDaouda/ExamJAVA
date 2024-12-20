package ism.services.impl;

import ism.entities.Cours;
import ism.entities.Session;
import ism.services.SessionService;

import java.util.List;  // Importation de List
import java.util.stream.Collectors;
import java.util.ArrayList;

public class SessionServiceImpl implements SessionService {
    private List<Session> sessionList = new ArrayList<>();

    @Override
    public List<Session> getSessionsParCours(Cours cours) {
        return sessionList.stream()  // Remplacer sessionsList par sessionList
                           .filter(s -> s.getCours().equals(cours))
                           .collect(Collectors.toList());
    }

    @Override
    public void planifierSession(Session session) {
        sessionList.add(session);
        System.out.println("Session planifiée : " + session);
    }

    @Override
    public void afficherSessions() {
        if (sessionList.isEmpty()) {
            System.out.println("Aucune session disponible.");
        } else {
            for (Session session : sessionList) {
                System.out.println(session);
            }
        }
    }

    @Override
    public void planifierSessionsForCourse(Cours cours, List<Session> sessions) {
        // Planifier toutes les sessions pour un cours
        System.out.println("Sessions planifiées pour le cours : " + cours.getNom());
        for (Session session : sessions) {
            System.out.println(session);
        }
    }
}
