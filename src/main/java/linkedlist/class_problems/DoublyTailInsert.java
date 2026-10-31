public class DoublyTailInsert {
    static class DNode {
        int data;
        DNode prev;
        DNode next;
        DNode(int data) { this.data = data; }
    }
    static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) return newNode;
        DNode current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
        newNode.prev = current;
        return head;
    }
    static void printList(DNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        DNode head = new DNode(1);
        head = insertAtTailDoubly(head, 2);
        head = insertAtTailDoubly(head, 3);
        head = insertAtTailDoubly(head, 4);
        printList(head);
    }
}