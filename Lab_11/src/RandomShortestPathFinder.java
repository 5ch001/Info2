import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomShortestPathFinder {
    public static void findRandomShortestPath(WeightedGraph graph) {
        List<String> vertices = new ArrayList<>(graph.getVertices());
        Random rand = new Random();
        String startVertex = vertices.get(rand.nextInt(vertices.size()));
        String endVertex = vertices.get(rand.nextInt(vertices.size()));

        System.out.println("Finding shortest path from " + startVertex + " to " + endVertex);

        Map<String, Double> distances = Dijkstra.shortestPaths(graph, startVertex);
        System.out.println("Shortest path from " + startVertex + " to " + endVertex + " is " + distances.get(endVertex));
    }
}
