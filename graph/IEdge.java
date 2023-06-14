package graph;

public interface IEdge {
    double getWeight();
    Node getNext(Node currentNode);
}
