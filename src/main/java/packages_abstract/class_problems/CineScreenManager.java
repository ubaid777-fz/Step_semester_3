public class CineScreenManager {
    private int seatsTotal; private int seatsAvailable;
    public CineScreenManager(int seatsTotal) { if (seatsTotal <= 0) throw new IllegalArgumentException("seatsTotal must be positive"); this.seatsTotal = seatsTotal; this.seatsAvailable = seatsTotal; }
    public void bookSeat() { if (seatsAvailable > 0) seatsAvailable--; }
    public void cancelBooking() { if (seatsAvailable < seatsTotal) seatsAvailable++; }
    public int getSeatsAvailable() { return seatsAvailable; }
    public static void main(String[] args) { CineScreenManager screen = new CineScreenManager(2); screen.bookSeat(); screen.bookSeat(); screen.bookSeat(); System.out.println(screen.getSeatsAvailable()); screen.cancelBooking(); screen.cancelBooking(); screen.cancelBooking(); System.out.println(screen.getSeatsAvailable()); }
}