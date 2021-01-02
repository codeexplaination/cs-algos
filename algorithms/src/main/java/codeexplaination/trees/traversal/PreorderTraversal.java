package codeexplaination.trees.traversal;

public class PreorderTraversal {
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

    public void printPreorder() {
        System.out.println("Preorder traversal using recursion is: ");
        preorderUsingRecursion(root);
    }

    private void preorderUsingRecursion(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderUsingRecursion(root.left);
            preorderUsingRecursion(root.right);
        }
    }

    public static void main(String[] args) {
        PreorderTraversal preorderTraversal = new PreorderTraversal();
        preorderTraversal.insert(50);
        preorderTraversal.insert(30);
        preorderTraversal.insert(20);
        preorderTraversal.insert(35);
        preorderTraversal.insert(100);
        preorderTraversal.insert(110);
        preorderTraversal.insert(90);
        preorderTraversal.insert(95);
        preorderTraversal.insert(53);
        preorderTraversal.insert(12);
        preorderTraversal.insert(22);

        //                    50
        //           30                  100
        //      20       35         90         110
        //   12     22           53     95

        preorderTraversal.printPreorder();
    }
}
