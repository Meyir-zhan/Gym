import database.PersonDAO;
import model.Member;
import model.Trainer;

public class TestInsert {
    public static void main(String[] args) {
        // 1. Create the DAO (The tool that talks to the DB)
        PersonDAO dao = new PersonDAO();

        // 2. Create a specific Member object (ID is 0 because DB auto-generates it)
        System.out.println("Attempting to insert a Member...");
        Member newMember = new Member(0, "Ali", 25, "VIP", true);
        dao.addPerson(newMember); // This calls the INSERT SQL code

        // 3. Create a specific Trainer object
        System.out.println("Attempting to insert a Trainer...");
        Trainer newTrainer = new Trainer(0, "Valeriya", "Yoga", 5, true);
        dao.addPerson(newTrainer);

        System.out.println("Check pgAdmin to see if they appear!");
    }
}