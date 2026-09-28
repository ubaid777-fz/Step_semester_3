interface MembershipPlan {
    double calculateFee();
    String getName();
}

class MonthlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000;
    }

    public String getName() {
        return "Monthly";
    }
}

class QuarterlyPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 3 * 0.90;
    }

    public String getName() {
        return "Quarterly";
    }
}

class AnnualPlan implements MembershipPlan {

    public double calculateFee() {
        return 1000 * 12 * 0.75;
    }

    public String getName() {
        return "Annual";
    }
}

class Member {
    String name;

    Member(String name) {
        this.name = name;
    }
}

class Membership {
    Member member;
    MembershipPlan plan;
    private String status;

    Membership(Member member, MembershipPlan plan) {
        this.member = member;
        this.plan = plan;
        status = "Active";
    }

    void checkIn() {
        if (status.equals("Active")) {
            System.out.println(member.name +
                    " checked in successfully.");
        } else {
            System.out.println("Check-in denied: " +
                    member.name + "'s membership is " + status + ".");
        }
    }

    void freeze() {
        if (status.equals("Active")) {
            status = "Frozen";
            System.out.println(member.name +
                    "'s membership frozen. Status: Frozen.");
        } else if (status.equals("Expired")) {
            System.out.println("Cannot freeze an Expired membership.");
        }
    }

    void unfreeze() {
        if (status.equals("Frozen")) {
            status = "Active";
            System.out.println(member.name +
                    "'s membership unfrozen. Status: Active.");
        } else if (status.equals("Expired")) {
            System.out.println("Cannot unfreeze an Expired membership.");
        }
    }

    void expire() {
        status = "Expired";
        System.out.println(member.name +
                "'s membership expired. Status: Expired.");
    }

    String getStatus() {
        return status;
    }
}

public class MembershipDemo {
    public static void main(String[] args) {
        Member asha = new Member("Asha");
        Member ravi = new Member("Ravi");

        MembershipPlan quarterly = new QuarterlyPlan();
        MembershipPlan monthly = new MonthlyPlan();

        Membership a = new Membership(asha, quarterly);
        Membership r = new Membership(ravi, monthly);

        System.out.printf(
                "Quarterly membership created for Asha. Fee: ₹%.2f. Status: Active.%n",
                quarterly.calculateFee()
        );

        System.out.printf(
                "Monthly membership created for Ravi. Fee: ₹%.2f. Status: Active.%n",
                monthly.calculateFee()
        );

        a.checkIn();
        a.freeze();
        a.checkIn();
        r.expire();
        r.freeze();
    }
}