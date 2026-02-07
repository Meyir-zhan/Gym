import database.PersonDAO;
import model.Member;
import model.Trainer;

public class TestInsert {
    public static void main(String[] args) {

        PersonDAO dao = new PersonDAO();


        System.out.println("Attempting to insert a Member...");
        Member newMember = new Member(0, "Ali", 25, "VIP", true);
        dao.addPerson(newMember);


        System.out.println("Attempting to insert a Trainer...");
        Trainer newTrainer = new Trainer(0, "Valeriya", "Yoga", 5, true);
        dao.addPerson(newTrainer);

        System.out.println("Check pgAdmin to see if they appear!");
    }
}