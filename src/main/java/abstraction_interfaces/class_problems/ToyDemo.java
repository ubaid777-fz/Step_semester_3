abstract class Toy {
    static int counter = 1001;
    final String toyId;

    Toy() {
        toyId = "TOY-" + counter++;
    }

    abstract String makeSound();

    String getToyId() {
        return toyId;
    }
}

class ToyCar extends Toy {
    String name;

    ToyCar(String name) {
        this.name = name;
    }

    String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    String name;

    ToyRobot(String name) {
        this.name = name;
    }

    String makeSound() {
        return name + ": Beep boop!";
    }
}

public class ToyDemo {
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");

        System.out.println(c.makeSound());
        System.out.println(r.makeSound());
        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}
