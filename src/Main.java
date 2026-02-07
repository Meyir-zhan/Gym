import menu.GymMenu;
import menu.Menu;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Menu menu = new GymMenu();
        menu.run();
    }
}