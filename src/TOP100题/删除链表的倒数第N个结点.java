package TOP100题;

public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;

       ListNode head = removeNthFromEnd(l1,3);
       ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 双指针p,q：让q先走n步
         */
        ListNode p = head;
        ListNode q = p;
        ListNode t = p;  //指向p

        for(int i = 0;i < n;i++){
            q = q.next;
        }
        while (q != null) {
            t = p;
            p = p.next;
            q = q.next;
        }
        if (p == head) {
            head = head.next;
        }else {
            t.next = p.next;
        }
        return head;
    }
}
