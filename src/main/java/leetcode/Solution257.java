package leetcode;

import leetcode.model.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        pathOfLeaf(root, String.valueOf(root.val), result);
        return result;
    }

    private void pathOfLeaf(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) pathOfLeaf(root.left, path + "->" + root.left.val, result);
        if (root.right != null) pathOfLeaf(root.right, path + "->" + root.right.val, result);
    }
}
