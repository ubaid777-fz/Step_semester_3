
import java.util.*;

class Tab {
    String name;
    Tab prev;
    Tab next;

    Tab(String name) {
        this.name = name;
    }
}

public class BrowserTabStrip {

    Tab head = null;
    Tab current = null;

    void open(String name) {
        Tab newTab = new Tab(name);

        if (head == null) {
            head = newTab;
            current = newTab;
        } else {
            newTab.prev = current;
            newTab.next = current.next;

            if (current.next != null) {
                current.next.prev = newTab;
            }

            current.next = newTab;
            current = newTab;
        }

        display();
    }

    void close() {
        if (current == null) {
            System.out.println("No tabs");
            return;
        }

        String name = current.name;
        Tab nextTab = current.next;
        Tab previousTab = current.prev;

        if (previousTab != null) {
            previousTab.next = nextTab;
        } else {
            head = nextTab;
        }

        if (nextTab != null) {
            nextTab.prev = previousTab;
            current = nextTab;
        } else {
            current = previousTab;
        }

        System.out.print("CLOSE " + name + ": ");
        display();
    }

    void back() {
        if (current == null || current.prev == null) {
            System.out.println("BACK: already at first tab");
        } else {
            current = current.prev;
            System.out.print("BACK: ");
            display();
        }
    }

    void forward() {
        if (current == null || current.next == null) {
            System.out.println("FORWARD: already at last tab");
        } else {
            current = current.next;
            System.out.print("FORWARD: ");
            display();
        }
    }

    void display() {
        Tab temp = head;

        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.name + "]");
            } else {
                System.out.print(temp.name);
            }

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    void printBackward() {
        if (head == null) {
            System.out.println("Backward: (empty)");
            return;
        }

        Tab temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");

        while (temp != null) {
            System.out.print(temp.name);

            if (temp.prev != null) {
                System.out.print(" <-> ");
            }

            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserTabStrip browser = new BrowserTabStrip();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("OPEN ")) {
                String name = command.substring(5);
                System.out.print("OPEN " + name + ": ");
                browser.open(name);
            } else if (command.equals("CLOSE")) {
                browser.close();
            } else if (command.equals("BACK")) {
                browser.back();
            } else if (command.equals("FORWARD")) {
                browser.forward();
            } else if (command.equals("PRINT BACKWARD")) {
                browser.printBackward();
            }
        }

        sc.close();
    }
}

