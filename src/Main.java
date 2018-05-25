import Algorithms.*;
import java.lang.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaab");
        boolean b = m.matches();
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
