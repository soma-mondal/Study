package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            pQueue.add(i);
        }
        while (k>1) {
            pQueue.poll();
            k--;
        }
        return pQueue.poll();
    }

}
