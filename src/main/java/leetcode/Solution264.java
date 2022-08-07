package leetcode;

public class Solution264 {

    public int nthUglyNumber(int n) {
        int[] uglyNumberList = new int[n];
        uglyNumberList[0] = 1;
        int posTwo = 0;
        int posThree = 0;
        int posFive = 0;

        for(int i = 1; i<n; i++) {
            int multiplyTwo = uglyNumberList[posTwo] * 2;
            int multiplyThree = uglyNumberList[posThree] * 3;
            int multiplyFive = uglyNumberList[posFive] * 5;

            int min = Math.min(multiplyTwo, Math.min(multiplyThree, multiplyFive));
            uglyNumberList[i] = min;

            if (multiplyTwo == min) posTwo++;
            if (multiplyThree == min) posThree++;
            if (multiplyFive == min) posFive++;
        }
        return uglyNumberList[n -1];
    }

}
