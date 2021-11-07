public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode build(int[] nums) {
        ListNode head = new ListNode();
        ListNode p = head;

        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            p.next = node;
            p = p.next;
        }

        return head.next;
    }
}
