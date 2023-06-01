package aco;

public class Node
{
    int id;
    int edge0, edge1;

    public Node(int _id, int _edge0, int _edge1)
    {
        this.edge0 = _edge0;
        this.edge1 = _edge1;
        this.id = _id;
    }

    public int getId() {
        return id;
    }
}
