package database;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {


    public void addPerson(Person person) {
        String sql = "INSERT INTO person (name, age, type, membership_type, specialization, experience_years, active) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, person.getName());

            if (person instanceof Member) {
                Member m = (Member) person;
                stmt.setInt(2, m.getAge());
                stmt.setString(3, "MEMBER");
                stmt.setString(4, m.getMembershipType());
                stmt.setObject(5, null);
                stmt.setInt(6, 0);
            } else if (person instanceof Trainer) {
                Trainer t = (Trainer) person;
                stmt.setObject(2, null);
                stmt.setString(3, "TRAINER");
                stmt.setObject(4, null);
                stmt.setString(5, t.getSpecialization());
                stmt.setInt(6, t.getExperienceYears());
            }
            stmt.setBoolean(7, true);

            stmt.executeUpdate();
            System.out.println("Saved to database successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        String sql = "SELECT * FROM person ORDER BY id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                people.add(extractPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }


    public Person getPersonById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return extractPerson(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void updatePerson(int id, String newName) {
        String sql = "UPDATE person SET name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Person updated successfully!");
            else System.out.println("ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deletePerson(int id) {
        String sql = "DELETE FROM person WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) System.out.println("Deleted successfully!");
            else System.out.println("ID not found.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Person> searchByName(String nameQuery) {
        List<Person> results = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE name ILIKE ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + nameQuery + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(extractPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    public List<Person> searchByMinExperience(int minYears) {
        List<Person> results = new ArrayList<>();
        String sql = "SELECT * FROM person WHERE type = 'TRAINER' AND experience_years >= ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, minYears);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(extractPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    public List<Person> searchByAgeRange(int minAge, int maxAge) {
        List<Person> results = new ArrayList<>();

        String sql = "SELECT * FROM person WHERE type = 'MEMBER' AND age BETWEEN ? AND ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, minAge);
            stmt.setInt(2, maxAge);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(extractPerson(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }


    private Person extractPerson(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String type = rs.getString("type");
        boolean active = rs.getBoolean("active");

        if ("MEMBER".equalsIgnoreCase(type)) {
            return new Member(id, name, rs.getInt("age"), rs.getString("membership_type"), active);
        } else {
            return new Trainer(id, name, rs.getString("specialization"), rs.getInt("experience_years"), active);
        }
    }
}