import pojo.ListNode;

public class 两数相加 {
    public static void main(String[] args) {
        ListNode num1 = new ListNode();
        ListNode num2 = new ListNode();

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        num1.next = a1;
        a1.next = a2;
        a2.next = a3;

        num2.next = b1;
        b1.next = b2;
        b2.next = b3;

        ListNode sum = addTwoNumbers(num1,num2);
        ListNode p = sum.next;
        while (p != null) {
            System.out.print(p.val + " ");
            p=p.next;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1.next;
        ListNode p2 = l2.next;

        //用于存储相加后的值
        ListNode l = new ListNode();
        ListNode p = l;
        //用于记录是否进位的标志
        int flag = 0;
        int add;

        while (p1 != null && p2 != null) {
            add = p1.val + p2.val + flag;
            if(add > 9){
                add = add % 10;
                flag = 1;
            }else {
                flag = 0;
            }
            p.next = new ListNode(add);

            p1 = p1.next;
            p2 = p2.next;
            p = p.next;
        }

        //处理剩余的列表
        ListNode t;
        if(p1 != null){
            t = p1;
        }
        else {
            t = p2;
        }

        while (t != null) {
            add = t.val + flag;
            if (add > 9) {
                add = add % 10;
                flag = 1;
            }
            else{
                flag = 0;
            }
            p.next = new ListNode(add);
            t = t.next;
            p = p.next;
        }

        if (flag != 0) {
            p.next = new ListNode(1);
        }
        return l;
    }
}




