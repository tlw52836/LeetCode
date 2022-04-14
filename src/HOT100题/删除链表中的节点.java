package HOT100题;

public class 删除链表中的节点 {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        ListNode pre = node;
        ListNode p = node.next;

        while (p.next != null) {
            pre.val = p.val;
            pre = p;
            p = p.next;
        }
        pre.val = p.val;
        pre.next = null;
    }
}
