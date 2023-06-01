package aco;

public class Edge 
{
    double weight;
    int node0, node1;

    public Edge (double _weight, int _node0, int _node1)
    {
        this.weight = _weight;
        this.node0 = _node0;
        this.node1 = _node1;
    }

    public double getWeight() 
    {
        return weight;
    }

    public int getNext(int currentNode) 
    {
        if (currentNode == node1) return node0;
        else return node1;
    }
}
