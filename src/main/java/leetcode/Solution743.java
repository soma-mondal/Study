package leetcode;

import java.util.*;

public class Solution743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 1; i<=n; i++) {
            List<Pair> nList = new ArrayList<>();
            map.put(i, nList);
        }
        for (int[] val: times) {
            map.get(val[0]).add(new Pair(val[1], val[2]));
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>((p1, p2) -> p1.weight - p2.weight);
        priorityQueue.add(new Pair(k, 0));
        Set<Integer> visited = new HashSet<>();
        int time = 0;

        while (!priorityQueue.isEmpty()) {
            Pair p = priorityQueue.poll();
            if (visited.contains(p.node)) continue;
            visited.add(p.node);
            time = Math.max(time, p.weight);
            for (Pair node: map.get(p.node)) {
                if (visited.contains(node.node)) continue;
                priorityQueue.add(new Pair(node.node, node.weight+p.weight));
            }
        }
        return visited.size() == n ? time : -1;
    }

    private static class Pair {
        Integer node;
        Integer weight;

        public Pair(Integer node, Integer weight) {
            this.node = node;
            this.weight = weight;
        }
    }

}
