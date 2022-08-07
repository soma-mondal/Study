package leetcode;

import leetcode.model.TreeNode;

import java.util.*;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    List<TreeNode> generate(int start, int end) {
        if (start > end) {
            return new ArrayList<>() {{add(null);}};
        } else if (start == end) {
            return new ArrayList<>() {{add(new TreeNode(start));}};
        }
        List<TreeNode> trees = new ArrayList<>();
        for (int i = start; i<=end; i++) {
            List<TreeNode> leftList = generate(start, i-1);
            List<TreeNode> rightList = generate(i+1, end);

            for (int l = 0; l<leftList.size(); l++) {
                for(int r = 0; r<rightList.size(); r++) {
                    trees.add(new TreeNode(i, leftList.get(l), rightList.get(r)));
                }
            }
        }
        return trees;
    }

}
