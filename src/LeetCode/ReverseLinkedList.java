package LeetCode;

public class ReverseLinkedList {
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;

        while (head != null) {
            System.out.println(head.val);
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {

        ReverseLinkedList solution = new ReverseLinkedList();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = d;

        ListNode result = solution.reverseListIterative(a);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
