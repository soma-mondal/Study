package leetcode;

import leetcode.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            if (root == null) {
                return node;
            }
            node.left = root;
            return node;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int prevCount = 1;
        depth--;
        while (!queue.isEmpty()) {
            if (depth == 1) {
                while (prevCount-->0) {
                    TreeNode node = queue.poll();
                    node.left = new TreeNode(val, node.left, null);
                    node.right = new TreeNode(val, null, node.right);
                }
            } else {
                while (prevCount-->0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                prevCount = queue.size();
            }
            depth--;
        }
        return root;
    }

}
