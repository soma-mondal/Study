package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Integer it: nums) {
            hashMap.put(it, hashMap.getOrDefault(it, 0) + 1);
        }
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> hashMap.get(b) - hashMap.get(a));
        for (Integer it: hashMap.keySet()) {
            pQueue.offer(it);
        }
        int[] result = new int[k];
        while (k-->0) result[k] = pQueue.poll();
        return result;
    }

}
