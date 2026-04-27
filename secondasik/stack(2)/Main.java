class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;

    Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }
        top = top.next;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        Node curr = top;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public void clear() {
        top = null;
    }

    public void poplessthanmean() {
        int sum = 0;
        Node curr = top;
        int count = 0;
        while (curr != null) {
            sum += curr.data;
            count++;
            curr = curr.next;
        }
        int mean = sum / count;
        Node curr2 = top;
        Node prev = null;
        while (curr2 != null) {
            if (curr2.data < mean) {
                if (prev == null) {
                    top = curr2.next;
                } else {
                    prev.next = curr2.next;
                }
            } else {
                prev = curr2;
            }
            curr2 = curr2.next;
        }

    }
}

public class Main {

}
