package graph;

public interface IEdge {
    public double getWeight();

    public Node getNext(Node currentNode);
}
