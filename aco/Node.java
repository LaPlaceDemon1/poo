package aco;

import java.util.List;

public class Node
{
    int id;
    List<AcoEdge> edges;

    public Node(int _id)
    {
        this.id = _id;
    }

    public int getId() {
        return id;
    }

    public void addAcoEdge(AcoEdge new_AcoEdge)
    {
        edges.add(new_AcoEdge);
    }

    
}
