package leetcode;

import leetcode.model.TreeNode;

public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.val == t2.val && isSymmetric(t1.left, t2.right) && isSymmetric(t2.left, t1.right);
    }


}
