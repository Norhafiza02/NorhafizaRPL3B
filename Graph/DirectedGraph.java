import java.util.*;

// Kelas untuk merepresentasikan graf berarah.
class DirectedGraph {
    // Daftar ketetanggaan untuk setiap simpul dalam graf.
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat objek DirectedGraph.
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi dari simpul sumber ke simpul tujuan.
    public void addEdge(String source, String destination) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(destination);
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

    // Metode utama untuk demonstrasi penggunaan DirectedGraph.
    public static void main(String[] args) {
        // Membuat objek DirectedGraph.
        DirectedGraph graph = new DirectedGraph();

        // Menambahkan simpul-simpul dan tepi ke dalam graf.
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // Mencetak graf untuk ditampilkan.
        graph.printGraph();
    }
}
