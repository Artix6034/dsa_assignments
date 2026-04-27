class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data); // 1 2 3 head = 1
        newNode.next = head; // newnode 1 2 3
        head = newNode; // newnode 1 2 3
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void removeLast() {
        if (head == null) { // no elements
            System.out.print("empty");
            return;
        }
        if (head.next == null) {
            head = null; // if we have one element
            return;
        }
        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public void display() {
        if (head == null) {
            System.out.print("empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + ", ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public void search(int value) {
        Node curr = head;
        int index = 0;
        while (curr != null) {
            if (curr.data == value) {
                System.out.println("index: " + index);
                return;
            }
            curr = curr.next;
            index++;
        }
        System.out.println("not found");
    }

    public void insert(int data, int index) {
        Node newNode = new Node(data);
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next; // 9 > null
        curr.next = newNode; // 5 3 7 > 9 > null
    }

    public void removeByValue(int data) {
        if (head == null) {
            System.out.print("empty");
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.data == data) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.print("not found");
    }

    public void merge(LinkedList list) {
        if (list.head == null) {
            return;
        }
        if (head == null) {
            head = list.head;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = list.head;
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) { // 1 2 3 null
            next = curr.next; // 2 3 null -
            curr.next = prev; // null 1 2 3
            prev = curr; // 1 2 3 null
            curr = next; // 2 3 null -
        }
        head = prev;
    }

    public void sort() {
        if (head == null)
            return;
        Node sorted = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            if (sorted == null || sorted.data >= curr.data) {
                curr.next = sorted;
                sorted = curr;
            } else {
                Node temp = sorted;
                while (temp.next != null && temp.next.data < curr.data) {
                    temp = temp.next;
                }
                curr.next = temp.next;
                temp.next = curr;
            }
            curr = next;
        }
        head = sorted;
    }
}

public class Main {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addLast(3);
        list.addLast(5);
        list.addLast(7);
        list.addFirst(1);
        list.display();
        System.out.println();

        list.removeLast();
        list.display();
        System.out.println();

        list.search(3);
        list.search(99);

        list.insert(9, 2);
        list.display();
        System.out.println();

        list.removeByValue(9);
        list.display();
        System.out.println();

        LinkedList list2 = new LinkedList();
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);
        list.merge(list2);
        list.display();
        System.out.println();

        list.reverse();
        list.display();
        System.out.println();

        LinkedList list3 = new LinkedList();
        list3.addLast(4);
        list3.addLast(1);
        list3.addLast(8);
        list3.addLast(2);
        list3.addLast(6);
        list3.sort();
        list3.display();
        System.out.println();
    }
}