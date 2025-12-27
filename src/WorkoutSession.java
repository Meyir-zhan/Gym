public class WorkoutSession {

    private int sessionId;
    private String memberName;
    private String trainerName;
    private int durationMinutes;
    private boolean completed;

    public WorkoutSession(int sessionId, String memberName, String trainerName, int durationMinutes, boolean completed) {
        this.sessionId = sessionId;
        this.memberName = memberName;
        this.trainerName = trainerName;
        this.durationMinutes = durationMinutes;
        this.completed = completed;
    }

    public WorkoutSession() {
        this.sessionId = 0;
        this.memberName = "Unknown";
        this.trainerName = "Unknown";
        this.durationMinutes = 0;
        this.completed = false;
    }

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

    public void extendSession(int extraMinutes) {
        this.durationMinutes += extraMinutes;
    }

    public void completeSession() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "WorkoutSession{sessionId=" + sessionId +
                ", memberName='" + memberName + '\'' +
                ", trainerName='" + trainerName + '\'' +
                ", durationMinutes=" + durationMinutes +
                ", completed=" + completed + '}';
    }
}
