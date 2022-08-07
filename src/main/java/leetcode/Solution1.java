package leetcode;

import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i =0; i<nums.length; i++) {
            int val = nums[i];
            int diff = target - val;
            if (hashMap.containsKey(diff)) {
                return new int[]{hashMap.get(diff), i};
            }
            hashMap.put(val, i);
        }
        return new int[]{-1, -1};
    }

}
