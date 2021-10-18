import java.util.ArrayList;
import java.util.List;

public class 环形链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(hasCycle(l1));

        List<String> list = new ArrayList<>();
        list.add("fff");

    }

    public static boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q;
        while (p != null) {
            q = p.next;
            while (q != null) {
                if (q == p)
                    return true;
                else
                    q = q.next;
                System.out.println(q.val);
            }
            System.out.println(p.val);
            p = p.next;
        }
        return false;
    }
}
