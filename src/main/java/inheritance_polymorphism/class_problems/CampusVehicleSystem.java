import java.util.*;

interface ChargingVehicle {
    void charge();
}

class CampusVehicle {
    String passNumber;
    String owner;

    CampusVehicle(String passNumber, String owner) {
        this.passNumber = passNumber;
        this.owner = owner;
    }

    int getFee() { return 0; }
    String getType() { return ""; }
    boolean canCharge() { return false; }
}

class CampusBike extends CampusVehicle {
    CampusBike(String passNumber, String owner) { super(passNumber, owner); }
    int getFee() { return 300; }
    String getType() { return "Bike"; }
}

class CampusCar extends CampusVehicle {
    CampusCar(String passNumber, String owner) { super(passNumber, owner); }
    int getFee() { return 1000; }
    String getType() { return "Car"; }
}

class CampusEBike extends CampusVehicle implements ChargingVehicle {
    CampusEBike(String passNumber, String owner) { super(passNumber, owner); }
    int getFee() { return 300; }
    String getType() { return "EBike"; }
    public boolean canCharge() { return true; }
    public void charge() {}
}

class CampusECar extends CampusVehicle implements ChargingVehicle {
    CampusECar(String passNumber, String owner) { super(passNumber, owner); }
    int getFee() { return 1000; }
    String getType() { return "ECar"; }
    public boolean canCharge() { return true; }
    public void charge() {}
}

public class CampusVehicleSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, CampusVehicle> vehicles = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split(" ");

            if (p[0].equals("PASS")) {
                String type = p[1], pass = p[2], owner = p[3];
                CampusVehicle vehicle;

                if (type.equals("Bike")) vehicle = new CampusBike(pass, owner);
                else if (type.equals("Car")) vehicle = new CampusCar(pass, owner);
                else if (type.equals("EBike")) vehicle = new CampusEBike(pass, owner);
                else vehicle = new CampusECar(pass, owner);

                vehicles.put(pass, vehicle);
                System.out.println(pass + " (" + vehicle.getType() + ") pass fee " + vehicle.getFee());
            } else if (p[0].equals("CHARGE")) {
                String pass = p[1];
                CampusVehicle vehicle = vehicles.get(pass);
                if (vehicle.canCharge())
                    System.out.println(pass + " charging bay allotted");
                else
                    System.out.println(pass + " rejected: charging unsupported");
            }
        }
    }
}
