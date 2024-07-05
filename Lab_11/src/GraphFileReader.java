import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphFileReader {
    public static WeightedGraph readGraphFromFile(String filename) throws IOException {
        WeightedGraph graph = new WeightedGraph();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int vertexCount = Integer.parseInt(br.readLine());
            for (int i = 0; i < vertexCount; i++) {
                graph.addVertex(br.readLine().trim());
            }

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String start = parts[0];
                String end = parts[1];
                double weight = Double.parseDouble(parts[2]);
                graph.addEdge(start, end, weight);
            }
        }
        return graph;
    }
}