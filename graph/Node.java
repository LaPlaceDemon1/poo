package graph;

import java.util.LinkedList;
import java.util.List;

public class Node
{
    int id;
    List<Edge> edges;

    public Node(int _id)
    {
        this.id = _id;
        edges = new LinkedList<Edge>();
    }

    public int getId() {
        return id;
    }

    public void addEdge(Edge new_Edge)
    {
        edges.add(new_Edge);
    }

    public List<Edge> getEdges()
    {
        return edges;
    }
    
}
