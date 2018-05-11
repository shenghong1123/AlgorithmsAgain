import LeetCode.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i, Integer j) {
                return Integer.compare(i, j);
            }
        });
        pq.add(1);
        pq.add(2);

        System.out.println(pq.poll());

    }

    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void printListNode(ListNode l) {
        if (l == null) System.out.println("This is an empty list");
        else {
            while (l != null) {
                System.out.println(l.val);
                l = l.next;
            }
        }
    }

    public static ListNode buildList(int[] nums) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        for (int num : nums) {
            head.next = new ListNode(num);
            head = head.next;
        }
        return dummy.next;
    }
}
