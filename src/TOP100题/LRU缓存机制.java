package TOP100题;

import java.util.HashMap;
import java.util.Map;

public class LRU缓存机制 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
    static class LRUCache {
        private Map<Integer, DLinkedNode> map;
        private DLinkedNode head;
        private DLinkedNode tail;
        private int capacity;
        private int len;


        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
            len = 0;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            //在链表中删除该节点，并将其插入头部
            DLinkedNode p = map.get(key);
            deleteNode(p);
            insertHead(p);

            return p.value;
        }

        public void put(int key, int value) {
            //包含key
            if (map.containsKey(key)) {
                map.get(key).value = value;
                //在链表中删除该节点，并将其插入头部
                DLinkedNode p = map.get(key);
                deleteNode(p);
                insertHead(p);
            } else {
                if (len >= capacity) {
                    map.remove(tail.prev.key);

                    //在链表中删除尾部节点，并将新结点其插入头部
                    deleteNode(tail.prev);
                    DLinkedNode newNode = new DLinkedNode(key, value);
                    insertHead(newNode);

                    map.put(key, newNode);
                } else {
                    len++;
                    //在链表头部插入新结点
                    DLinkedNode newNode = new DLinkedNode(key, value);
                    insertHead(newNode);

                    map.put(key, newNode);
                }
            }

        }

        //头部插入新结点
        public void insertHead(DLinkedNode newNode) {
            DLinkedNode p = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next = p;
            p.prev = newNode;
        }

        //删除结点
        public void deleteNode(DLinkedNode p) {
            DLinkedNode front = p.prev;
            DLinkedNode behind = p.next;
            front.next = behind;
            behind.prev = front;
        }

        /**
         * 双向链表
         */
        static class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key,int _value) {key = _key;value = _value;}
        }
    }
}
