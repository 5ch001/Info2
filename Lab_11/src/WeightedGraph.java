import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WeightedGraph {
    private Map<String, Vertex> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addVertex(String label) {
        vertices.put(label, new Vertex(label));
    }

    public void addEdge(String startLabel, String endLabel, double weight) {
        Vertex startVertex = vertices.get(startLabel);
        Vertex endVertex = vertices.get(endLabel);
        if (startVertex != null && endVertex != null) {
            startVertex.edges.add(new Edge(endVertex, weight));
        }
    }

    public void removeVertex(String label) {
        Vertex vertex = vertices.remove(label);
        if (vertex != null) {
            for (Vertex v : vertices.values()) {
                v.edges.removeIf(edge -> edge.destination.equals(vertex));
            }
        }
    }

    public void removeEdge(String startLabel, String endLabel) {
        Vertex startVertex = vertices.get(startLabel);
        if (startVertex != null) {
            startVertex.edges.removeIf(edge -> edge.destination.label.equals(endLabel));
        }
    }

    public double getEdgeWeight(String startLabel, String endLabel) {
        Vertex startVertex = vertices.get(startLabel);
        if (startVertex != null) {
            for (Edge edge : startVertex.edges) {
                if (edge.destination.label.equals(endLabel)) {
                    return edge.weight;
                }
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    public Set<String> getVertices() {
        return vertices.keySet();
    }

    public List<Edge> getEdges(String label) {
        Vertex vertex = vertices.get(label);
        if (vertex != null) {
            return vertex.edges;
        }
        return null;
    }

    public class Vertex {
        String label;
        List<Edge> edges;

        Vertex(String label) {
            this.label = label;
            this.edges = new LinkedList<>();
        }
    }

    public static class Edge {
        Vertex destination;
        double weight;

        Edge(Vertex destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public Vertex getDestination() {
            return destination;
        }

        public double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return destination.label + "(" + weight + ")";
        }
    }
}
