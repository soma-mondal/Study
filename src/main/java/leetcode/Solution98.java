package leetcode;

import leetcode.model.TreeNode;

class Solution98 {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    boolean isBST(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) return true;
        if (left != null && left.val >= root.val) return false;
        if (right != null && right.val <= root.val) return false;
        return isBST(root.left, left, root) && isBST(root.right, root, right);
    }

}
