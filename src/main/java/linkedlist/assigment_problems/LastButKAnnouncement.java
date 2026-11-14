
import java.util.*;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        next = null;
    }
}

public class LastButKAnnouncement {

    static String kthFromEnd(Node head, int k) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < k; i++) {
            if (first == null) {
                return "Invalid k";
            }
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node ÿ¡ô¹Õ±°ì4(9½Ñ¥°ô¹Õ±°ì4(4(½È¡¥¹Ð¤ôÀì¤ð¸ì¤¬¬¤ì4(9½¹Ý9½ô¹Ü9½¡Í¹¹áÐ ¤¤ì4(4(¥¡¡ôô¹Õ±°¤ì4(¡ô¹Ý9½ì4(Ñ¥°ô¹Ý9½ì4(ô±Íì4(Ñ¥°¹¹áÐô¹Ý9½ì4(Ñ¥°ô¹Ý9½ì4(ô4(ô4(4(¥¹Ð¬ôÍ¹¹áÑ%¹Ð ¤ì4(MÑÉ¥¹ÉÍÕ±Ðô­Ñ¡É½µ¹¡¡°¬¤ì4(4(¥¡ÉÍÕ±Ð¹ÅÕ±Ì %¹Ù±¥¬¤¤ì4(MåÍÑ´¹½ÕÐ¹ÁÉ¥¹Ñ±¸ %¹Ù±¥¬¤ì4(ô±Íì4(MåÍÑ´¹½ÕÐ¹ÁÉ¥¹Ñ±¸¡¬¬É½´Ñ¡¹è¬ÉÍÕ±Ð¤ì4(ô4(4(Í¹±½Í ¤ì4(ô4)ô4(4(