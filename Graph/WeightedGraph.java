import java.util.*;

// Kelas Edge merepresentasikan sisi dengan bobot dalam graf berbobot.
class Edge {
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Edge dengan tujuan dan bobot.
    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Kelas WeightedGraph merepresentasikan graf berbobot.
public class WeightedGraph {
    // Map untuk menyimpan daftar tetangga untuk setiap simpul dalam graf.
    private Map<String, List<Edge>> adjacencyList;

    // Konstruktor untuk membuat objek WeightedGraph.
    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi berbobot dari simpul sumber ke simpul tujuan ke dalam graf.
    public void addEdge(String source, String destination, int weight) {
        // Pastikan simpul sumber ada dalam adjacency list.
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan tepi berbobot ke simpul sumber.
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Metode untuk mencetak graf dengan menampilkan tetangga dan bobotnya.
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    // Metode main untuk demonstrasi penggunaan WeightedGraph.
    public static void main(String[] args) {
        // Membuat objek WeightedGraph.
        WeightedGraph graph = new WeightedGraph();

        // Menambahkan simpul-simpul dan tepi berbobot ke dalam graf.
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Mencetak graf untuk ditampilkan.
        graph.printGraph();
    }
}
