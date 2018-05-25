package Algorithms;

//l1 = 2 -> 4 -> 3
//l2 = 5 -> 6 -> 4

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int sum = 0;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null? 0 : l1.val;
            int val2 = l2 == null? 0 : l2.val;
            sum = val1 + val2 + flag;
            head.next = new ListNode(sum % 10);
            flag = sum / 10;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l2.next;
            head = head.next;
        }
        if (flag != 0) {
            head.next = new ListNode(flag);
        }
        return dummy.next;
    }
}
