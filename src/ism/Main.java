package ism;

import ism.entities.Cours;
import ism.entities.Etudiant;
import ism.entities.Session;
import ism.services.CoursService;
import ism.services.EtudiantService;
import ism.services.SessionService;
import ism.services.impl.CoursServiceImpl;
import ism.services.impl.EtudiantServiceImpl;
import ism.services.impl.SessionServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final CoursService coursService = new CoursServiceImpl();
    private static final SessionService sessionService = new SessionServiceImpl();
    private static final EtudiantService etudiantService = new EtudiantServiceImpl();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            afficherMenuPrincipal();
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne laissée par nextInt()

            switch (choix) {
                case 1:
                    creerCours();
                    break;
                case 2:
                    planifierSession();
                    break;
                case 3:
                    inscrireEtudiant();
                    break;
                case 4:
                    afficherCoursClasse();
                    break;
                case 5:
                    afficherSessionsCours();
                    break;
                case 6:
                    afficherClasseEtudiant();
                    break;
                case 0:
                    System.out.println("Au revoir!");
                    return;  // Quitter l'application
                default:
                    System.out.println("Choix invalide. Essayez de nouveau.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\n===== Menu Principal =====");
        System.out.println("1. Créer un cours");
        System.out.println("2. Planifier une session de cours");
        System.out.println("3. Inscrire un étudiant");
        System.out.println("4. Afficher les cours d'une classe");
        System.out.println("5. Afficher les sessions d'un cours");
        System.out.println("6. Afficher la classe d'un étudiant");
        System.out.println("0. Quitter");
        System.out.print("Veuillez choisir une option: ");
    }

    private static void creerCours() {
        System.out.println("\nCréation d'un nouveau cours");

        System.out.print("Nom du cours: ");
        String nomCours = scanner.nextLine();

        System.out.print("Nom du professeur: ");
        String professeur = scanner.nextLine();

        System.out.print("Niveau du cours: ");
        String niveau = scanner.nextLine();

        System.out.print("Module du cours: ");
        String module = scanner.nextLine();

        Cours cours = new Cours(nomCours, professeur, niveau, module);
        coursService.creerCours(cours);
        
    }

    private static void planifierSession() {
        System.out.println("\nPlanification d'une session de cours");

        System.out.print("Nom du cours: ");
        String nomCours = scanner.nextLine();
        Cours cours = coursService.getCoursParNom(nomCours);

        if (cours != null) {
            System.out.print("Date de la session (format: yyyy-mm-dd): ");
            String dateSession = scanner.nextLine();

            System.out.print("Heure de début (format: hh:mm): ");
            String heureDebut = scanner.nextLine();

            System.out.print("Heure de fin (format: hh:mm): ");
            String heureFin = scanner.nextLine();

            System.out.print("Salle (laisser vide si en ligne): ");
            String salle = scanner.nextLine();

            Session session = new Session(dateSession, heureDebut, heureFin, salle);
            sessionService.planifierSession(session);
            sessionService.planifierSessionsForCourse(cours, List.of(session));
            
        } else {
            System.out.println("Cours introuvable.");
        }
    }

    private static void inscrireEtudiant() {
        System.out.println("\nInscription d'un étudiant");

        System.out.print("Nom de l'étudiant: ");
        String nom = scanner.nextLine();

        System.out.print("Prénom de l'étudiant: ");
        String prenom = scanner.nextLine();

        System.out.print("Niveau de l'étudiant: ");
        String niveau = scanner.nextLine();

        System.out.print("Classe de l'étudiant: ");
        String classe = scanner.nextLine();

        Etudiant etudiant = new Etudiant(nom, prenom, niveau, classe);
        etudiantService.inscrireEtudiant(etudiant);
        
    }

    private static void afficherCoursClasse() {
        System.out.println("\nAfficher les cours d'une classe");

        System.out.print("Nom de la classe: ");
        String classe = scanner.nextLine();

        List<Cours> coursClasse = coursService.getCoursParClasse(classe);
        if (coursClasse.isEmpty()) {
            System.out.println("Aucun cours trouvé pour la classe " + classe);
        } else {
            coursClasse.forEach(System.out::println);
        }
    }

    private static void afficherSessionsCours() {
        System.out.println("\nAfficher les sessions d'un cours");

        System.out.print("Nom du cours: ");
        String nomCours = scanner.nextLine();

        Cours cours = coursService.getCoursParNom(nomCours);
        if (cours != null) {
            List<Session> sessions = sessionService.getSessionsParCours(cours);
            if (sessions.isEmpty()) {
                System.out.println("Aucune session planifiée pour ce cours.");
            } else {
                sessions.forEach(System.out::println);
            }
        } else {
            System.out.println("Cours introuvable.");
        }
    }

    private static void afficherClasseEtudiant() {
        System.out.println("\nAfficher la classe d'un étudiant");

        System.out.print("Nom de l'étudiant: ");
        String nom = scanner.nextLine();

        System.out.print("Prénom de l'étudiant: ");
        String prenom = scanner.nextLine();

        Etudiant etudiant = etudiantService.getEtudiantParNom(nom, prenom);
        if (etudiant != null) {
            System.out.println("L'étudiant " + nom + " " + prenom + " est inscrit dans la classe: " + etudiant.getClasse());
        } else {
            System.out.println("Étudiant non trouvé.");
        }
    }
}
