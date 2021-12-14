public class 排序链表 {
    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {

        sort()
        return null;
    }

    public static ListNode sort(ListNode l, ListNode r) {
        ListNode slow, fast;
        slow = fast = l;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        sort(l, mid);
        sort(mid.next, r)
    }
}
