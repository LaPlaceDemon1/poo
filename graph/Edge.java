package graph;

public class Edge implements IEdge{
    double weight;
    INode node0, node1;

    public Edge(double _weight, INode _node0, INode _node1) {
        this.weight = _weight;
        this.node0 = _node0;
        this.node1 = _node1;
    }

    public double getWeight() {
        return weight;
    }

    public INode getNext(INode currentNode) {
        if (currentNode.getId() == node1.getId())
            return node0;
        else if (currentNode.getId() == node0.getId())
            return node1;
        else {
            System.out.println("Error: Edge.getNext() called with wrong node");
            return null;
        }
    }
}
