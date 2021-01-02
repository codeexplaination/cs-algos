package codeexplaination.trees.traversal;

public class PostorderTraversal {
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

    public void printPostorder() {
        System.out.println("Postorder traversal using recursion is: ");
        postorderUsingRecursion(root);
    }

    private void postorderUsingRecursion(Node root) {
        if (root != null) {
            postorderUsingRecursion(root.left);
            postorderUsingRecursion(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        PostorderTraversal postorderTraversal = new PostorderTraversal();
        postorderTraversal.insert(50);
        postorderTraversal.insert(30);
        postorderTraversal.insert(20);
        postorderTraversal.insert(35);
        postorderTraversal.insert(100);
        postorderTraversal.insert(110);
        postorderTraversal.insert(90);
        postorderTraversal.insert(95);
        postorderTraversal.insert(53);
        postorderTraversal.insert(12);
        postorderTraversal.insert(22);

        //                    50
        //           30                  100
        //      20       35         90         110
        //   12     22           53     95

        postorderTraversal.printPostorder();
    }
}
