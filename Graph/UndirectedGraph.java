import java.util.*;

// Kelas UndirectedGraph merepresentasikan graf tidak terarah.
public class UndirectedGraph {
    // Map untuk menyimpan daftar tetangga untuk setiap simpul dalam graf.
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat objek UndirectedGraph.
    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi dari simpul sumber ke simpul tujuan ke dalam graf (dalam kedua arah).
    public void addEdge(String source, String destination) {
        // Pastikan kedua node ada dalam adjacency list.
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan dan sebaliknya.
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Metode untuk mendapatkan daftar tetangga dari suatu simpul.
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Metode untuk mencetak graf.
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // Metode main untuk demonstrasi penggunaan UndirectedGraph.
    public static void main(String[] args) {
        // Membuat objek UndirectedGraph.
        UndirectedGraph graph = new UndirectedGraph();

        // Menambahkan simpul-simpul dan tepi ke dalam graf.
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");

        // Mencetak graf untuk ditampilkan.
        graph.printGraph();
    }
}
