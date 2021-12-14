public class 排序链表 {
    public static void main(String[] args) {
//        ListNode head1 = ListNode.build(new int[]{1, 4, 6, 8});
//        ListNode head2 = ListNode.build(new int[]{2, 5, 7, 9});
//        ListNode merge = merge(head1, head2);
//        ListNode.print(merge);


        ListNode head = ListNode.build(new int[]{4, 3, 2, 8});
        ListNode list = sortList(head);
        ListNode.print(list);

    }

    public static ListNode sortList(ListNode head) {
       ListNode p = head;

        while (p.next != null)
            p = p.next;

        return sort(head, p);
    }

    public static ListNode sort(ListNode l, ListNode r) {
        if (l == r)
            return l;

        ListNode slow, fast;
        slow = fast = l;

        while (fast != r && slow.next != fast) {
            slow = slow.next;
            fast = fast.next;
            if (fast != r)
                fast = fast.next;
        }

        ListNode mid = slow;
        ListNode l1 = sort(l, mid);
        ListNode r1 = sort(mid.next, r);

        return merge(l1, r1);
    }

    private static ListNode merge(ListNode l1, ListNode r1) {
        ListNode head = new ListNode();
        ListNode p = head;

        ListNode p1 = l1, p2 = r1;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null)
            p.next = p1;

        if (p2 != null)
            p.next = p2;

        return head.next;
    }
}
