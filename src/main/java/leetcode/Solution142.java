package leetcode;

import leetcode.model.ListNode;

public class Solution142 {

    /***
     * Calculation of slow and fast pointer
     * for first iteration 2*slow = fast
     * now if p = head to beginning of cycle and c = cycle length, x = where two point meet to beginning of cycle
     * 2(p + c -x) = p + c + c -x
     * So, p == x
     * https://www.youtube.com/watch?v=wjYnzkAhcNk
     */

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if(fast == null || fast.next == null) return null;

        slow = head;
        while (true) {
            if (slow == fast) return slow;
            slow = slow.next;
            fast = fast.next;
        }
    }

}
