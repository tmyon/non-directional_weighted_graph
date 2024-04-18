public class Node {

    public int id;
    public Node previousNode = null;
    public int pathCost = Integer.MAX_VALUE;
    public Node(int id){
        this.id = id;
    }

}