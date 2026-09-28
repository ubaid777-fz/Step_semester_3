import java.time.LocalDate;
import java.util.ArrayList;

abstract class Room {
    String roomNumber;
    Room(String roomNumber) { this.roomNumber = roomNumber; }
    abstract double calculatePrice(long days);
}

class StandardRoom extends Room {
    StandardRoom(String roomNumber) { super(roomNumber); }
    double calculatePrice(long days) { return days * 100; }
}

class DeluxeRoom extends Room {
    DeluxeRoom(String roomNumber) { super(roomNumber); }
    double calculatePrice(long days) { return days * 150; }
}

class Suite extends Room {
    Suite(String roomNumber) { super(roomNumber); }
    double calculatePrice(long days) { return days * 250; }
}

class Customer {
    String name;
    Customer(String name) { this.name = name; }
}

class Reservation {
    Customer customer;
    Room room;
    LocalDate startDate;
    LocalDate endDate;
    boolean cancelled = false;

    Reservation(Customer customer, Room room,
                LocalDate startDate, LocalDate endDate) {
        this.customer = customer;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    double getPrice() {
        long days = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        return room.calculatePrice(days);
    }

    void cancel() {
        if (!cancelled) {
            cancelled = true;
            System.out.println(
                    "Reservation for " + customer.name + ", "
                    + room.getClass().getSimpleName() + " " + room.roomNumber
                    + " (" + startDate + "-" + endDate
                    + ") cancelled successfully."
            );
        }
    }
}

class Hotel {
    ArrayList<Reservation> reservations = new ArrayList<>();

    boolean isAvailable(Room room, LocalDate start, LocalDate end) {
        for (Reservation r : reservations) {
            if (r.room.roomNumber.equals(room.roomNumber) && !r.cancelled) {
                boolean overlap = start.isBefore(r.endDate)
                        && end.isAfter(r.startDate);
                if (overlap) return false;
            }
        }
        return true;
    }

    Reservation book(Customer customer, Room room,
                      LocalDate start, LocalDate end) {
        if (!isAvailable(room, start, end)) {
            System.out.println(
                    room.getClass().getSimpleName() + " " + room.roomNumber
                    + " is not available from " + start + " to " + end + "."
            );
            return null;
        }

        Reservation reservation =
                new Reservation(customer, room, start, end);
        reservations.add(reservation);

        System.out.println(
                "Reservation confirmed for " + customer.name + ", "
                + room.getClass().getSimpleName() + " " + room.roomNumber
                + " (" + start + "-" + end + ")."
        );

        System.out.println("Price: $" + reservation.getPrice());
        return reservation;
    }
}

public class HotelBookingDemo {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        Customer customerA = new Customer("Customer A");
        Customer customerB = new Customer("Customer B");
        Customer customerC = new Customer("Customer C");

        Room standard = new StandardRoom("101");
        Room deluxe = new DeluxeRoom("201");

        LocalDate jan1 = LocalDate.of(2026, 1, 1);
        LocalDate jan5 = LocalDate.of(2026, 1, 5);
        LocalDate jan3 = LocalDate.of(2026, 1, 3);
        LocalDate jan7 = LocalDate.of(2026, 1, 7);

        System.out.println(
                "Standard Room 101 is available from "
                + jan1 + " to " + jan5 + "."
        );

        Reservation r1 = hotel.book(
                customerA, standard, jan1, jan5
        );

        hotel.book(customerB, standard, jan3, jan7);

        r1.cancel();

        hotel.book(
                customerC, deluxe,
                LocalDate.of(2026, 2, 10),
                LocalDate.of(2026, 2, 12)
        );
    }
}