package graph;
import java.util.ArrayList;

public class Node implements INode{
    int id;
    ArrayList<Edge> edges;

    public Node(int _id)
    {
        this.id = _id;
        edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addEdge(Edge new_Edge)
    {
        this.edges.add(new_Edge);
    }

    public boolean isEqual(Node other_node)
    {
        return (this.id == other_node.getId());
    }


    public ArrayList<Edge> getEdges()
    {
        return edges;
    }
    
}
