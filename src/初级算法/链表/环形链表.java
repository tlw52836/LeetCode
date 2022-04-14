package 初级算法.链表;

import java.util.HashSet;
import java.util.Set;

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

    }



    /**
     * p指针每次走一步步，q指针每次走两步，若在走的过程中相遇则证明存在环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode p = head, q = head.next;
        while (p != q) {
            if (q.next != null && q.next.next != null){
                p = p.next;
                q = q.next.next;
            }else {
                return false;
            }
        }
        return true;
    }

    /**
     * map
     * @param head
     * @return
     */
    public static boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;

        while (p != null) {
            if (!set.add(p)) {
                return true;
            }
            p = p.next;
        }
        return false;
    }
}
