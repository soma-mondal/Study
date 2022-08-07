package dsa.linkedlist.single;

public class LinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    LinkedList() {
        this.head = null;
    }

    LinkedList(int data) {
        this.head = new Node(data);
    }

    void addElement(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next!= null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}
