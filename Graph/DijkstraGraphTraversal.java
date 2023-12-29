// Kelas yang merepresentasikan tepi graf dengan destinasi dan bobotnya.
class Sisi {
    String destination;
    int weight;

    // Konstruktor untuk menginisialisasi tepi dengan destinasi dan bobot.
    public Sisi(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// Kelas utama untuk penelusuran graf menggunakan algoritma Dijkstra.
public class DijkstraGraphTraversal {
    // Daftar ketetanggaan untuk setiap simpul dalam graf.
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    // Metode untuk menambahkan simpul baru ke dalam graf.
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Metode untuk menambahkan tepi dengan bobot antara simpul sumber dan tujuan ke dalam graf.
    public void addEdge(String source, String destination, int weight) {
        addNode(source);
        addNode(destination);

        // Tambahkan tepi ke daftar ketetanggaan simpul sumber dan tujuan.
        adjacencyList.get(source).add(new Sisi(destination, weight));
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    // Metode untuk menjalankan algoritma Dijkstra dan menghitung jarak terpendek dari simpul awal ke simpul akhir.
    public int dijkstra(String start, String end) {
        // Inisialisasi struktur data untuk menyimpan jarak terpendek.
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<String, Integer> distances = new HashMap<>();
        Set<String> settled = new HashSet<>();

        // Set semua jarak awal ke tak terhingga, kecuali simpul awal yang diatur ke 0.
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        // Loop utama algoritma Dijkstra.
        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();
            if (current.equals(end)) {
                return distances.get(end);
            }

            if (settled.contains(current)) {
                continue;
            }
            settled.add(current);

            // Periksa tetangga-tetangga dan perbarui jarak terpendek jika ditemukan yang lebih kecil.
            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!settled.contains(edge.destination)) {
                    int newDistance = distances.get(current) + edge.weight;
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        // Jarak dari simpul awal ke simpul akhir.
        return distances.get(end);
    }

    // Metode utama untuk menjalankan algoritma Dijkstra dan menampilkan hasilnya.
    public static void main(String[] args) {
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();

        // Menambahkan simpul dan tepi ke dalam graf.
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);

        // Menjalankan algoritma Dijkstra dan menampilkan jarak terpendek.
        int distance = graph.dijkstra("A", "E");
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}
