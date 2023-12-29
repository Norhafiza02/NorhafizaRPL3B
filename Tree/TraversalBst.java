import java.util.LinkedList;
import java.util.Queue;

/**
 * Kelas Node merepresentasikan sebuah node dalam Binary Search Tree (BST).
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
 * Kelas TraversalBst menyediakan implementasi untuk Binary Search Tree.
 */
public class TraversalBst {

    Node root;

    public Node insert(Node root, int data) {
        // Implementasi...
    }

    /**
     * Melakukan traversal in-order pada BST.
     */
    public void inOrder(Node root) {
        // Implementasi...
    }

    /**
     * Melakukan traversal post-order pada BST.
     */
    public void postOrder(Node root) {
        // Implementasi...
    }

    /**
     * Melakukan traversal level-order (Breadth-First Search) pada BST.
     */
    public void levelOrder(Node root) {
        // Implementasi...
    }

    public static void main(String[] args) {
        TraversalBst bst = new TraversalBst();
        
        // Membuat struktur BST
        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 35);
        bst.insert(bst.root, 65);
        bst.insert(bst.root, 80);

        System.out.println("In-Order traversal:");
        bst.inOrder(bst.root);
        System.out.println();

        System.out.println("Post-Order traversal:");
        bst.postOrder(bst.root);
        System.out.println();

        System.out.println("Level-Order traversal:");
        bst.levelOrder(bst.root);
        System.out.println();
    }
}
