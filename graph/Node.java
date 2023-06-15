package graph;
import java.util.ArrayList;

public class Node implements INode{
    int id;
    ArrayList<IEdge> edges;

    public Node(int _id)
    {
        this.id = _id;
        edges = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addEdge(IEdge new_Edge)
    {
        this.edges.add(new_Edge);
    }

    public boolean isEqual(INode other_node)
    {
        return (this.id == other_node.getId());
    }


    public ArrayList<IEdge> getEdges()
    {
        return edges;
    }
    
}
