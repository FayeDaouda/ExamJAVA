package ism.services;

import ism.entities.Cours;  // Importation de la classe Cours
import ism.entities.Session;
import java.util.List;  // Importation de List

public interface SessionService {
    void planifierSession(Session session);
    void planifierSessionsForCourse(Cours cours, List<Session> sessions);  // Utilisation correcte de Cours et List
    void afficherSessions();
    List<Session> getSessionsParCours(Cours cours);
}
