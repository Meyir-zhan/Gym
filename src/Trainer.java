public class Trainer {

    private int trainerId;
    private String name;
    private String specialization;
    private int experienceYears;
    private boolean available;

    public Trainer(int trainerId, String name, String specialization, int experienceYears, boolean available) {
        this.trainerId = trainerId;
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
        this.available = available;
    }

    public Trainer() {
        this.trainerId = 0;
        this.name = "Unknown Trainer";
        this.specialization = "General";
        this.experienceYears = 0;
        this.available = true;
    }


    public int getTrainerId() {
        return trainerId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    public void assignSession() {
        this.available = false;
    }

    @Override
    public String toString() {
        return "Trainer{trainerId=" + trainerId +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", experienceYears=" + experienceYears +
                ", available=" + available + '}';
    }
}
