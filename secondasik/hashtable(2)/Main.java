class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable {
    Node[] table;
    int size;

    HashTable(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    public int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("table[" + i + "] = ");
            Node curr = table[i];
            while (curr != null) {
                System.out.print("(" + curr.key + ", " + curr.value + ") -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;
        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    table[index] = curr.next;
                } else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            Node curr = table[i];
            while (curr != null) {
                sum += curr.value;
                curr = curr.next;
            }
        }
        return sum;
    }

    public int findmin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            Node curr = table[i];
            while (curr != null) {
                if (curr.value < min)
                    min = curr.value;
                curr = curr.next;
            }
        }
        return min;
    }

    public int findmax() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            Node curr = table[i];
            while (curr != null) {
                if (curr.value > max) {
                    max = curr.value;
                }
                curr = curr.next;
            }
        }
        return max;
    }

    public void evenodd() {
        System.out.print("even: ");
        for (int i = 0; i < size; i++) {
            Node curr = table[i];
            while (curr != null) {
                if (curr.value % 2 == 0)
                    System.out.print(curr.value + " ");
                curr = curr.next;
            }
        }
        System.out.print("\nodd: ");
        for (int i = 0; i < size; i++) {
            Node curr = table[i];
            while (curr != null) {
                if (curr.value % 2 != 0)
                    System.out.print(curr.value + " ");
                curr = curr.next;
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable(5);
        ht.put(8, 10);
        ht.put(2, 3);
        ht.put(7, 8);
        ht.put(15, 6);
        ht.put(3, 99);

        ht.display();
        System.out.println("Sum: " + ht.sum());
        System.out.println("Min: " + ht.findmin());
        System.out.println("Max: " + ht.findmax());
        ht.evenodd();

        ht.remove(7);
        System.out.println("\nAfter remove(7):");
        ht.display();
    }
}
