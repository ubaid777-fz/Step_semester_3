abstract class Seat {
    String seatNumber;

    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    abstract double getPrice();
}

class RegularSeat extends Seat {
    RegularSeat(String seatNumber) { super(seatNumber); }
    double getPrice() { return 150; }
}

class PremiumSeat extends Seat {
    PremiumSeat(String seatNumber) { super(seatNumber); }
    double getPrice() { return 250; }
}

class ReclinerSeat extends Seat {
    ReclinerSeat(String seatNumber) { super(seatNumber); }
    double getPrice() { return 400; }
}

class Customer {
    String name;
    Customer(String name) { this.name = name; }
}

class Show {
    private java.util.ArrayList<String> bookedSeats =
            new java.util.ArrayList<>();

    boolean isAvailable(String seatNumber) {
        return !bookedSeats.contains(seatNumber);
    }

    boolean bookSeat(String seatNumber) {
        if (!isAvailable(seatNumber)) return false;
        bookedSeats.add(seatNumber);
        return true;
    }

    void releaseSeat(String seatNumber) {
        bookedSeats.remove(seatNumber);
    }
}

class Booking {
    Customer customer;
    Show show;
    java.util.ArrayList<Seat> seats;
    boolean cancelled;

    Booking(Customer customer, Show show) {
        this.customer = customer;
        this.show = show;
        seats = new java.util.ArrayList<>();
        cancelled = false;
    }

    boolean addSeat(Seat seat) {
        if (seats.size() >= 6) {
            System.out.println("Maximum 6 seats allowed.");
            return false;
        }

        if (!show.bookSeat(seat.seatNumber)) {
            System.out.println("Seat " + seat.seatNumber +
                    " is already booked for this show.");
            return false;
        }

        seats.add(seat);
        return true;
    }

    double getTotal() {
        double total = 0;
        for (Seat seat : seats) total += seat.getPrice();
        return total;
    }

    void cancel(boolean showStarted) {
        if (showStarted) {
            System.out.println("Cannot cancel after the show has started.");
            return;
        }

        if (cancelled) return;

        for (Seat seat : seats) show.releaseSeat(seat.seatNumber);
        cancelled = true;
        System.out.println(customer.name + "'s booking cancelled.");
    }
}

public class TicketDemo {
    public static void main(String[] args) {
        Customer asha = new Customer("Asha");
        Customer ravi = new Customer("Ravi");
        Customer neha = new Customer("Neha");

        Show show = new Show();

        Booking b1 = new Booking(asha, show);
        b1.addSeat(new RegularSeat("A1"));
        b1.addSeat(new RegularSeat("A2"));
        b1.addSeat(new PremiumSeat("F5"));

        System.out.println("Booking confirmed for Asha: A1, A2, F5.");
        System.out.printf("Total: ₹%.2f%n", b1.getTotal());

        Booking b2 = new Booking(ravi, show);
        b2.addSeat(new RegularSeat("A2"));
        b2.addSeat(new ReclinerSeat("R1"));

        System.out.println("Booking confirmed for Ravi: R1.");
        System.out.printf("Total: ₹%.2f%n", b2.getTotal());

        b1.cancel(false);

        Booking b3 = new Booking(neha, show);
        b3.addSeat(new RegularSeat("A2"));

        System.out.println("Booking confirmed for Neha: A2.");
        System.out.printf("Total: ₹%.2f%n", b3.getTotal());
    }
}