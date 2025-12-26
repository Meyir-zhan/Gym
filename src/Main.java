public class Main {

    public static void main(String[] args) {

        // 1. Welcome message
        System.out.println("=== Gym Management System ===\n");

        // 2. Create objects
        Member member1 = new Member(101, "Alice Brown", 25, "Premium", true);
        Member member2 = new Member();
        Trainer trainer1 = new Trainer(201, "John Smith", "Strength", 7, true);
        Trainer trainer2 = new Trainer();
        WorkoutSession session1 = new WorkoutSession(301, "Alice Brown", "John Smith", 60, false);

        // 3. Display initial state
        System.out.println("--- MEMBERS ---");
        System.out.println(member1);
        System.out.println(member2);

        System.out.println("\n--- TRAINERS ---");
        System.out.println(trainer1);
        System.out.println(trainer2);

        System.out.println("\n--- WORKOUT SESSIONS ---");
        System.out.println(session1);

        // 4. Test getters
        System.out.println("\n--- TESTING GETTERS ---");
        System.out.println("Member1 name: " + member1.getName());
        System.out.println("Trainer1 experience: " + trainer1.getExperienceYears());
        System.out.println("Session duration: " + session1.getDurationMinutes() + " minutes");

        // 5. Test setters
        System.out.println("\n--- TESTING SETTERS ---");
        member2.setName("Bob White");
        member2.setAge(17);
        member2.setActive(true);
        System.out.println("Updated member2: " + member2);

        // 6. Test additional methods
        System.out.println("\n--- TESTING METHODS ---");
        System.out.println("Is member1 adult? " + member1.isAdult());
        member1.upgradeMembership("VIP");
        System.out.println("Upgraded member1: " + member1);

        System.out.println("Is trainer1 experienced? " + trainer1.isExperienced());
        trainer1.assignSession();
        System.out.println("Trainer after assignment: " + trainer1);

        session1.extendSession(30);
        session1.completeSession();
        System.out.println("Updated session: " + session1);

        // 7. Completion message
        System.out.println("\n=== Program Complete ===");
    }
}
