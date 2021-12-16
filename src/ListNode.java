/**
 * 单向链表
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    /**
     * 链表建立
     * @param nums
     * @return
     */
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

    /**
     * 遍历链表
     * @param l
     */
    public static void print(ListNode l) {
        ListNode p = l;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;

        }
    }
}
