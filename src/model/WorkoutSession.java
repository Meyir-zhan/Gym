package model;

public class WorkoutSession {

    private int sessionId;
    private String memberName;
    private String trainerName;
    private int durationMinutes;
    private boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName,int durationMinutes, boolean completed) {
        setSessionId(sessionId);
        setMemberName(memberName);
        setTrainerName(trainerName);
        setDurationMinutes(durationMinutes);
        this.completed = completed;
    }

    public void setSessionId(int sessionId) {
        if (sessionId <= 0) {
            throw new IllegalArgumentException("Session ID must be positive");
        }
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        if (memberName == null || memberName.isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be empty");
        }
        this.memberName = memberName;
    }

    public void setTrainerName(String trainerName) {
        if (trainerName == null || trainerName.isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be empty");
        }
        this.trainerName = trainerName;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration must be greater than 0");
        }
        this.durationMinutes = durationMinutes;
    }

    public void completeSession() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "WorkoutSession{" +
                "sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", completed=" + completed +
                '}';
    }
}