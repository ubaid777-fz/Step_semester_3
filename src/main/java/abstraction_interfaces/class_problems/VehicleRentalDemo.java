abstract class Vehicle {
    String name;
    boolean available = true;
    Vehicle(String name) { this.name = name; }
    abstract double calculateCharge(int days);
}
class Sedan extends Vehicle {
    Sedan(String name) { super(name); }
    double calculateCharge(int days) { return days * 50; }
}
class SUV extends Vehicle {
    SUV(String name) { super(name); }
    double calculateCharge(int days) { return days * 80; }
}
class Truck extends Vehicle {
    Truck(String name) { super(name); }
    double calculateCharge(int days) { return days * 100; }
}
class Customer {
    String name;
    Customer(String name) { this.name = name; }
}
class Rental {
    Customer customer; Vehicle vehicle; int days;
    Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer=customer; this.vehicle=vehicle; this.days=days;
    }
    void startRental() {
        if (!vehicle.available) {
            System.out.println(vehicle.name + " is currently unavailable.");
            return;
        }
        vehicle.available=false;
        System.out.println(vehicle.name+" rented successfully by "+customer.name+".");
        System.out.println("Rental charge: $"+vehicle.calculateCharge(days));
    }
    void returnVehicle() {
        vehicle.available=true;
        System.out.println(vehicle.name+" returned by "+customer.name+".");
    }
}
public class VehicleRentalDemo {
    public static void main(String[] args) {
        Customer customer1=new Customer("Customer 1");
        Customer customer2=new Customer("Customer 2");
        Customer customer3=new Customer("Customer 3");
        Vehicle sedanA=new Sedan("Sedan A");
        Vehicle suvB=new SUV("SUV B");
        Rental rental1=new Rental(customer1,sedanA,3);
        rental1.startRental();
        Rental rental2=new Rental(customer2,sedanA,2);
        rental2.startRental();
        rental1.returnVehicle();
        Rental rental3=new Rental(customer3,suvB,5);
        rental3.startRental();
    }
}