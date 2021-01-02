package codeexplaination.trees.traversal;

/**
 * DFS can be either inorder(LVR), preorder(VLR) or postorder(LRV) traversal
 */
public class DFS {
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
        DFS dfs = new DFS();
        dfs.insert(50);
        dfs.insert(30);
        dfs.insert(20);
        dfs.insert(35);
        dfs.insert(100);
        dfs.insert(110);
        dfs.insert(90);
        dfs.insert(95);
        dfs.insert(53);
        dfs.insert(12);
        dfs.insert(22);

        //                    50
        //           30                  100
        //      20       35         90         110
        //   12     22           53     95

        dfs.printInorder();
        System.out.println();
        System.out.println();
        dfs.printPreorder();
        System.out.println();
        System.out.println();
        dfs.printPostorder();
    }
}
