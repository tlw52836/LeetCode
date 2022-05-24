package 图解算法数据结构.数据结构;

import java.util.Stack;

public class 从尾到头打印链表 {
    static int t;
    public static void main(String[] args) {
        System.out.println(t);
    }

    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        Stack<ListNode> stack = new Stack<>();
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        int[] res = new int[stack.size()];
        int t = 0;
        while (!stack.isEmpty()) {
            res[t++] = stack.pop().val;
        }
        return res;
    }
}
