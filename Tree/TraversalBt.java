import java.util.LinkedList;
import java.util.Queue;

/**
 * Kelas Node merepresentasikan sebuah node dalam Binary Tree.
 */
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

/**
 * Kelas TraversalBt untuk operasi-operasi pada Binary Tree.
 */
public class TraversalBt {

    Node root;

    /**
     * Melakukan traversal in-order pada Binary Tree.
     */
    public static void inOrder(Node node) {
        // Implementasi...
    }

    /**
     * Melakukan traversal post-order pada Binary Tree.
     */
    public static void postOrder(Node node) {
        // Implementasi...
    }

    /**
     * Melakukan traversal level-order pada Binary Tree.
     */
    public static void levelOrder(Node root) {
        // Implementasi...
    }

    public static void main(String[] args) {
        TraversalBt tree = new TraversalBt();

        // Membuat nodes
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.right.left = new Node(9);
        tree.root.right.left.left = new Node(10);

        // Menampilkan traversal in-order
        System.out.println("In-Order traversal:");
        inOrder(tree.root);
        System.out.println();

        // Menampilkan traversal post-order
        System.out.println("Post-Order traversal:");
        postOrder(tree.root);
        System.out.println();

        // Menampilkan traversal level-order
        System.out.println("Level-Order traversal:");
        levelOrder(tree.root);
        System.out.println();
    }
}
