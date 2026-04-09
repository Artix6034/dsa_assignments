class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    // insert

    public void insert(int data) {
        root = insertRec(root, data);
    }

    public Node insertRec(Node root, int data) {
        if (root == null)
            root = new Node(data);
        else if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
        return root;
    }

    // inorder traversal

    public void inorder() {
        inorderRec(root);
    }

    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    // min max

    public int findMin(Node root) {
        if (root.left == null)
            return root.data;
        return findMin(root.left);
    }

    public int findMax(Node root) {
        if (root.right == null)
            return root.data;
        return findMax(root.right);
    }

    // remove element

    public void remove(int data) {
        root = removeRec(root, data);
    }

    public Node removeRec(Node root, int data) {
        if (root == null)
            return root;
        if (data < root.data)
            root.left = removeRec(root.left, data);
        else if (data > root.data)
            root.right = removeRec(root.right, data);
        else {
            if (root.right == null)
                return root.left;
            if (root.left == null)
                return root.right;
            int minval = findMin(root.right);
            root.data = minval;
            root.right = removeRec(root.right, minval);
        }
        return root;
    }
    // number of even and odd elments

    int even = 0;
    int odd = 0;

    public void countevenodd(Node root) {
        even = 0;
        odd = 0;
        count(root);
        System.out.println("even: " + even);
        System.out.println("odd: " + odd);
    }

    public void count(Node root) {
        if (root == null)
            return;
        if (root.data % 2 == 0)
            even++;
        else
            odd++;
        count(root.left);
        count(root.right);
    }

    // emptiness check
    public boolean isEmpty(){
         return root == null;
        }
    
    // clear the tree
    public void clear() {
        root = null;
    }
    // height of the tree
    public void heightOfTree(){
        System.out.println("height of the tree: " + height(root));
    }
    public int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left > right) return left + 1;
        else return right + 1;
    }
    }
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);

        tree.inorder();
        tree.countevenodd(tree.root);
    }
}