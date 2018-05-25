package Algorithms;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedListCycle solution = new LinkedListCycle();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

        System.out.println(solution.hasCycle(a));
    }
}
