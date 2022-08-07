package leetcode;

public class Solution5 {

    public String longestPalindrome(String s) {
        if (s== null || s.length() == 0) return "";
        if (s.length() == 1) return s;
        int start =0, end =0;
        for(int i = 0; i<s.length(); i++) {
            int l1 = longestPalindromeLength(s, i, i);
            int l2 = longestPalindromeLength(s, i, i+1);
            int len = Math.max(l1, l2);
            if (len > end-start) {
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int longestPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right-left-1;
    }

    public String longestPalindromeWithDP(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

}
