package dsa.queue;

/***
 * Queue using linked list
 */
public class QueueUsingLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    QueueUsingLinkedList() {
        head = null;
    }

    void enqueue(int data) {
        Node node  = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    int front() {
        if (head!=null) {
            return head.data;
        }
        System.out.println("Empty dsa.queue.Queue");
        return  Integer.MIN_VALUE;
    }

    int dequeue() {
        int data = Integer.MIN_VALUE;
        if (head!=null) {
            Node temp = head.next;
            data = head.data;
            head = temp;
        }
        return data;
    }

    void printQueue() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static void main(String args[]) {
        QueueUsingLinkedList q = new QueueUsingLinkedList();
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(4);
        q.enqueue(5);
        q.printQueue();

    }

}
