import java.util.*;

// Kelas StringGraph merepresentasikan graf dengan simpul berjenis String.
public class StringGraph {
    // Map untuk menyimpan daftar tetangga untuk setiap simpul dalam graf.
    private Map<String, List<String>> adjacencyList;

    // Konstruktor untuk membuat objek StringGraph.
    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi dari simpul sumber ke simpul tujuan ke dalam graf.
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
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

    // Metode main untuk demonstrasi penggunaan StringGraph.
    public static void main(String[] args) {
        // Membuat objek StringGraph.
        StringGraph graph = new StringGraph();

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
