package HOT100题;

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
         * 双指针p（指向需要删除的结点的前一个结点）,q：让q先走n步
         */

        //建立头结点
        ListNode Head = new ListNode();
        Head.next = head;

        ListNode p = Head;
        ListNode q = p;

        for(int i = 0;i < n;i++){
            q = q.next;
        }

        while (q.next != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return Head.next;
    }
}