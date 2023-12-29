/**
 * Kelas Node merepresentasikan sebuah node dalam pohon biner.
 * Setiap node memiliki data dan dua anak: kiri dan kanan.
 */

 class Node {
    String value;
    Node left;
    Node right;

    /**
     * Konstruktor untuk kelas Node.
     * @param value Nilai dari node.
     */
    public Node(String value) {
        this.value = value;
        left = null;
        right = null;
    }
}

/**
 * Kelas StringBst merepresentasikan sebuah pohon biner.
 */
class StringBst {
    Node root;

    /**
     * Konstruktor default, menginisialisasi root menjadi null.
     */
    public StringBst() {
        root = null;
    }

    /**
     * Menyisipkan sebuah node baru ke pohon biner.
     * @param root Node root saat ini.
     * @param value Nilai yang akan disisipkan.
     * @return Node root yang baru.
     */
    public Node insert(Node root, String value) {
        // Implementasi...
    }

    /**
     * Melakukan traversal pre-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void preorder(Node root) {
        // Implementasi...
    }

    /**
     * Melakukan traversal in-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void inorder(Node root) {
        // Implementasi...
    }

    /**
     * Melakukan traversal post-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void postorder(Node root) {
        // Implementasi...
    }

    /**
     * Melakukan traversal level-order pada pohon biner.
     * @param root Node root saat ini.
     */
    public void levelOrder(Node root) {
        // Implementasi...
    }

    /**
     * Mencetak pohon biner dalam bentuk struktur tree folder.
     * @param node Node awal (biasanya root).
     * @param prefix Prefix untuk baris saat ini.
     * @param isTail Apakah node ini adalah anak terakhir dari parentnya.
     */
    public void printTree(Node node, String prefix, boolean isTail) {
        // Implementasi...
    }

    /**
     * Metode main untuk mengeksekusi kode.
     * @param args Argumen dari baris perintah.
     */
    public static void main(String[] args) {
        // Implementasi...
    }
}
