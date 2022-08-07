package leetcode;

import leetcode.model.ListNode;

public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(-1, head);
        ListNode left = temp, right = head;

        while (n-->0) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right= right.next;
        }

        left.next = left.next.next;
        return temp.next;
    }

}
