package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution386 {

    public List<Integer> lexicalOrder(int n) {
        int curr = 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            result.add(curr);
            if (curr*10 <=n) {
                curr *= 10;
            } else {
                if (curr + 1 <=n && curr%10 != 9) {
                    curr ++;
                } else {
                    while (((curr/10)%10) == 9) {
                        curr = curr/10;
                    }
                    curr = curr/10 + 1;
                }
            }
        }
        return result;
    }

}
