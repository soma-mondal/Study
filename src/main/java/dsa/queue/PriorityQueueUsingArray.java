package dsa.queue;

public class PriorityQueueUsingArray {

    private static class Item {
        int data;
        //Highest value means it has the highest priority
        int priority;

        Item(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    Item[] arr = new Item[10000];
    int size = -1;

    private void enqueue(int data, int priority) {
        size++;
        Item item = new Item(data, priority);
        arr[size] = item;
    }

    private int dequeue() {
        int index = peekIndex();
        int data = arr[index].data;

        for (int i = index; i<size; i++) {
            arr[i] = arr[i+1];
        }

        size--;
        return data;
    }

    private int peek() {
        return arr[peekIndex()].data;
    }

    private int peekIndex() {
        int index = -1;
        int highestPriority = Integer.MIN_VALUE;

        for (int i = 0; i<=size; i++) {
            if (highestPriority == arr[i].priority && index > -1 && arr[i].data > arr[index].data) {
                highestPriority = arr[i].priority;
                index = i;
            } else if (arr[i].priority > highestPriority) {
                highestPriority = arr[i].priority;
                index = i;
            }
        }
        return index;
    }

    public static void main(String args[]) {
        PriorityQueueUsingArray pQueue = new PriorityQueueUsingArray();
        pQueue.enqueue(12, 3);
        pQueue.enqueue(13, 4);
        pQueue.enqueue(16, 4);
        pQueue.enqueue(10, 2);

        System.out.println("Peek: " + pQueue.peek());
        System.out.println("Dequeue: " + pQueue.dequeue());
        System.out.println("Dequeue: " + pQueue.dequeue());
        System.out.println("Dequeue: " + pQueue.dequeue());
    }

}

