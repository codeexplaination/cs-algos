package codeexplaination.trees;

/**
 * This class provides implementation of binary search tree.
 * </p>
 * Implementation for following operations are provided in the code below:
 * <li>Search a node</li>
 * <li>Add a node</li>
 * <li>Delete a node</li>
 */
public class BinarySearchTree {

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

    public Node search(Node root, int dataToSearch) {
        if (root == null || root.data == dataToSearch) {
            return root;
        }

        if (root.data < dataToSearch)
            return search(root.right, dataToSearch);

        return search(root.left, dataToSearch);
    }

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
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    /**
     * When we delete a node, there are three possibilities.
     * <li>Node to be deleted is a leaf node</li><b>Just delete the node</b>
     * <li>Node to be deleted has only one child</li><b>Copy the child to the node and delete the child</b>
     * <li>Node to be deleted has two children</li>
     * <b>Find the inorder successor of the node. Copy the contents and delete the inorder successor node</b>
     *
     * @param data
     */
    public void delete(int data) {
        root = deleteRecord(root, data);
    }

    private Node deleteRecord(Node root, int data) {
        // if the tree is empty
        if (root == null) {
            return root;
        }

        if (data < root.data) { // traverse down the tree on left
            root.left = deleteRecord(root.left, data);
        } else if (data > root.data) { // traverse down the tree on right
            root.right = deleteRecord(root.right, data);
        } else {
            if (root.left == null) { // only right node is present
                return root.right;
            } else if (root.right == null) { // only left node is present
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = deleteRecord(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(100);
        binarySearchTree.insert(90);
        binarySearchTree.insert(50);
        binarySearchTree.insert(53);
        binarySearchTree.insert(12);

        System.out.println("Contents of tree are: ");
        binarySearchTree.printInorder();
        System.out.println();

        int dataToDelete = 30;
        Node search = binarySearchTree.search(binarySearchTree.root, dataToDelete);
        System.out.println("Searched record is: " + search.data);
        System.out.println();

        System.out.println("Now trying to delete the record " + dataToDelete);
        binarySearchTree.delete(dataToDelete);

        System.out.println("Post deletion the contents of tree are: ");
        binarySearchTree.printInorder();
        System.out.println();

        dataToDelete = 50;
        System.out.println("Now trying to delete the record " + dataToDelete);
        binarySearchTree.delete(dataToDelete);

        System.out.println("Post deletion the contents of tree are: ");
        binarySearchTree.printInorder();
        System.out.println();
    }
}
