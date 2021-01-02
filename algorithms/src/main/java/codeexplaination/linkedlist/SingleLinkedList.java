package codeexplaination.linkedlist;

public class SingleLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void push(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
    }

    public void printList() {
        System.out.println();
        System.out.print("Contents of linked list are: ");
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public static void main(String[] args) {
        // TODO: Complete this code
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.push(10);
        singleLinkedList.push(30);
        singleLinkedList.push(20);
        singleLinkedList.push(50);
        singleLinkedList.push(35);
        singleLinkedList.push(90);
        singleLinkedList.push(15);

        singleLinkedList.printList();

        System.out.println();
        System.out.println("Reversing the linked list now");
        singleLinkedList.reverse();
        singleLinkedList.printList();
    }
}
