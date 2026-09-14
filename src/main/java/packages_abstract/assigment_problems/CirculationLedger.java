class LoanReceipt {
    private final String memberId; private final String[] bookIds;
    public LoanReceipt(String memberId, String[] bookIds) { this.memberId = memberId; if (bookIds == null) this.bookIds = new String[0]; else this.bookIds = bookIds.clone(); }
    public String getMemberId() { return memberId; }
    public String[] getBookIds() { return bookIds.clone(); }
    public LoanReceipt withCorrectedBookId(int index, String newId) { String[] correctedBooks = bookIds.clone(); if (index >= 0 && index < correctedBooks.length) correctedBooks[index] = newId; return new LoanReceipt(memberId, correctedBooks); }
}
class ReferenceOnlyLoanReceipt extends LoanReceipt { private final String roomNumber; public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) { super(memberId, bookIds); this.roomNumber = roomNumber; } public String getRoomNumber() { return roomNumber; } }
public class CirculationLedger {
    static { System.out.println("Circulation Ledger initialized"); }
    public static String processNightlyCirculation(LoanReceipt[] receipts) { int processed = 0, nullSkipped = 0, referenceOnly = 0, regular = 0; if (receipts == null) return "0 processed | 0 null skipped | 0 reference-only | 0 regular"; for (LoanReceipt receipt : receipts) { if (receipt == null) { nullSkipped++; continue; } processed++; if (receipt instanceof ReferenceOnlyLoanReceipt) referenceOnly++; else regular++; } return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular"; }
    public static void main(String[] args) { String[] books1 = {"B101", "B102"}; String[] books2 = {"B201"}; LoanReceipt receipt1 = new LoanReceipt("M001", books1); ReferenceOnlyLoanReceipt receipt2 = new ReferenceOnlyLoanReceipt("M002", books2, "R-101"); LoanReceipt[] receipts = {receipt1, null, receipt2}; System.out.println(processNightlyCirculation(receipts)); }
}