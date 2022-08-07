package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution451 {

    private static class Pair {
        char c;
        int f;

        public Pair(char c, int f) {
            this.c = c;
            this.f = f;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0; i<s.length(); i++) hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((a, b) -> b.f - a.f);
        for(char c: hashMap.keySet()) pQueue.offer(new Pair(c, hashMap.get(c)));
        StringBuilder builder = new StringBuilder();
        while (!pQueue.isEmpty()) {
            Pair p = pQueue.poll();
            builder.append(Character.toString(p.c).repeat(p.f));
        }
        return builder.toString();
    }

}
