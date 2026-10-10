class TokenNode {
    int data;
    TokenNode next;
    TokenNode(int data) { this.data = data; this.next = null; }
}

public class PriorityTokenInsertion {
    TokenNode head;

    void addFirst(int token) {
        TokenNode newNode = new TokenNode(token);
        newNode.next = head;
        head = newNode;
    }

    void addLast(int token) {
        TokenNode newNode = new TokenNode(token);
        if (head == null) {
            head = newNode;
            return;
        }
        TokenNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }
        TokenNode temp = head;
        for (int i = 0; i < index - 1; i++) temp = temp.next;
        TokenNode newNode = new TokenNode(token);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void printList() {
        TokenNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PriorityTokenInsertion list = new PriorityTokenInsertion();
        list.addLast(101);
        list.addLast(102);
        list.addLast(103);
        list.addFirst(100);
        list.addLast(104);
        list.insertAt(2, 150);
        list.printList();
    }
}
