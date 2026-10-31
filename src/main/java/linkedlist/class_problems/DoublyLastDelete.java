public class DoublyLastDelete {
    static class DNode {
        int data;
        DNode prev;
        DNode next;
        DNode(int data) { this.data = data; }
    }
    static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null || head.next == null) return null;
        DNode current = head;
        while (current.next != null) current = current.next;
        current.prev.next = null;
        current.prev = null;
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
        DNode second = new DNode(2);
        DNode third = new DNode(3);
        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        head = deleteLastNodeDoubly(head);
        printList(head);
    }
}