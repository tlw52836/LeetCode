package HOT100题;

public class 合并两个有序链表 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;

        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(48);

        l5.next = l6;

       ListNode merge = mergeTwoLists(l1,l5);
       ListNode p = merge;
       while(p != null){
           System.out.print(p.val + " ");
           p = p.next;
       }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 加上头结点以便于统一操作
         */
        ListNode l0 = new ListNode();  //头结点
        l0.next = l1;

        ListNode l4 = new ListNode();  //头结点
        l4.next = l2;


        ListNode p1 = l0.next;
        ListNode p2 = l4.next;

        //指向新列表的头结点
        ListNode l = new ListNode();
        ListNode p = l;
        while (p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
            else{
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        //剩余结点
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return l.next;
    }

}



