package codeexplaination.trees.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is also called as level order traversal
 */
public class BFS {
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

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }
    }

    public void printBFSUsingRecursion() {
        System.out.println();
        System.out.println("BFS Using recursion is: ");
        int height = getHeight(root);
        for (int i = 1; i <= height; i++) {
            printLevelOrder(root, i);
        }
        System.out.println();
    }

    private void printLevelOrder(Node root, int level) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            System.out.print(root.data + " ");
        } else if (level > 1) {
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    public void printBFSUsingQueue() {
        System.out.println();
        System.out.println("BFS Using Queue is: ");

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        bfs.insert(50);
        bfs.insert(30);
        bfs.insert(20);
        bfs.insert(35);
        bfs.insert(100);
        bfs.insert(110);
        bfs.insert(90);
        bfs.insert(95);
        bfs.insert(53);
        bfs.insert(12);
        bfs.insert(22);

        //                    50
        //           30                  100
        //      20       35         90         110
        //   12     22           53     95

        System.out.println("Height of the tree is: " + bfs.getHeight(bfs.root));
        bfs.printBFSUsingRecursion();
        bfs.printBFSUsingQueue();
    }
}
