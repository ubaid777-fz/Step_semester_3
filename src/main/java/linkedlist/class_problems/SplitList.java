public class SplitList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }
    static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node secondHalf = slow.next;
        slow.next = null;
        return secondHalf;
    }
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        Node secondHalf = splitListInHalf(head);
        System.out.print("First half: ");
        printList(head);
        System.out.print("\nSecond half: ");
        printList(secondHalf);
    }
}