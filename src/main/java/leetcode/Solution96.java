package leetcode;

public class Solution96 {

    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = nums[1] = 1;

        for (int i = 2; i<=n; i++) {
            int total = 0;
            for (int root = 1; root<=i; root++) {
                int left = root - 1;
                int right = i - root;
                total += nums[left] * nums[right];
            }
            nums[i] = total;
        }

        return nums[n];
    }

}
