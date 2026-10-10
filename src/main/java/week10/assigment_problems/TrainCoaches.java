class CoachNode {
    String name;
    CoachNode prev, next;
    CoachNode(String name) { this.name = name; }
}

public class TrainCoaches {
    CoachNode head, tail;
    void addLast(String name) {
        CoachNode newNode = new CoachNode(name);
        if (head == null) { head = newNode; tail = newNode; return; }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    void remove(String name) {
        CoachNode temp = head;
        while (temp != null && !temp.name.equals(name)) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = temp.next;
        else temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;
        else temp.next.prev = temp.prev;
    }
    void printForward() {
        CoachNode temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }
    void printBackward() {
        CoachNode temp = tail;
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.name);
            if (temp.prev != null) System.out.print(" <-> ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TrainCoaches train = new TrainCoaches();
        train.addLast("Engine"); train.addLast("A1"); train.addLast("B1");
        train.addLast("B2"); train.addLast("Guard");
        train.remove("B1");
        train.printForward();
        train.printBackward();
    }
}