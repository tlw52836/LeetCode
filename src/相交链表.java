import java.util.*;

public class 相交链表 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(11);
        ListNode a3 = new ListNode(111);

        ListNode b1 = new ListNode(2);

        ListNode c1 = new ListNode(3);
        ListNode c2 = new ListNode(33);

        a1.next = a2;
        a2.next = a3;
        a3.next = c1;

        b1.next = c1;

        c1.next = c2;

        Solution s = new Solution();
        System.out.println(s.getIntersectionNode(a1, b1).val);
    }
}

class Solution {
    /**
     * 依次遍历两个链表，算出它们之间的长度差diff；将较长的链表向前移动diff个单元
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0, bLen = 0, diff;  //diff:长度差
        ListNode p, p1 = headA, p2 = headB;

        p = headA;
        while (p != null) {
            aLen++;
            p = p.next;
        }

        p = headB;
        while (p != null) {
            bLen++;
            p = p.next;
        }

        diff = Math.abs(aLen-bLen);
        if (aLen > bLen) {
            while (diff != 0) {
                p1 = p1.next;
                diff--;
            }
        } else {
            while (diff != 0) {
                p2 = p2.next;
                diff--;
            }
        }

        while (p1 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }
}


