import java.util.*;

// Kelas Edge merepresentasikan sisi dalam graf.
// Implementasi Comparable untuk memungkinkan pembandingan berdasarkan bobot.
class Edge implements Comparable<Edge> {
    String source;       // Node sumber sisi
    String destination;  // Node tujuan sisi
    int weight;          // Bobot sisi

    // Konstruktor untuk membuat sisi baru
    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // Metode compareTo untuk membandingkan sisi berdasarkan bobotnya.
    // Digunakan untuk pengurutan sisi.
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// Kelas PrimGraphTraversal mengimplementasikan algoritma Prim untuk mencari Minimum Spanning Tree (MST).
public class PrimGraphTraversal {
    private Map<String, List<Edge>> adjacencyList; // Daftar ketetanggaan untuk setiap simpul dalam graf.

    // Konstruktor untuk membuat objek PrimGraphTraversal.
    public PrimGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi dengan bobot antara simpul sumber dan tujuan ke dalam graf.
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // Tambahkan tepi ke daftar ketetanggaan simpul sumber dan tujuan.
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // Untuk graf tidak terarah
    }

    // Metode untuk mendapatkan daftar tetangga dan bobot dari suatu simpul.
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Algoritma Prim untuk mencari MST.
    public void primMST(String start) {
        // PriorityQueue untuk memilih edge dengan bobot terkecil.
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<String> inMST = new HashSet<>();
        Map<String, Edge> edgeTo = new HashMap<>();

        // Inisialisasi dengan simpul awal.
        inMST.add(start);
        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            pq.add(edge);
            edgeTo.put(edge.destination, edge);
        }

        int totalWeight = 0; // Variabel untuk menyimpan total bobot.
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (inMST.contains(edge.destination)) continue;

            inMST.add(edge.destination);
            System.out.println(edgeTo.get(edge.destination).source + " - " + edge.destination + " [" + edge.weight + "]");
            totalWeight += edge.weight; // Menambahkan bobot edge ke total bobot.

            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                if (!inMST.contains(nextEdge.destination)) {
                    pq.add(nextEdge);
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }

        System.out.println("Total bobot MST: " + totalWeight); // Mencetak total bobot MST.
    }

    // Metode utama untuk demonstrasi penggunaan PrimGraphTraversal.
    public static void main(String[] args) {
        PrimGraphTraversal graph = new PrimGraphTraversal();

        // Menambahkan simpul dan tepi ke dalam graf.
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        
        // Menjalankan algoritma Prim dengan simpul awal A.
        graph.primMST("A");
    }
}
