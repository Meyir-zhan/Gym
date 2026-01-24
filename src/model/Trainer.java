package model;

public class Trainer extends Person implements Trainable {

    private String specialization;
    private int experienceYears;

    public Trainer(int id, String name, String specialization, int experienceYears, boolean active) {
        super(id, name, active);
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }

    @Override
    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    @Override
    public void work() {
        System.out.println(name + " is training members.");
    }
}