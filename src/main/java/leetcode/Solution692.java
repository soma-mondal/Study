package leetcode;

import java.util.*;

public class Solution692 {

    private static class Pair {
        String s;
        int f;

        public Pair(String s, int f) {
            this.s = s;
            this.f = f;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String it: words) {
            hashMap.put(it, hashMap.getOrDefault(it, 0) + 1);
        }
        PriorityQueue<Pair> pQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int diff = o2.f - o1.f;
                if (diff == 0) {
                    return o1.s.compareTo(o2.s);
                } else if (diff <0) return -1;
                return 1;
            }
        });
        for (String it: hashMap.keySet()) pQueue.offer(new Pair(it, hashMap.get(it)));
        List<String> result = new LinkedList<>();
        while (k-->0) {
            result.add(pQueue.poll().s);
        }
        return result;
    }

}
