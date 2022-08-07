package leetcode;

import leetcode.model.ListNode;

public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = length(head);
        k = k%len;
        if (k==0) return head;

        ListNode left = head, right = head;
        while (k-->0) {
            right = right.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        right.next = head;
        head = left.next;
        left.next = null;
        return head;
    }

    private int length(ListNode head) {
        int count=0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

}
