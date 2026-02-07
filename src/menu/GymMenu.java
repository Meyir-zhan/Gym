package menu;

import database.PersonDAO;
import model.*;
import java.util.List;
import java.util.Scanner;

public class GymMenu implements Menu {

    private PersonDAO personDAO = new PersonDAO();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\nGYM MANAGEMENT SYSTEM");
        System.out.println("1. Add Member");
        System.out.println("2. Add Trainer");
        System.out.println("3. Show All");
        System.out.println("4. Update Person");
        System.out.println("5. Delete Person");
        System.out.println("6. Search by Name");
        System.out.println("7. Find by ID");
        System.out.println("8. Search Experienced Trainers");
        System.out.println("9. Search Members by Age Range");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addMember();
                case "2" -> addTrainer();
                case "3" -> showAll();
                case "4" -> updatePerson();
                case "5" -> deletePerson();
                case "6" -> searchPerson();
                case "7" -> findById();
                case "8" -> searchByExperience();
                case "9" -> searchByAgeRange();
                case "0" -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addMember() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            personDAO.addPerson(new Member(0, name, age, "Basic", true));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid number for age.");
        }
    }

    private void addTrainer() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Experience Years: ");
            int exp = Integer.parseInt(scanner.nextLine());
            personDAO.addPerson(new Trainer(0, name, "General", exp, true));
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a number for experience.");
        }
    }

    private void showAll() {
        List<Person> list = personDAO.getAllPeople();
        System.out.println("\nDatabase Results");
        for (Person p : list) {
            System.out.println("ID: " + p.getId() + " | Name: " + p.getName() + " | Type: " + p.getClass().getSimpleName());
            p.work();
        }
    }

    private void updatePerson() {
        try {
            System.out.print("Enter ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            personDAO.updatePerson(id, name);
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private void deletePerson() {
        try {
            System.out.print("Enter ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Are you sure? (yes/no): ");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                personDAO.deletePerson(id);
            } else {
                System.out.println("Deletion cancelled.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }

    private void searchPerson() {
        System.out.print("Enter name to search: ");
        String query = scanner.nextLine();
        List<Person> results = personDAO.searchByName(query);

        System.out.println("--- Search Results ---");
        for (Person p : results) {
            System.out.println("Found: " + p.getName() + " (ID: " + p.getId() + ")");
        }
    }


    private void findById() {
        System.out.print("Enter ID to find: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Person p = personDAO.getPersonById(id);
            if (p != null) {
                System.out.println("Found: " + p.getName() + " (" + p.getClass().getSimpleName() + ")");
            } else {
                System.out.println("No person found with ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid ID.");
        }
    }


    private void searchByExperience() {
        System.out.print("Enter minimum years of experience: ");
        try {
            int years = Integer.parseInt(scanner.nextLine());
            List<Person> list = personDAO.searchByMinExperience(years);
            System.out.println("Experienced Trainer");
            for (Person p : list) {
                if (p instanceof Trainer) {
                    Trainer t = (Trainer) p;
                    System.out.println(t.getName() + ": " + t.getExperienceYears() + " years");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }
    private void searchByAgeRange() {
        System.out.print("Enter minimum age: ");
        try {
            int min = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter maximum age: ");
            int max = Integer.parseInt(scanner.nextLine());

            List<Person> list = personDAO.searchByAgeRange(min, max);
            System.out.println("--- Members in Age Range (" + min + "-" + max + ") ---");

            if (list.isEmpty()) {
                System.out.println("No members found in this range.");
            } else {
                for (Person p : list) {
                    Member m = (Member) p;
                    System.out.println(m.getName() + ": " + m.getAge() + " years old");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

}