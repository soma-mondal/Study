package leetcode;

import java.util.*;

public class Solution207 {

    HashMap<Integer, List<Integer>> adjMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i<numCourses; i++) {
            adjMap.put(i, new ArrayList<>());
        }
        for(int[] edge: prerequisites) {
            adjMap.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i<numCourses; i++) {
            if (!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Integer v) {
        if(visited.contains(v)) return false;
        if(adjMap.get(v).isEmpty()) return true;
        visited.add(v);
        for (Integer nei: adjMap.get(v)) {
            boolean loop = dfs(nei);
            if (loop) return false;
        }
        visited.remove(v);
        adjMap.put(v, new ArrayList<>());
        return true;
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(new Solution207().canFinish(20, a));
    }

}
