public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.createNode(1);//1
        graph.createNode(7);//7
        graph.createNode(7);//7
        graph.createNode(3);//3
        graph.createEdge(1, 7, 3);// 1 7 3
        graph.createEdge(1, 7, 3);// 1 7 3
        graph.createEdge(1, 1, 3);// 1 1 3
        graph.createEdge(7, 1, 3);// 7 1 3
        graph.createEdge(3, 7, 3);// 3 7 3
        graph.removeEdge(1, 7);//7 1
        graph.removeEdge(2, 7);// 2 7
        graph.removeNode(1);//1
        graph.removeNode(2);//2

    }
}