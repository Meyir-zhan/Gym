public class Member {

    private int memberId;
    private String name;
    private int age;
    private String membershipType;
    private boolean active;

    public Member(int memberId, String name, int age, String membershipType, boolean active) {
        this.memberId = memberId;
        this.name = name;
        this.age = age;
        this.membershipType = membershipType;
        this.active = active;
    }

    public Member() {
        this.memberId = 0;
        this.name = "Unknown Member";
        this.age = 0;
        this.membershipType = "Basic";
        this.active = false;
    }


    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean isActive() {
        return active;
    }


    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void upgradeMembership(String newType) {
        this.membershipType = newType;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Member{memberId=" + memberId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", membershipType='" + membershipType + '\'' +
                ", active=" + active + '}';
    }
}
