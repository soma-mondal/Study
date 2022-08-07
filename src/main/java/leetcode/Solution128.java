package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }

        int longest = 0;

        for (int num : nums) {
            if (hashSet.contains(num -1)) continue;
            int length = 1;
            while (hashSet.contains(num+1)) {
                num++;
                length++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }

}