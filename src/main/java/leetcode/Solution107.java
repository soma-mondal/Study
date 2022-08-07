package leetcode;

import leetcode.model.TreeNode;

import java.util.*;

public class Solution107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = levelOrder(root);
        Collections.reverse(list);
        return list;
    }

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

    private void printLevelOrderBottomToTop(TreeNode root) {
        int h = height(root);
        for (int i = h; i >= 1; i--)
            printCurrentLevel(root, i);
    }


    private int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int lHeight = height(root.left);
            int rHeight = height(root.right);
            return lHeight>rHeight ? lHeight + 1 : rHeight + 1;
        }
    }

    private void printCurrentLevel(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.val + " ");
        else if (level > 1) {
            printCurrentLevel(root.left, level - 1);
            printCurrentLevel(root.right, level - 1);
        }
    }

}
