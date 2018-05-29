import Algorithms.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<Integer, Integer> map = new HashMap<>();
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = it.next();

        }
    }
    static class comparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i, Integer j) {
            //return Integer.compare(i, j);
            //return i - j;
            if (i < j) return -1;
            else if (i == j) return 0;
            else return 1;
        }
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
