class CinemaBookingReceipt {
    private final String bookingId; private final String[] seatNumbers;
    public CinemaBookingReceipt(String bookingId, String[] seatNumbers) { this.bookingId = bookingId; if (seatNumbers == null) this.seatNumbers = new String[0]; else this.seatNumbers = seatNumbers.clone(); }
    public String getBookingId() { return bookingId; }
    public String[] getSeatNumbers() { return seatNumbers.clone(); }
    public CinemaBookingReceipt withUpdatedSeat(int index, String newSeat) { String[] updatedSeats = seatNumbers.clone(); if (index >= 0 && index < updatedSeats.length) updatedSeats[index] = newSeat; return new CinemaBookingReceipt(bookingId, updatedSeats); }
}
class CinemaGroupBookingReceipt extends CinemaBookingReceipt { private final int groupSize; public CinemaGroupBookingReceipt(String bookingId, String[] seatNumbers, int groupSize) { super(bookingId, seatNumbers); this.groupSize = groupSize; } public int getGroupSize() { return groupSize; } }
public class NightlyBookingSettlement {
    static String processNightlySettlement(CinemaBookingReceipt[] receipts) { int processed = 0, skipped = 0, group = 0, individual = 0; if (receipts == null) return "0 processed | 0 null skipped | 0 group | 0 individual"; for (CinemaBookingReceipt receipt : receipts) { if (receipt == null) { skipped++; continue; } processed++; if (receipt instanceof CinemaGroupBookingReceipt) group++; else individual++; } return processed + " processed | " + skipped + " null skipped | " + group + " group | " + individual + " individual"; }
    public static void main(String[] args) { CinemaBookingReceipt[] receipts = {new CinemaGroupBookingReceipt("CH-2002", new String[]{"B1", "B2"}, 2), null, new CinemaBookingReceipt("CH-3003", new String[]{"C1"})}; System.out.println(processNightlySettlement(receipts)); }
}