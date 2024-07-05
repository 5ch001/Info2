import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        WeightedGraph graph = GraphFileReader.readGraphFromFile("graph.txt");

        String startStation = "S Schöneweide Bhf";
        String[] endStations = {
                "60068201511", "60066102852", "60053301433", "60120003653"
        };

        Map<String, Double> distances = Dijkstra.shortestPaths(graph, startStation);

        for (String endStation : endStations) {
            System.out.println("Shortest travel time to " + endStation + ": " + distances.get(endStation));
        }
    }
}
