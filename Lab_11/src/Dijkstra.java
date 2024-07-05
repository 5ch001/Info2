import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra {
    public static Map<String, Double> shortestPaths(WeightedGraph graph, String startLabel) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        PriorityQueue<VertexDistance> pq = new PriorityQueue<>();

        for (String vertex : graph.getVertices()) {
            if (vertex.equals(startLabel)) {
                distances.put(vertex, 0.0);
            } else {
                distances.put(vertex, Double.POSITIVE_INFINITY);
            }
            pq.add(new VertexDistance(vertex, distances.get(vertex)));
        }

        while (!pq.isEmpty()) {
            VertexDistance current = pq.poll();
            if (current.distance == Double.POSITIVE_INFINITY) break;

            for (WeightedGraph.Edge edge : graph.getEdges(current.vertex)) {
                double newDist = distances.get(current.vertex) + edge.getWeight();
                if (newDist < distances.get(edge.getDestination().label)) {
                    distances.put(edge.getDestination().label, newDist);
                    previous.put(edge.getDestination().label, current.vertex);
                    pq.add(new VertexDistance(edge.getDestination().label, newDist));
                }
            }
        }

        return distances;
    }

    private static class VertexDistance implements Comparable<VertexDistance> {
        String vertex;
        double distance;

        VertexDistance(String vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(VertexDistance other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}
