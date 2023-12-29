import java.util.*;

// Kelas SimpleGraph merepresentasikan graf sederhana.
public class SimpleGraph {
    // Map untuk menyimpan daftar tetangga untuk setiap simpul dalam graf.
    private Map<Integer, List<Integer>> adjacencyList;

    // Konstruktor untuk membuat objek SimpleGraph.
    public SimpleGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(Integer node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi dari simpul sumber ke simpul tujuan ke dalam graf.
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
    }

    // Metode untuk mendapatkan daftar tetangga dari suatu simpul.
    public List<Integer> getNeighbors(int node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk mencetak graf.
    public void printGraph() {
        for (int node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (int neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode main untuk demonstrasi penggunaan SimpleGraph.
    public static void main(String[] args) {
        // Membuat objek SimpleGraph.
        SimpleGraph graph = new SimpleGraph();

        // Menambahkan simpul-simpul dan tepi ke dalam graf.
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        // Mencetak graf untuk ditampilkan.
        graph.printGraph();
    }
}
