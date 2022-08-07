package leetcode;

import leetcode.model.TreeNode;

public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        if (root.left == null && root.right == null) return null;

        TreeNode left = null;
        TreeNode right = null;

        if (root.left != null) left = lowestCommonAncestor(root.left, p, q);
        if (root.right != null) right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

}
