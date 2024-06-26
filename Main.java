import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.createNode(1);
        graph.createNode(2);
        graph.createNode(3);
        graph.createNode(4);
        graph.createNode(5);
        graph.createNode(6);
        graph.createNode(7);
        graph.createEdge(1, 4, 9);
        graph.createEdge(1, 3, 6);
        graph.createEdge(4, 5, 2);
        graph.createEdge(5, 3, 4);
        graph.createEdge(5, 7, 3);
        graph.createEdge(7, 6, 1);
        graph.createEdge(6, 2, 2);
        graph.createEdge(6, 5, 3);
        graph.createEdge(7, 3, 5);

        int node1 = 1;
        int node2 = 7;

        System.out.println("[Main] Shortest path cost between " + node1 + " and " + node2 + " is " + graph.shortestPath(node1, node2));
        System.out.println("[Main] Shortest path cost: " + graph.shortestPath(1, 4));
        System.out.println("[Main] Shortest path cost: " + graph.shortestPath(3, 6));

        List<Edge> mstKruskal = graph.kruskal();

        System.out.println("[Main][Kruskal] Minimum Spanning Tree edges:");
        for (Edge edge : mstKruskal) {
            System.out.println("Edge from " + edge.v1.id + " to " + edge.v2.id + " with weight " + edge.weight);
        }

        List<Edge> mstPrim = graph.prim();

        System.out.println("[Main][Prim] Minimum Spanning Tree edges:");
        for (Edge edge : mstPrim) {
            System.out.println("Edge from " + edge.v1.id + " to " + edge.v2.id + " with weight " + edge.weight);
        }

        System.out.println("Chromatic number: " + graph.chromaticNumber());

    }
}