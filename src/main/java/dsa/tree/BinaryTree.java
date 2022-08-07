package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BinaryTree {

    Node root;

    /***
     * Height of a given node
     * @param node
     * @return height
     */
    private static int height(Node node) {
        return node == null ?  0 : 1 + Math.max(height(node.left), height(node.right));
    }

    /***
     * Diameter or Width of a binary tree
     * @return diameter
     */
    private int diameter() {
        Height height = new Height();
        return diameter(root, height);
    }

    private static int diameter(Node root, Height height) {
        Height lh = new Height(), rh = new Height();
        if (root == null) {
            height.h = 0;
            return 0;
        }

        int lDia = diameter(root.left, lh);
        int rDia = diameter(root.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;
        return 1 + Math.max(lh.h + rh.h , Math.max(lDia, rDia));
    }

    /***
     * Inorder without recursion
     */
    private void inorderWithStack() {
        if (root == null)
            return;

        Stack<Node> s = new Stack<>();
        Node curr = root;

        while (curr != null || s.size() > 0) {
            while (curr !=  null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    /***
     *  Function to get the maximum width of a binary tree
     */
    private static int getMaxWidth(Node node) {
        int maxWidth = 0;
        int width;
        int h = height(node);

        for (int i = 1; i <= h; i++) {
            width = getWidth(node, i);
            if (width > maxWidth)
                maxWidth = width;
        }
        return maxWidth;
    }

    /***
     *  Get width of a given level
     */
    private static int getWidth(Node node, int level) {
        if (node == null)
            return 0;
        if (level == 1)
            return 1;
        else if (level > 1)
            return getWidth(node.left, level - 1)  + getWidth(node.right, level - 1);
        return 0;
    }

    /***
     *  Function to get the maximum width of a binary tree (dsa.queue.Queue)
     */
    private static int maxWidthWithQueue(Node root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int count = q.size();
            maxWidth = Math.max(maxWidth, count);
            while (count-- > 0) {
                Node temp = q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return maxWidth;
    }

    /***
     * Print nodes from k distance of a given node
     */
    private void printKDistant(Node node, int k) {
        if (node == null|| k < 0 ) return;
        if (k == 0) {
            System.out.print(node.data + " ");
            return;
        }
        printKDistant(node.left, k - 1);
        printKDistant(node.right, k - 1);
    }

    /* If target is present in tree, then prints the ancestors
       and returns true, otherwise returns false. */
    private boolean printAncestors(Node node, int target) {
        if (node == null) return false;
        if (node.data == target) return true;
        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }
        return false;
    }

    private boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        return (root1.data == root2.data &&
                areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    private boolean isSubtree(Node T, Node S) {
        if (S == null) return true;
        if (T == null) return false;

        if (areIdentical(T, S)) return true;

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);

        System.out.println("The diameter of given binary tree is : " + tree.diameter());
        System.out.print("Inorder traversal without recursion : ");
        tree.inorderWithStack();
        System.out.println("\nThe Max Width of given binary tree is : " + getMaxWidth(tree.root));
        System.out.println("The Max Width(using queue) of given binary tree is : " + maxWidthWithQueue(tree.root));
        System.out.print("K distance from root : ");
        tree.printKDistant(tree.root, 2);
        System.out.print("\nPrint Ancestors of a given node :");
        tree.printAncestors(tree.root, 8);
    }
}

