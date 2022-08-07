package leetcode;

import leetcode.model.TreeNode;

import java.util.*;

public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return Collections.EMPTY_LIST;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while (size-->0) {
                TreeNode curr = queue.poll();
                tempList.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(tempList);
        }
        return result;
    }

}
