package graph;

public class Edge implements IEdge{
    double weight;
    Node node0, node1;

    public Edge(double _weight, Node _node0, Node _node1) {
        this.weight = _weight;
        this.node0 = _node0;
        this.node1 = _node1;
    }

    public double getWeight() {
        return weight;
    }

    public Node getNext(Node currentNode) {
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
