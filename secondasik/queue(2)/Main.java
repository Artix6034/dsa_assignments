class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue { // fifo 1 2 3 out 2 3 in 2 3 4
    Node front; // is out index first element
    Node rear; // is in index last element

    Queue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.print("empty");
            return;
        }
        front = front.next;
        if (front == null)
            rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.print("empty");
            return;
        }
        Node curr = front;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public void clear() {
        front = null;
        rear = null;
    }

    public void removeevens() {
        Node curr = front;
        Node prev = null;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                if (prev == null) {
                    front = curr.next;
                } else {
                    prev.next = curr.next;
                }
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }
}

public class Main {

}
