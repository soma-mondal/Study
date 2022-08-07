package leetcode;

public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        int lenA = nums1.length;
        int lenB = nums2.length;

        if (lenA>lenB) {
            a = nums2;
            b = nums1;
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
        }

        int s = 0, e = lenA-1;
        int half = (lenA + lenB)/2;
        while (s<=e) {
            int midA = (s + e)/2;
            int midB = half - midA - 2;

            int aLeft = midA >= 0 ? a[midA] : Integer.MIN_VALUE;
            int aRight = midA + 1 < lenA ? a[midA + 1] : Integer.MAX_VALUE;

            int bLeft = midB >= 0 ? b[midB] : Integer.MIN_VALUE;
            int bRight = midB + 1 < lenB ? a[midB + 1] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) {
                if ((lenA + lenB)%2 == 0) {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2.0;
                }
                return Math.min(aRight, bRight)/1.0;
            } else if (aLeft > bRight) {
                s = midA - 1;
            } else {
                e = midA + 1;
            }

        }
        return 0.0;
    }

    public static void main(String args[]) {

        int num1[] = new int[2];
        num1[0] = 1;
        num1[1] = 2;
        int num2[] = new int[2];
        num2[0] = 3;
        num2[1] = 4;
        new Solution4().findMedianSortedArrays(num1, num2);
    }

}
