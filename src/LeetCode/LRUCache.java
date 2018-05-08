package LeetCode;
import java.util.*;

public class LRUCache {

    DoubleLinkedList DLList;
    HashMap<Integer, DoubleLinkedListNode> map;
    int count;
    int capacity;

    public LRUCache(int capacity) {
        DLList = new DoubleLinkedList();
        map = new HashMap<>();
        count = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        DoubleLinkedListNode node = map.get(key);
        if (node == null) return -1;
        else {
            DLList.remove(node);
            DLList.insert(node);
            return node.value;
        }
    }

    public void put(int key, int value) {

        DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
        if (map.get(key) != null) {
            map.get(key).value = value;
            DLList.moveToHead(map.get(key));
        }
        else if (count < capacity) {
            DLList.insert(node);
            count++;
            map.put(key, node);
        }
        else {

            DoubleLinkedListNode last = DLList.getLast();
            map.remove(last.key);
            DLList.remove(last);
            DLList.insert(node);
            count++;
            map.put(key, node);
        }
    }

    class DoubleLinkedListNode {
        DoubleLinkedListNode pre;
        DoubleLinkedListNode next;
        int key;
        int value;

        DoubleLinkedListNode() {
            pre = null;
            next = null;
        }

        DoubleLinkedListNode(int k, int v) {
            key = k;
            value = v;
        }
    }

    class DoubleLinkedList {
        DoubleLinkedListNode head;
        DoubleLinkedListNode tail;

        DoubleLinkedList() {
            head = new DoubleLinkedListNode();
            tail = new DoubleLinkedListNode();
            head.next = tail;
            tail.pre = head;
        }

        void remove(DoubleLinkedListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        void insert(DoubleLinkedListNode node) {
            DoubleLinkedListNode temp = head.next;
            head.next = node;
            node.pre = head;
            node.next = temp;
            temp.pre = node;
        }

        DoubleLinkedListNode getLast() {
            return tail.pre;
        }

        void moveToHead(DoubleLinkedListNode node) {
            this.remove(node);
            this.insert(node);
        }
    }
}
