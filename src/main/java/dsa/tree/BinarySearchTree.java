package dsa.tree;

public class BinarySearchTree {

    Node root;

    BinarySearchTree() { root = null; }

    BinarySearchTree(int value) { root = new Node(value); }

    private static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    private Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);

        return root;
    }

    private Node search(Node root, int key) {
        if (root==null || root.data==key)
            return root;

        if (root.data < key)
            return search(root.right, key);

        return search(root.left, key);
    }


    static Node deleteNode(Node root, int k) {
        if (root == null)
            return null;

        // Recursive calls for ancestors of
        // node to be deleted
        if (root.data > k) {
            root.left = deleteNode(root.left, k);
            return root;
        } else if (root.data < k) {
            root.right = deleteNode(root.right, k);
            return root;
        }

        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node successorParent = root;
            Node successor = root.right;

            /* We are finding the smallest element in the right subtree of the root */
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            /* successor doesn't have a left child here and root need to be replaced with successor
             * Now two scenario can happen, successorParent is not root: In that case successor is the left child of successorParent,
             * so we need to bring successor.right in place of successor (which is successorParent.left)
             * 2nd scenario: successorParent is root: So successor is the right child of successorParent,
             * so we need to bring successor.right in place of successor (which is successorParent.right)
             */
            if (successorParent != root)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;

            root.data = successor.data;
            return root;
        }
    }

    int minvalue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return (current.data);
    }

    static boolean isBST(Node root, Node l, Node r) {
        if (root == null)
            return true;

        if (l != null && root.data <= l.data)
            return false;

        if (r != null && root.data >= r.data)
            return false;

        return isBST(root.left, l, root) && isBST(root.right, root, r);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(tree.root,50);
        tree.insert(tree.root,30);
        tree.insert(tree.root,20);
        tree.insert(tree.root,40);
        tree.insert(tree.root,70);
        tree.insert(tree.root,60);
        tree.insert(tree.root,80);

        // print inorder traversal of the BST
        inorder(tree.root);
    }
}
