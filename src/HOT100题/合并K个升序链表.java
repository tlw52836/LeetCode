package HOT100题;

public class 合并K个升序链表 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;

        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(48);

        l5.next = l6;

        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(88);
        l7.next = l8;


        ListNode merge = mergeKLists(new ListNode[]{l1,l5,l7});
        ListNode p = merge;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }

    }


    /**
     * 合并两个链表
     * @param l1
     * @param l2
     * @return
     */
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

    /**
     * 合并K个链表：依次遍历每个链表，将其与merge（存放当前合并后的链表）合并
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode merge = lists[0];  //存合并后的链表
        for(int i = 1;i < lists.length;i++){
            merge = mergeTwoLists(merge,lists[i]);
        }
        return merge;
    }
}
