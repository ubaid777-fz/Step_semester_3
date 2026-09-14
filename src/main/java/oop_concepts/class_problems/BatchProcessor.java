class FeeAccount { public void pay(double amount) { System.out.println("Paid in one go (day-scholar account)"); } }
class HostelFeeAccount extends FeeAccount { public void payHostel(double amount) { System.out.println("Paid in two installments (hostel account)"); } }
public class BatchProcessor {
    static int hostelCount = 0; static int dayScholarCount = 0;
    public static void processPayment(FeeAccount account, double amount) { if (account instanceof HostelFeeAccount) { ((HostelFeeAccount) account).payHostel(amount); hostelCount++; } else { account.pay(amount); dayScholarCount++; } }
    public static void main(String[] args) { FeeAccount[] accounts = {new HostelFeeAccount(), new HostelFeeAccount(), new FeeAccount(), new FeeAccount()}; for (FeeAccount acc : accounts) processPayment(acc, 60000); System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount); }
}