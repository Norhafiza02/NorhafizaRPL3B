import java.util.*;

// Representasi simpul terhubung dengan bobot menggunakan kelas Edges.
class Edges {
    String destination;
    int weight;

    public Edges(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Kelas BfsGraphTraversal untuk penelusuran graf menggunakan BFS.
public class BfsGraphTraversal {
    private Map<String, List<Edges>> adjacencyList;

    public BfsGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan tepi berbobot antara simpul sumber dan tujuan ke dalam graf.
    public void addEdge(String source, String destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    // Mendapatkan daftar tetangga dan bobot dari suatu simpul.
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Penelusuran graf menggunakan metode BFS.
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                }
            }
        }
        System.out.println();
    }

    // Metode utama untuk demonstrasi penggunaan BfsGraphTraversal.
    public static void main(String[] args) {
        BfsGraphTraversal graph = new BfsGraphTraversal();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        graph.bfsTraversal("A");
    }
}
