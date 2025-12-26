public class WorkoutSession {

    // 1. PRIVATE FIELDS
    private int sessionId;
    private String memberName;
    private String trainerName;
    private int durationMinutes;
    private boolean completed;

    // 2. PARAMETERIZED CONSTRUCTOR
    public WorkoutSession(int sessionId, String memberName, String trainerName, int durationMinutes, boolean completed) {
        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.durationMinutes = durationMinutes;
        this.completed = completed;
    }

    // 3. DEFAULT CONSTRUCTOR
    public WorkoutSession() {
        this.sessionId = 0;
        this.memberName = "Unknown";
        this.trainerName = "Unknown";
        this.durationMinutes = 0;
        this.completed = false;
    }

    // 4. GETTERS
    public int getSessionId() {
        return sessionId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public boolean isCompleted() {
        return completed;
    }

    // 5. SETTERS
    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // 6. ADDITIONAL METHODS
    public void extendSession(int extraMinutes) {
        this.durationMinutes += extraMinutes;
    }

    public void completeSession() {
        this.completed = true;
    }

    // 7. toString()
    @Override
    public String toString() {
        return "WorkoutSession{sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", completed=" + completed + '}';
    }
}
