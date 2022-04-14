package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {
    public static void main(String[] args) {
        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(2);
        ListNode e3 = new ListNode(1);

        e1.next = e2;
        e2.next = e3;

        System.out.println(isPalindrome(e1));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode p = head;
        List<Integer> elems =  new ArrayList<>();

        while (p != null) {
            elems.add(p.val);
            p = p.next;
        }

        int i = 0, j = elems.size()-1;

        while (i < j) {
            if (elems.get(i) != elems.get(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
