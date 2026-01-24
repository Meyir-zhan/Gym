package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GymMenu implements Menu {

    private ArrayList<Person> people = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void displayMenu() {
        System.out.println("\nGYM MANAGEMENT SYSTEM");
        System.out.println("1. Add Member");
        System.out.println("2. Add Trainer");
        System.out.println("3. Show All");
        System.out.println("4. Polymorphism Demo");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> addMember();
                    case 2 -> addTrainer();
                    case 3 -> showAll();
                    case 4 -> demoWork();
                    case 0 -> running = false;
                    default -> System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a number!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addMember() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());

        people.add(new Member(id, name, age, "Basic", true));
        System.out.println("Member added!");
    }

    private void addTrainer() {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Name: ");
        String name = scanner.nextLine();

        people.add(new Trainer(id, name, "General", 5, true));
        System.out.println("Trainer added!");
    }

    private void showAll() {
        for (Person p : people) {
            p.work();
        }
    }

    private void demoWork() {
        for (Person p : people) {
            p.work();
        }
    }
}