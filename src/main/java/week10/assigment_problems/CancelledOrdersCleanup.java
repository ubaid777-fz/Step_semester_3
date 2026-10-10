class OrderNode {
    int data;
    OrderNode next;
    OrderNode(int data) { this.data = data; this.next = null; }
}

public class CancelledOrdersCleanup {
    static OrderNode removeAll(OrderNode head, int code) {
        while (head != null && head.data == code) head = head.next;
        OrderNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.data == code) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head;
    }

    static void printList(OrderNode head) {
        while (head != null) { System.out.print(head.data + " -> "); head = head.next; }
        System.out.println("null");
    }

    public static void main(String[] args) {
        OrderNode head = new OrderNode(5);
        head.next = new OrderNode(3);
        head.next.next = new OrderNode(5);
        head.next.next.next = new OrderNode(8);
        head.next.next.next.next = new OrderNode(5);
        head = removeAll(head, 5);
        printList(head);
    }
}