package leetcode;

import leetcode.model.ListNode;

public class Solution1721 {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = new ListNode(-1, head);
        ListNode left = temp, right = head;

        while (k-->1) {
            right = right.next;
        }

        ListNode tempRight = right;

        while (tempRight != null) {
            left = left.next;
            tempRight = tempRight.next;
        }

        int x = left.val;
        left.val = right.val;
        right.val = x;

        return temp.next;
    }

}
