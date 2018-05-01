import LeetCode.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);
        TreeNode d = new TreeNode(5);
        root.left = a;
        root.right = b;
        b.left = c;
        b.right = d;
        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
        String s = solution.serialize(root);

        System.out.println(s);
        TreeNode node = solution.deserialize(s);

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
