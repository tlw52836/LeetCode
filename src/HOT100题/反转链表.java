package HOT100题;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        head.next = l2;
        l2.next = l3;

        ListNode L= reverseList(head);
        ListNode p = L;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }




    }
    public static ListNode reverseList(ListNode head) {

        ListNode L = new ListNode();  //设置头结点
        ListNode p = head,q;

        while (p != null) {
            q = p;
            p = p.next;
            q.next = L.next;
            L.next = q;
        }
        return L.next;
    }
}
