class QueueNode {
    int data;
    QueueNode next;
    QueueNode(int data) { this.data = data; this.next = null; }
}

public class ReverseQueue {
    static QueueNode reverse(QueueNode head) {
        QueueNode previous = null, current = head;
        while (current != null) {
            QueueNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    static void printList(QueueNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueNode head = new QueueNode(1);
        head.next = new QueueNode(2);
        head.next.next = new QueueNode(3);
        head.next.next.next = new QueueNode(4);
        head = reverse(head);
        printList(head);
    }
}
