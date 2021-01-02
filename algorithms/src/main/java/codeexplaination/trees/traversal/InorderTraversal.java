package codeexplaination.trees.traversal;

public class InorderTraversal {

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    public void printInorder() {
        System.out.println("Inorder traversal using recursion is: ");
        inorderUsingRecursion(root);
    }

    private void inorderUsingRecursion(Node root) {
        if (root != null) {
            inorderUsingRecursion(root.left);
            System.out.print(root.data + " ");
            inorderUsingRecursion(root.right);
        }
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        inorderTraversal.insert(50);
        inorderTraversal.insert(30);
        inorderTraversal.insert(20);
        inorderTraversal.insert(35);
        inorderTraversal.insert(100);
        inorderTraversal.insert(110);
        inorderTraversal.insert(90);
        inorderTraversal.insert(95);
        inorderTraversal.insert(53);
        inorderTraversal.insert(12);
        inorderTraversal.insert(22);

        //                    50
        //           30                  100
        //      20       35         90         110
        //   12     22           53     95

        inorderTraversal.printInorder();
    }
}
