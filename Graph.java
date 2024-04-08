import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes = new ArrayList<Node>();
    private List<Edge> edges = new ArrayList<Edge>();
    public void createNode(int id){
        if (getNode(id) == null){
            nodes.add(new Node(id));
            System.out.println("[GRAPH] Node with ID " + id + " has been added to the graph.");
        }
        else{
            System.out.println("[GRAPH] Node with ID " + id + " already exists in the graph.");
        }
    }

    public void createEdge(int id1, int id2, int weight){
        Node v1 = getNode(id1);
        Node v2 = getNode(id2);
        if (v1 != null){
            if (v2 != null){
                if (v1 != v2){
                    if (getEdge(id1, id2) == null && getEdge(id2, id1) == null){
                        edges.add(new Edge(v1, v2, weight));
                        System.out.println("[GRAPH] An edge with weight " + weight + " between nodes " + id1 + " and " + id2 + " has been added to the graph.");
                    }
                    else{
                        System.out.println("[GRAPH] An edge between nodes " + id1 + " and " + id2 + " already exists in the graph.");
                    }
                }
                else{
                    System.out.println("[GRAPH] Node IDs must be different.");
                }
            }
            else{
                System.out.println("[GRAPH] Node with ID " + id2 + " doesn't exist in the graph.");
            }
        }
        else{
            System.out.println("[GRAPH] Node with ID " + id1 + " doesn't exist in the graph.");
        }
    }

    public void removeEdge(int id1, int id2){
        if (getEdge(id1, id2) != null){
            edges.remove(getEdge(id1, id2));
            System.out.println("[GRAPH] Edge between nodes " + id1 + " and " + id2 + " has been removed from the graph.");
        }
        else if (getEdge(id2, id1) != null){
            edges.remove(getEdge(id2, id1));
            System.out.println("[GRAPH] Edge between nodes " + id2 + " and " + id1 + " has been removed from the graph.");
        }
        else{
            System.out.println("[GRAPH] No edge exists between nodes " + id1 + " and " + id2 + " in the graph.");
        }
    }

    public void removeNode(int id){
        Node node = getNode(id);

        if (node != null){
            List<Edge> edgesToRemove = getEdges(id);

            if (edgesToRemove != null){
                int i;
                for (i = 0; i < edgesToRemove.size(); i++){
                    System.out.println("[GRAPH] Edge with weight " + edgesToRemove.get(i).weight + " between nodes " + edgesToRemove.get(i).v1.id + " and " + edgesToRemove.get(i).v2.id + " has been removed from the graph.");
                    edges.remove(edgesToRemove.get(i));
                }
            }

            nodes.remove(node);
            System.out.println("[GRAPH] Node with ID " + id + " has been removed from the graph.");
        }
        else{
            System.out.println("[GRAPH] Node with ID " + id + " doesn't exist in the graph.");
        }
    }

    private Node getNode(int id){
        if (nodes != null){
            int i;
            for (i = 0; i < nodes.size(); i++){
                if (id == nodes.get(i).id){
                    return nodes.get(i);
                }
            }
        }

        // System.out.println("[Graph] No node found with that id");
        return null;
    }

    private List<Edge> getEdges(int id){
        List<Edge> edgesTemp = new ArrayList<Edge>();

        if (edges != null){
            int i;
            for (i = 0; i < edges.size(); i++){
                if (id == edges.get(i).v1.id || id == edges.get(i).v2.id){
                    edgesTemp.add(edges.get(i));
                }
            }
        }
        else{
            return null;
        }

        return edgesTemp;
    }


    private Edge getEdge(int id1, int id2){
        if (edges != null){
            int i = 0;
            for (i = 0; i < edges.size(); i++){
                if (id1 == edges.get(i).v1.id && id2 == edges.get(i).v2.id){
                    return edges.get(i);
                }
            }
        }

        // System.out.println("[Graph] No edge found with that ids");
        return null;
    }
}