package HOT100题;

public class 两数相加 {
    public static void main(String[] args) {


        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;

        ListNode sum = addTwoNumbers(a1,b1);
        ListNode p = sum;
        while (p != null) {
            System.out.print(p.val + " ");
            p=p.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        //用于存储相加后的值
        ListNode l = new ListNode();
        ListNode p = l;
        //用于记录是否进位的标志
        int carry = 0;
        int add;

        while (p1 != null || p2 != null) {
            add = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            if(add > 9){
                add = add % 10;
                carry = 1;
            }else {
                carry = 0;
            }

            p.next = new ListNode(add);
            p = p.next;

            if (p1 != null) {
                p1 = p1.next;
            }

            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if (carry != 0) {
            p.next = new ListNode(1);
        }

        return l.next;
    }
}




