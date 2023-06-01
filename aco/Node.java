package aco;

import java.util.LinkedList;
import java.util.List;

public class Node
{
    int id;
    List<AcoEdge> edges;

    public Node(int _id)
    {
        this.id = _id;
        edges = new LinkedList<AcoEdge>();
    }

    public int getId() {
        return id;
    }

    public void addAcoEdge(AcoEdge new_AcoEdge)
    {
        edges.add(new_AcoEdge);
    }

    
}
