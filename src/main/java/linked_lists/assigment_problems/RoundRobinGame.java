class PlayerNode {
    String name;
    PlayerNode next;
    PlayerNode(String name) { this.name = name; this.next = null; }
}

public class RoundRobinGame {
    PlayerNode tail;

    void addLast(String name) {
        PlayerNode newNode = new PlayerNode(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void printTurns(int turns) {
        if (tail == null) return;
        PlayerNode current = tail.next;
        for (int i = 0; i < turns; i++) {
            System.out.print(current.name);
            if (i < turns - 1) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RoundRobinGame game = new RoundRobinGame();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");
        game.printTurns(7);
    }
}
