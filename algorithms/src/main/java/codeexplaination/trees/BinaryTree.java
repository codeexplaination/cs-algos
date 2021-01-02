package codeexplaination.trees;


public class BinaryTree {


    // Root of Binary Tree
    Node root;

    // Constructors
    BinaryTree(int key) {
        root = new Node(key);
    }

    BinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /*create root*/
        tree.root = new Node(1);

        /* following is the tree after above statement
              1
            /   \
          null  null     */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */


        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

        tree.root.left.right = new Node(5);
        /* 5 becomes right child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    5  null  null
           /   \
          null null
         */

        tree.root.right.left = new Node(6);
        /* 6 becomes left child of 3
                    1
                /       \
               2          3
             /   \       /  \
            4    5      6  null
           /   \
          null null
         */

    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
