package graph;

public interface IEdge {
    double getWeight();
    INode getNext(INode currentNode);
}
