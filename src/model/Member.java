package model;

public class Member extends Person {

    private int age;
    private String membershipType;

    public Member(int id, String name, int age, String membershipType, boolean active) {
        super(id, name, active);
        setAge(age);
        this.membershipType = membershipType;
    }

    // --- GETTERS (Required for Database) ---
    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    // --- SETTERS ---
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public void work() {
        System.out.println(name + " is working out.");
    }
}